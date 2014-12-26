package io.vteial.seetu.web.customer

import io.vteial.seetu.dto.ResponseDto
import io.vteial.seetu.model.Customer

ResponseDto responseDto = new ResponseDto()

def customers = Customer.findAll()
responseDto.data = customers

jsonCategory.respondWithJson(response, responseDto)
