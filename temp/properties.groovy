import io.vteial.seetu.JacksonCategory
import io.vteial.seetu.dto.ResponseDto

def props             = app.clone()
props.applicationUser = user
props.sessionUser     = session.user
props.sessionId       = session.id
//props.localMode       = localMode
props.localMode       = session.user == null

ResponseDto responseDto = request.responseDto
if(responseDto) {
	responseDto.data = props
}
else {
	responseDto = new ResponseDto(data : props)
}
jsonCategory.respondWithJson(response, responseDto)

