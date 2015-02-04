package io.vteial.seetu.dto

import groovy.transform.Canonical
import groovy.transform.ToString

@Canonical
@ToString(includeNames=true)
class UserDto implements Serializable {

	String id

	String password

	String newPassword
}
