package io.vteial.seetu.service.impl

import groovyx.gaelyk.logging.GroovyLogger
import io.vteial.seetu.model.AutoNumber
import io.vteial.seetu.model.User
import io.vteial.seetu.service.AutoNumberService

class DefaultAutoNumberService implements AutoNumberService {

	GroovyLogger log = new GroovyLogger(DefaultAutoNumberService.class.getName())

	@Override
	public long getNextNumber(String key) {
		long anId = 0

		User sessionUser = new User()
		sessionUser.id = 'system'
		anId = this.getNextNumber(sessionUser, key)

		return anId
	}

	@Override
	public long getNextNumber(User sessionUser, String key) {
		AutoNumber an = AutoNumber.get(key)

		if(an) {
			an.preUpdate(sessionUser.id)
		}
		else {
			an = new AutoNumber()
			an.id = key
			an.prePersist(sessionUser.id)
		}
		//log.info an.toString()
		an.value += 1
		an.save()
		//log.info an.toString()

		return an.value
	}
}
