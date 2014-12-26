package io.vteial.seetu.web.account

import io.vteial.seetu.dto.ResponseDto
import io.vteial.seetu.model.Account

ResponseDto responseDto = new ResponseDto()

def accounts = Account.findAll()
responseDto.data = accounts

jsonCategory.respondWithJson(response, responseDto)
