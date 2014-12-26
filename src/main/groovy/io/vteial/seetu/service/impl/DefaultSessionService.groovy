package io.vteial.seetu.service.impl;

import groovyx.gaelyk.logging.GroovyLogger
import io.vteial.seetu.model.User
import io.vteial.seetu.service.SessionService
import io.vteial.seetu.service.exceptions.InvalidCredentialException
import io.vteial.seetu.service.exceptions.ModelNotFoundException

import javax.servlet.http.HttpSession

public class DefaultSessionService extends AbstractService implements
SessionService {

	GroovyLogger log = new GroovyLogger(DefaultSessionService.class.getName())

	boolean localMode

	Map<String, Object> app

	com.google.appengine.api.users.UserService appUserService

	@Override
	public Map<String, Object> properties(HttpSession session, com.google.appengine.api.users.User appUser) {
		def props             = this.app.clone()

		props.localMode       = this.localMode
		props.applicationUser = appUser
		props.sessionUser     = session.user
		props.sessionId       = session.id

		return props;
	}

	@Override
	public User login(HttpSession session, User userA)
	throws InvalidCredentialException {
		User sessionUser = null

		User userE = User.get(userA.id)
		if(!userE) {
			throw new InvalidCredentialException()
		}
		if(!localMode && userE.password != userA.password) {
			throw new InvalidCredentialException()
		}
		sessionUser = userE

		session.user = sessionUser

		return sessionUser
	}

	@Override
	public void logout(HttpSession session, User user) {
		session.removeAttribute('user')
	}

	@Override
	public void changeDetails(User sessionUser, User user)
	throws ModelNotFoundException {
	}

	@Override
	public void changePassword(User sessionUser, User user)
	throws ModelNotFoundException, InvalidCredentialException {
	}

	@Override
	public void resetPassword(String userId) throws ModelNotFoundException {
	}
}
