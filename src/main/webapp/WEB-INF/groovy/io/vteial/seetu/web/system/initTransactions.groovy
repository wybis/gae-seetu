package io.vteial.seetu.web.system;

import groovy.time.TimeCategory
import io.vteial.seetu.model.AccountTransaction
import io.vteial.seetu.model.Item
import io.vteial.seetu.model.ItemTransaction
import io.vteial.seetu.model.User
import io.vteial.seetu.model.constants.AccountTransactionType

println 'initTransactions started...'

try {

	User user = User.get('vteial')
	// TODO : login as vteial
	User sessionUser = user

	Item item = Item.get(1)

	float subscriptionAmount = item.value / item.totalSubscribers

	List<Double> winningBidAmounts = [4600, 5100, 5300, 5600, 5800, 5900]

	Date auctionDate = item.auctionDate
	use(TimeCategory) {
		for(int j = 0; j < winningBidAmounts.size(); j++) {

			for(int i = 0; i < item.totalSubscribers; i++) {

				AccountTransaction accTran = new AccountTransaction()
				accTran.type = AccountTransactionType.DEPOSIT
				accTran.amount = subscriptionAmount
				String s = 'Credit subscription amount for '
				s += String.format('%tb, %<tY', auctionDate)
				accTran.description = s
				accTran.accountId = item.subscriberIds[i]
				accountService.addTransaction(sessionUser, accTran)
			}
			ItemTransaction itemTran = new ItemTransaction()
			itemTran.itemId = item.id
			itemTran.winningBidAmount = winningBidAmounts[j]
			itemTran.winnerAccountId = item.subscriberIds[j]
			itemTran.nthBid = (j+1)
			auctionDate += 1.month
			itemTran.date = auctionDate
			itemService.addTransaction(sessionUser, itemTran)
		}
	}

}
catch(Throwable t) {
	t.printStackTrace(out)
}

println 'initTransactions finished...'
