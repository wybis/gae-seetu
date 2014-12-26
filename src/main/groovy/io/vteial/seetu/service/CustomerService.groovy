package io.vteial.seetu.service;

import io.vteial.seetu.model.Customer
import io.vteial.seetu.model.User
import io.vteial.seetu.service.exceptions.ModelAlreadyExistException

interface CustomerService {

	void add(User sessionUser, Customer customer) throws ModelAlreadyExistException
}
