package io.vteial.seetu.service.impl

import groovyx.gaelyk.logging.GroovyLogger
import io.vteial.seetu.model.Account
import io.vteial.seetu.model.AccountTransaction
import io.vteial.seetu.model.User
import io.vteial.seetu.model.constants.AccountTransactionStatus
import io.vteial.seetu.model.constants.AccountTransactionType
import io.vteial.seetu.service.AccountService
import io.vteial.seetu.service.exceptions.InSufficientFundException
import io.vteial.seetu.service.exceptions.ModelAlreadyExistException

class DefaultAccountService extends AbstractService implements AccountService {

	GroovyLogger log = new GroovyLogger(DefaultAccountService.class.getName())

	@Override
	public void add(User sessionUser, Account account)
	throws ModelAlreadyExistException {
		log.info "Pre-" + account.toString()

		account.user   = sessionUser
		account.userId = sessionUser.id

		account.id = autoNumberService.getNextNumber(Account.ID_KEY)

		account.prePersist(sessionUser.id)
		account.save()

		log.info "Post-" + account.toString()
	}

	@Override
	public void addTransaction(User sessionUser, AccountTransaction accountTran) throws InSufficientFundException {
		log.info "Pre-" + accountTran.toString()

		Account account = Account.get(accountTran.accountId)

		if (accountTran.type == AccountTransactionType.WITHDRAW && !account.hasSufficientBalance(accountTran.amount)) {
			log.info "InSufficientFundException-" + account.toString()
			throw new InSufficientFundException(account : account,  accountTran : accountTran)
		}

		if(accountTran.type == AccountTransactionType.WITHDRAW) {
			account.withdraw(accountTran.amount)
		} else {
			account.deposit(accountTran.amount)
		}

		account.preUpdate(sessionUser.id)
		account.save()

		accountTran.balance = account.balance

		if(!accountTran.description) {
			accountTran.description = '-'
		}

		if(!accountTran.date) {
			accountTran.date = new Date()
		}

		accountTran.status = AccountTransactionStatus.COMPLETE

		accountTran.userId = sessionUser.id

		accountTran.id = autoNumberService.getNextNumber(AccountTransaction.ID_KEY)

		accountTran.prePersist(sessionUser.id)
		accountTran.save()

		log.info "Post-" + accountTran.toString()
	}
}
