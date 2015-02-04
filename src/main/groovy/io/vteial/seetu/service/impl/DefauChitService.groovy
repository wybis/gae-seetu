package io.vteial.seetu.service.impl

import groovyx.gaelyk.logging.GroovyLogger
import io.vteial.seetu.model.Account
import io.vteial.seetu.model.AccountTransaction
import io.vteial.seetu.model.Chit
import io.vteial.seetu.model.ChitTransaction
import io.vteial.seetu.model.User
import io.vteial.seetu.model.constants.AccountStatus
import io.vteial.seetu.model.constants.AccountTransactionType
import io.vteial.seetu.model.constants.AccountType
import io.vteial.seetu.model.constants.ItemStatus
import io.vteial.seetu.model.constants.ItemTransactionStatus
import io.vteial.seetu.service.AccountService
import io.vteial.seetu.service.ChitService
import io.vteial.seetu.service.exceptions.ModelAlreadyExistException

class DefauChitService extends AbstractService implements ChitService {

	GroovyLogger log = new GroovyLogger(DefauChitService.class.getName())

	AccountService accountService

	@Override
	public void add(User sessionUser, Chit item)
	throws ModelAlreadyExistException {
		log.info "Pre-" + item.toString()

		Account account = new Account()
		account.name = "${item.name}-Commision"
		account.aliasName = "Commision-${item.name}"
		account.type = AccountType.COMMISION
		account.status = AccountStatus.ACTIVE

		accountService.add(sessionUser, account);

		item.commisionAccount = account
		item.commisionAccountId = account.id

		account = new Account()
		account.name = "${item.name}-Fund"
		account.aliasName = "Fund-${item.name}"
		account.type = AccountType.FUND
		account.status = AccountStatus.ACTIVE

		accountService.add(sessionUser, account);

		item.itemAccount = account
		item.itemAccountId = account.id

		item.user = sessionUser
		item.userId = sessionUser.id

		item.id = autoNumberService.getNextNumber(Chit.ID_KEY)

		item.prePersist(sessionUser.id)
		item.save()

		log.info "Post-" + item.toString()
	}

	@Override
	public void addTransaction(User sessionUser, ChitTransaction itemTran) {
		log.info "Pre-" + itemTran.date.toString()

		itemTran.item = Chit.get(itemTran.itemId)

		this.aggregateSubscriptions(sessionUser, itemTran)

		itemTran.computeDiscountAmount()
		itemTran.computeDiscountShareAmount()
		itemTran.computeCommisionAmount()
		itemTran.computeWinnderBidAmount()

		if(!itemTran.description) {
			itemTran.description = '-'
		}

		if(!itemTran.date) {
			itemTran.date = new Date()
		}

		itemTran.status = ItemTransactionStatus.COMPLETE

		itemTran.userId = sessionUser.id

		itemTran.id = autoNumberService.getNextNumber(ChitTransaction.ID_KEY)

		itemTran.prePersist(sessionUser.id)
		itemTran.save()

		log.info "Post-" + itemTran.date.toString()

		this.onTransaction(sessionUser, itemTran)

		this.payBidWinningAmount(sessionUser, itemTran)

		this.detectCommisionAmount(sessionUser, itemTran)

		this.payDiscountShares(sessionUser, itemTran)
	}

	void onTransaction(User sessionUser, ChitTransaction itemTran) {

		if(itemTran.item.totalSubscribers == itemTran.nthBid) {
			Chit item = itemTran.item
			item.status = ItemStatus.CLOSED
			item.preUpdate(sessionUser.id)
			item.save()
		}
	}

	void aggregateSubscriptions(User sessionUser, ChitTransaction itemTran) {
		float subscriptionAmount = itemTran.item.value / itemTran.item.totalSubscribers

		for(int i = 0; i < itemTran.item.totalSubscribers; i++) {
			AccountTransaction accTran = new AccountTransaction()
			accTran.type = AccountTransactionType.WITHDRAW
			accTran.amount = subscriptionAmount
			String s = 'Debit subscription amount for '
			s += String.format('%tb, %<tY', itemTran.date)
			accTran.description = s
			accTran.accountId = itemTran.item.subscriberIds[i]
			accountService.addTransaction(sessionUser, accTran)

			accTran = new AccountTransaction()
			accTran.type = AccountTransactionType.DEPOSIT
			accTran.amount = subscriptionAmount
			s = 'Credit subscription amount for '
			s += String.format('%tb, %<tY', itemTran.date)
			accTran.description = s
			accTran.accountId = itemTran.item.itemAccountId
			accountService.addTransaction(sessionUser, accTran)
		}
	}

	void payBidWinningAmount(User sessionUser, ChitTransaction itemTran) {

		AccountTransaction accTran = new AccountTransaction()
		accTran.type = AccountTransactionType.WITHDRAW
		accTran.amount = itemTran.winningBidAmount
		String s = 'Debit winning bid amount for '
		s += String.format('%tb, %<tY', itemTran.date)
		accTran.description = s
		accTran.accountId = itemTran.item.itemAccountId
		accountService.addTransaction(sessionUser, accTran)

		accTran = new AccountTransaction()
		accTran.type = AccountTransactionType.DEPOSIT
		accTran.amount = itemTran.winningBidAmount
		s = 'Credit winning bid amount for '
		s += String.format('%tb, %<tY', itemTran.date)
		accTran.description = s
		accTran.accountId = itemTran.winnerAccountId
		accountService.addTransaction(sessionUser, accTran)
	}

	void detectCommisionAmount(User sessionUser, ChitTransaction itemTran) {

		AccountTransaction accTran = new AccountTransaction()
		accTran.type = AccountTransactionType.WITHDRAW
		accTran.amount = itemTran.commisionAmount
		String s = 'Debit commision amount for '
		s += String.format('%tb, %<tY', itemTran.date)
		accTran.description = s
		accTran.accountId = itemTran.winnerAccountId
		accountService.addTransaction(sessionUser, accTran)

		accTran = new AccountTransaction()
		accTran.type = AccountTransactionType.DEPOSIT
		accTran.amount = itemTran.commisionAmount
		s = 'Credit commision amount for '
		s += String.format('%tb, %<tY', itemTran.date)
		accTran.description = s
		accTran.accountId = itemTran.item.commisionAccountId
		accountService.addTransaction(sessionUser, accTran)
	}

	void payDiscountShares(User sessionUser, ChitTransaction itemTran) {

		for(int i = 0; i < itemTran.item.totalSubscribers; i++) {
			AccountTransaction accTran = new AccountTransaction()
			accTran.type = AccountTransactionType.WITHDRAW
			accTran.amount = itemTran.discountShareAmount
			String s = 'Debit discount share for '
			s += String.format('%tb, %<tY', itemTran.date)
			accTran.description = s
			accTran.accountId = itemTran.item.itemAccountId
			accountService.addTransaction(sessionUser, accTran)

			accTran = new AccountTransaction()
			accTran.type = AccountTransactionType.DEPOSIT
			accTran.amount = itemTran.discountShareAmount
			s = 'Credit discount share for '
			s += String.format('%tb, %<tY', itemTran.date)
			accTran.description = s
			accTran.accountId = itemTran.item.subscriberIds[i]
			accountService.addTransaction(sessionUser, accTran)
		}
	}
}
