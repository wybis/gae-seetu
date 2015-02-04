package io.vteial.seetu.web.chit

import io.vteial.seetu.dto.ResponseDto
import io.vteial.seetu.model.ChitTransaction

ResponseDto responseDto = new ResponseDto()

def itemTrans = ChitTransaction.findAll()
responseDto.data = itemTrans

jsonCategory.respondWithJson(response, responseDto)

