package io.vteial.seetu.web.chit

import io.vteial.seetu.model.Chit

List<Chit> items = Chit.findAll()

response.contentType = 'application/json'
jsonObjectMapper.writeValue(out, items)
