
def presence = xmpp.parsePresence(request)
System.out.println(presence)
log.info "${presence.fromJid.id} is ${presence.available ? '' : 'not'} available"