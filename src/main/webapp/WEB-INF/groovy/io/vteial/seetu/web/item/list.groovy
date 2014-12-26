package io.vteial.seetu.web.item

import io.vteial.seetu.model.Item

List<Item> items = Item.findAll()

response.contentType = 'application/json'
jsonObjectMapper.writeValue(out, items)
