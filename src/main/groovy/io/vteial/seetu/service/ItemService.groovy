package io.vteial.seetu.service;

import io.vteial.seetu.model.Item
import io.vteial.seetu.model.ItemTransaction
import io.vteial.seetu.model.User
import io.vteial.seetu.service.exceptions.ModelAlreadyExistException

interface ItemService {

	void add(User sessionUser, Item user) throws ModelAlreadyExistException

	void addTransaction(User sessionUser, ItemTransaction itemTran)
}
