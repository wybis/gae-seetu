package io.vteial.seetu.service.exceptions

import groovy.transform.Canonical
import io.vteial.seetu.model.Account
import io.vteial.seetu.model.AccountTransaction

@Canonical
class InSufficientFundException extends Exception {

	Account account

	AccountTransaction accountTran
}
