package io.vteial.seetu.dto

import groovy.transform.Canonical
import groovy.transform.ToString
import io.vteial.seetu.model.User

@Canonical
@ToString(includeNames=true)
class SessionUserDto implements Serializable {

	String id

	String password

	String roleId

	String firstName

	String lastName

	User user;
}
