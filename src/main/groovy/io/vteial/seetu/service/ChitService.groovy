package io.vteial.seetu.service;

import io.vteial.seetu.model.Chit
import io.vteial.seetu.model.ChitTransaction
import io.vteial.seetu.model.User
import io.vteial.seetu.service.exceptions.ModelAlreadyExistException

interface ChitService {

	void add(User sessionUser, Chit user) throws ModelAlreadyExistException

	void addTransaction(User sessionUser, ChitTransaction itemTran)
}
