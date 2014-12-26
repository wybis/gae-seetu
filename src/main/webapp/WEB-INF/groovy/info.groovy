import com.google.apphosting.api.ApiProxy
import com.google.apphosting.api.ApiProxy.Environment

import eu.bitwalker.useragentutils.UserAgent

println '''
<html><head><title>Test</title><head><body><pre>
'''
String s = '-', schar = '-'; int noOfChars = 120;
println s.padRight(noOfChars, schar)

try {
	println "App Info = ${app}"

	println s.padRight(noOfChars, schar)

	println "Request URI = ${request.requestURI}"
	println "Request URL = ${request.requestURL}"
	headers.each { header -> println "${header.key} = ${header.value}" }

	println s.padRight(noOfChars, schar)

	Environment env = ApiProxy.getCurrentEnvironment();
	env.getAttributes().each { attr -> println "${attr.key} = ${attr.value}" }

	UserAgent userAgent = UserAgent.parseUserAgentString(headers['User-Agent'])
	println userAgent
}
catch(Throwable t) {
	t.printStackTrace(out)
}

println s.padRight(noOfChars, schar)

println '''
</pre></body></html>
'''