package io.vteial.seetu.service;

import io.vteial.seetu.model.User
import io.vteial.seetu.service.exceptions.InvalidCredentialException
import io.vteial.seetu.service.exceptions.ModelNotFoundException

import javax.servlet.http.HttpSession

public interface SessionService {

	static String SESSION_USER_KEY = "user"

	static String SESSION_BRANCH_KEY = "branch"

	Map<String, Object> properties(HttpSession session, com.google.appengine.api.users.User appUser)

	void resetPassword(String userId) throws ModelNotFoundException

	User login(HttpSession session, User user)
	throws InvalidCredentialException

	void logout(HttpSession session, User user)

	void changeDetails(User sessionUser, User user)
	throws ModelNotFoundException

	void changePassword(User sessionUser, User user)
	throws ModelNotFoundException, InvalidCredentialException
}
