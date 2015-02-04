package io.vteial.seetu.web.system;

import io.vteial.seetu.model.Subscriber
import io.vteial.seetu.model.Chit
import io.vteial.seetu.model.Role
import io.vteial.seetu.model.User
import io.vteial.seetu.model.constants.UserStatus

println 'reset started...'

try {
	def users = []

	User user = new User()
	user.id = 'vteial'
	user.password = '1234'
	user.emailId = 'vteial@gmail.com'
	user.firstName = 'Eialarasu'
	user.lastName = 'VT'
	user.status = UserStatus.ACTIVE
	user.roleId = Role.APP_ADMIN
	users << user

	user = new User()
	user.id = 'donkhan'
	user.password = '1234'
	user.emailId = 'routetokamil@gmail.com'
	user.firstName = 'Kamil'
	user.lastName = 'Khan'
	user.status = UserStatus.ACTIVE
	user.roleId = Role.APP_ADMIN
	users << user

	user = new User()
	user.id = 'jayaramanhari'
	user.password = '1234'
	user.emailId = 'jayaramanhari@gmail.com'
	user.firstName = 'Hariharasubramanian'
	user.lastName = 'Jayaraman'
	user.status = UserStatus.ACTIVE
	user.roleId = Role.APP_ADMIN
	users << user

	user = new User()
	user.id = 'vrsumitha'
	user.password = '1234'
	user.emailId = 'sumitha.v.r@gmail.com'
	user.firstName = 'Sumitha'
	user.lastName = 'Vasanthan'
	user.status = UserStatus.ACTIVE
	user.roleId = Role.APP_ADMIN
	users << user

	users.each { u ->
		userService.add(u, u)
	}
}
catch(Throwable t) {
	t.printStackTrace(out)
}

println 'reset finished...'