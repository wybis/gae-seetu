package io.vteial.seetu.web.session

import io.vteial.seetu.dto.ResponseDto
import io.vteial.seetu.model.User


ResponseDto responseDto = new ResponseDto(type : 1, message : 'Invalid User Id or Password')
request.responseDto = responseDto

User userA = jsonObjectMapper.readValue(request.reader.text, User.class);

User userE = User.get(userA.id)
//System.out.println(userE)
if(!userE) {
	//System.out.println(1)
	//forward '/sessions/properties'
	jsonCategory.respondWithJson(response, responseDto)
	return
}

if(app.env.name == 'Production' && userE.password != userA.password) {
	//System.out.println(2)
	//forward '/sessions/properties'
	jsonCategory.respondWithJson(response, responseDto)
	return
}

session.user = userE
//System.out.println(3)
def props             = app.clone()
props.applicationUser = user
props.sessionUser     = session.user
props.sessionId       = session.id
props.localMode       = localMode
responseDto.data = props

responseDto.type = 0
responseDto.message = 'Successfully logged in...'

//forward '/sessions/properties'
jsonCategory.respondWithJson(response, responseDto)