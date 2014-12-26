package io.vteial.seetu.web.init;

import io.vteial.seetu.util.Helper

try {
	String serverPrefix = Helper.getDomainPrefix(request, app)

	String s = serverPrefix + '/init/createUsers'
	println s
	def response = (new URL(s)).get()
	println response.text

	//	s = serverPrefix + '/init/createCustomers'
	//	println s
	//	response = (new URL(s)).get()
	//	println response.text

	s = serverPrefix + '/init/createItems'
	println s
	response = (new URL(s)).get()
	println response.text

	println 'Created all...'
}
catch(Throwable t) {
	t.printStackTrace(out)
}

//response.contentType = 'application/json'
//jsonObjectMapper.writeValue(out, responseDto)
