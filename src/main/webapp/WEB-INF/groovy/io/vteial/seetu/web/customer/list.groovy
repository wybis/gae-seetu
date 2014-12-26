package io.vteial.seetu.web.customer

import io.vteial.seetu.model.Customer

List<Customer> customers = Customer.findAll()

response.contentType = 'application/json'
jsonObjectMapper.writeValue(out, customers)
