package io.vteial.seetu.service;

import io.vteial.seetu.model.Subscriber
import io.vteial.seetu.model.User
import io.vteial.seetu.service.exceptions.ModelAlreadyExistException

interface SubscriberService {

	void add(User sessionUser, Subscriber customer) throws ModelAlreadyExistException
}
