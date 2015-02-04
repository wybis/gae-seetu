package io.vteial.seetu.web.session

import io.vteial.seetu.dto.ResponseDto
import io.vteial.seetu.dto.SessionUserDto
import io.vteial.seetu.dto.UserDto
import io.vteial.seetu.service.exceptions.InvalidCredentialException

ResponseDto responseDto = new ResponseDto(type : 1, message : 'Invalid User Id or Password')
request.responseDto = responseDto

UserDto userDto = jsonCategory.parseJson(request, UserDto.class)
try {
	SessionUserDto sessionUserDto = sessionService.login(session, userDto)
	responseDto.data = sessionService.properties(session, user)
	responseDto.type = 0
	responseDto.message = 'Successfully logged in...'
}
catch(InvalidCredentialException e) {
}

jsonCategory.respondWithJson(response, responseDto)