package io.vteial.seetu.service.impl

import groovyx.gaelyk.logging.GroovyLogger
import io.vteial.seetu.model.Account
import io.vteial.seetu.model.User
import io.vteial.seetu.model.constants.AccountStatus
import io.vteial.seetu.model.constants.AccountType
import io.vteial.seetu.service.AccountService
import io.vteial.seetu.service.UserService
import io.vteial.seetu.service.exceptions.ModelAlreadyExistException

class DefaultUserService extends AbstractService implements UserService {

	GroovyLogger log = new GroovyLogger(DefaultUserService.class.getName())

	AccountService accountService

	@Override
	public void add(User sessionUser, User user)
	throws ModelAlreadyExistException {

		User entity = User.get(user.id)
		if(entity) {
			throw new ModelAlreadyExistException()
		}

		Account account = new Account()
		account.name = "User-${user.id}"
		account.aliasName = "User-${user.firstName}"
		account.type = AccountType.ASSET
		account.status = AccountStatus.ACTIVE
		accountService.add(sessionUser, account);

		user.account = account
		user.accountId = account.id

		user.prePersist(sessionUser.id)
		user.save()
	}
}
