package io.vteial.seetu.dto

import groovy.transform.Canonical

@Canonical
class ResponseDto {

	static final int UNKNOWN = -1

	static final int SUCCESS = 0

	static final int ERROR = 1

	int type

	String message;

	Object data
}
