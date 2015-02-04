package io.vteial.seetu.web.system;

import io.vteial.seetu.model.Account
import io.vteial.seetu.model.AccountTransaction
import io.vteial.seetu.model.Address
import io.vteial.seetu.model.AutoNumber
import io.vteial.seetu.model.Country
import io.vteial.seetu.model.Subscriber
import io.vteial.seetu.model.Chit
import io.vteial.seetu.model.ChitTransaction
import io.vteial.seetu.model.User

try {

	entities = ChitTransaction.findAll()
	entities.each { entity ->
		entity.delete()
	}
	println entities.size() + ' itemTransactions deleted'

	entities = Account.findAll()
	entities.each { entity ->
		entity.balance = 0
		entity.save()
	}
	println entities.size() + ' accounts deleted'

	entities = AccountTransaction.findAll()
	entities.each { entity ->
		entity.delete()
	}
	println entities.size() + ' accountTransactions deleted'

	println 'Deleted all...'
}
catch(Throwable t) {
	t.printStackTrace(out)
}