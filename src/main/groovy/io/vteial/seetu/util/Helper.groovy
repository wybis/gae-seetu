package io.vteial.seetu.util

import javax.servlet.http.HttpServletRequest

public class Helper {

	public static String getDomainPrefix(def request, def app) {
		String appEnvName = app.env.name

		String s = 'http://'
		if(appEnvName.equals('Production')) {
			s += app.id + '.appspot.com'
		}
		else {
			s += request.localAddr + ':' + request.localPort
		}

		return s
	}
}
