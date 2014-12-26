
log.info "Registering SimplePlugin started..."

binding {
}

routes {
}

before {
	//log.info "Visiting ${request.requestURI}"
	//binding.uri = request.requestURI
}

after {
	//log.info "Exiting ${request.requestURI}"
	//log.info "groovlet returned $result from its exection"
}

//categories JacksonCategory

log.info "Registering SimplePlugin finished..."