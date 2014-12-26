package io.vteial.seetu

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import com.fasterxml.jackson.databind.ObjectMapper

class JacksonCategory {

	static ObjectMapper jsonObjectMapper = new ObjectMapper()

	static Object parseJson(HttpServletRequest request, Class clazz) {
		return jsonObjectMapper.readValue(request.reader.text, clazz);
	}

	static respondWithJson(HttpServletResponse response, def object) {
		response.contentType = 'application/json'
		jsonObjectMapper.writeValue(response.getWriter(), object)
	}
}
