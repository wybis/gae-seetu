package io.vteial.seetu.service.impl

import groovyx.gaelyk.logging.GroovyLogger
import io.vteial.seetu.model.Account
import io.vteial.seetu.model.Customer
import io.vteial.seetu.model.User
import io.vteial.seetu.model.constants.AccountStatus
import io.vteial.seetu.model.constants.AccountType
import io.vteial.seetu.service.AccountService
import io.vteial.seetu.service.CustomerService
import io.vteial.seetu.service.exceptions.ModelAlreadyExistException

class DefaultCustomerService extends AbstractService implements CustomerService {

	GroovyLogger log = new GroovyLogger(DefaultCustomerService.class.getName())

	AccountService accountService

	@Override
	public void add(User sessionUser, Customer customer)
	throws ModelAlreadyExistException {

		Account account = new Account()
		account.name = "Customer-${customer.firstName}"
		account.aliasName = "Customer-${customer.lastName}"
		account.type = AccountType.ASSET
		account.isMinus = true
		account.status = AccountStatus.ACTIVE

		accountService.add(sessionUser, account)

		customer.account = account
		customer.accountId = account.id

		customer.user = sessionUser
		customer.userId = sessionUser.id

		customer.id = autoNumberService.getNextNumber(Customer.ID_KEY)

		customer.prePersist(sessionUser.id)
		customer.save()
	}
}
