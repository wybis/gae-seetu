package io.vteial.seetu.service.impl;

import groovyx.gaelyk.logging.GroovyLogger
import io.vteial.seetu.dto.SessionUserDto
import io.vteial.seetu.dto.UserDto
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
	public void resetPassword(String userId) throws ModelNotFoundException {
	}

	@Override
	public SessionUserDto login(HttpSession session, UserDto userDto)
	throws InvalidCredentialException {
		SessionUserDto sessionUser = null

		User user = User.get(userDto.id)
		if(!user) {
			throw new InvalidCredentialException()
		}
		if(!localMode && user.password != userDto.password) {
			throw new InvalidCredentialException()
		}

		sessionUser = new SessionUserDto(id : user.id)
		sessionUser.firstName = user.firstName
		sessionUser.lastName = user.lastName
		sessionUser.roleId = user.roleId
		sessionUser.user = user

		session.setAttribute(SESSION_USER_KEY, sessionUser)


		return sessionUser
	}

	@Override
	public void logout(HttpSession session) {
		session.removeAttribute(SESSION_USER_KEY)
	}

	@Override
	public void changeDetails(SessionUserDto sessionUser, UserDto userDto)
	throws ModelNotFoundException {
	}

	@Override
	public void changePassword(SessionUserDto sessionUser, UserDto userDto)
	throws ModelNotFoundException, InvalidCredentialException {
	}
}
