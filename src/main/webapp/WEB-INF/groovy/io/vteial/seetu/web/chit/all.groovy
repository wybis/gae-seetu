package io.vteial.seetu.web.chit

import io.vteial.seetu.dto.ResponseDto
import io.vteial.seetu.model.Chit

ResponseDto responseDto = new ResponseDto()

def items = Chit.findAll()
responseDto.data = items

jsonCategory.respondWithJson(response, responseDto)
