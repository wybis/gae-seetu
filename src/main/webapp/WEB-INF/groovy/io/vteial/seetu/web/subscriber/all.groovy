package io.vteial.seetu.web.subscriber

import io.vteial.seetu.dto.ResponseDto
import io.vteial.seetu.model.Subscriber

ResponseDto responseDto = new ResponseDto()

def customers = Subscriber.findAll()
responseDto.data = customers

jsonCategory.respondWithJson(response, responseDto)
