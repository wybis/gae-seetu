package io.vteial.seetu.web.subscriber

import io.vteial.seetu.model.Subscriber

List<Subscriber> customers = Subscriber.findAll()

response.contentType = 'application/json'
jsonObjectMapper.writeValue(out, customers)
