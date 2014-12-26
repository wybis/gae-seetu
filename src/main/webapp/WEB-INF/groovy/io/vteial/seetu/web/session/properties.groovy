import io.vteial.seetu.JacksonCategory
import io.vteial.seetu.dto.ResponseDto

def props = sessionService.properties(session, user)

ResponseDto responseDto = request.responseDto
if(responseDto) {
	responseDto.data = props
}
else {
	responseDto = new ResponseDto(data : props)
}
jsonCategory.respondWithJson(response, responseDto)

