
def msg = xmpp.parseMessage(request)
//System.out.println(msg)
//log.info "Received from ${msg.from} with body ${msg.body}"

s = """Received Jabber Message
	From  : ${msg.from}
	Body  : ${msg.body}
""" 
log.info s