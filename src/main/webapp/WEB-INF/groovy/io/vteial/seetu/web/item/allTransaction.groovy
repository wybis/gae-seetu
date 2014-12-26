package io.vteial.seetu.web.item

import io.vteial.seetu.dto.ResponseDto
import io.vteial.seetu.model.ItemTransaction

ResponseDto responseDto = new ResponseDto()

def itemTrans = ItemTransaction.findAll()
responseDto.data = itemTrans

jsonCategory.respondWithJson(response, responseDto)

