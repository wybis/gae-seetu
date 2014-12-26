package io.vteial.seetu.service;

import io.vteial.seetu.model.Account
import io.vteial.seetu.model.AccountTransaction
import io.vteial.seetu.model.User
import io.vteial.seetu.service.exceptions.InSufficientFundException
import io.vteial.seetu.service.exceptions.ModelAlreadyExistException

interface AccountService {

	void add(User sessionUser, Account account) throws ModelAlreadyExistException

	void addTransaction(User sessionUser, AccountTransaction accountTran) throws InSufficientFundException
}
