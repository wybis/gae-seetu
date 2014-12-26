package io.vteial.seetu.web.session;

import io.vteial.seetu.dto.ResponseDto

session.removeAttribute('user')

ResponseDto rm = new ResponseDto(message : 'Successfully logged out...')

forward '/sessions/properties'