package io.vteial.seetu.web.user

import io.vteial.seetu.dto.ResponseDto
import io.vteial.seetu.model.User

ResponseDto responseDto = new ResponseDto()

def customers = User.findAll()
responseDto.data = customers

jsonCategory.respondWithJson(response, responseDto)
