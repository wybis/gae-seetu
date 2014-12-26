package io.vteial.seetu.web.account

import io.vteial.seetu.dto.ResponseDto
import io.vteial.seetu.model.AccountTransaction

ResponseDto responseDto = new ResponseDto()

def accountTrans = AccountTransaction.findAll()
responseDto.data = accountTrans

jsonCategory.respondWithJson(response, responseDto)

