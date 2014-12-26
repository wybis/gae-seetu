package io.vteial.seetu.web.item

import io.vteial.seetu.dto.ResponseDto
import io.vteial.seetu.model.Item

ResponseDto responseDto = new ResponseDto()

def items = Item.findAll()
responseDto.data = items

jsonCategory.respondWithJson(response, responseDto)
