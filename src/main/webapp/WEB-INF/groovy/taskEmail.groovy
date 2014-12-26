import groovy.json.JsonParserType
import groovy.json.JsonSlurper

log.info "Processing Task ${headers['X-AppEngine-TaskName']} started..."
try {
	//StringBuilder sb = new StringBuilder()
	//headers.each { header -> sb << "${header.key} = ${header.value} \n" }
	//sb << request.reader.text
	//log.info sb.toString()

	def jsonSlurper = new JsonSlurper(type: JsonParserType.INDEX_OVERLAY)
	def payloadJson = jsonSlurper.parseText(request.reader.text)

	mail.send(
			from	: payloadJson.from,
			to		: payloadJson.to,
			subject	: payloadJson.subject,
			textBody: payloadJson.body
			)
}
catch(Throwable t) {
	log.severe t.message
}
log.info "Processing Task ${headers['X-AppEngine-TaskName']} finished."