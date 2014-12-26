package io.vteial.seetu.web.user

import io.vteial.seetu.dto.ResponseDto
import io.vteial.seetu.model.User

ResponseDto responseDto = new ResponseDto()

def users = User.findAll()
responseDto.data = users

jsonCategory.respondWithJson(response, responseDto)