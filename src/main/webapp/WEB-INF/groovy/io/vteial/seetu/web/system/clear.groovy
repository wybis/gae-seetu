package io.vteial.seetu.web.system;

import io.vteial.seetu.model.Account
import io.vteial.seetu.model.AccountTransaction
import io.vteial.seetu.model.Address
import io.vteial.seetu.model.AutoNumber
import io.vteial.seetu.model.Country
import io.vteial.seetu.model.Customer
import io.vteial.seetu.model.Item
import io.vteial.seetu.model.ItemTransaction
import io.vteial.seetu.model.User

try {

	def entities = AutoNumber.findAll()
	entities.each { entity ->
		entity.delete()
	}
	println entities.size() + ' autonNumbers deleted'

	entities = Country.findAll()
	entities.each { entity ->
		entity.delete()
	}
	println entities.size() + ' countrys deleted'

	entities = Address.findAll()
	entities.each { entity ->
		entity.delete()
	}
	println entities.size() + ' addresses deleted'

	entities = User.findAll()
	entities.each { entity ->
		entity.delete()
	}
	println entities.size() + ' users deleted'

	entities = Customer.findAll()
	entities.each { entity ->
		entity.delete()
	}
	println entities.size() + ' customers deleted'

	entities = Item.findAll()
	entities.each { entity ->
		entity.delete()
	}
	println entities.size() + ' items deleted'

	entities = ItemTransaction.findAll()
	entities.each { entity ->
		entity.delete()
	}
	println entities.size() + ' itemTransactions deleted'

	entities = Account.findAll()
	entities.each { entity ->
		entity.delete()
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