package io.vteial.seetu.web.session

import io.vteial.seetu.dto.ResponseDto
import io.vteial.seetu.model.User
import io.vteial.seetu.service.exceptions.InvalidCredentialException

ResponseDto responseDto = new ResponseDto(type : 1, message : 'Invalid User Id or Password')
request.responseDto = responseDto

User userA = jsonCategory.parseJson(request, User.class)
try {
	io.vteial.seetu.model.User userE = sessionService.login(session, userA)
	responseDto.data = sessionService.properties(session, user)
	responseDto.type = 0
	responseDto.message = 'Successfully logged in...'
}
catch(InvalidCredentialException e) {
}

jsonCategory.respondWithJson(response, responseDto)