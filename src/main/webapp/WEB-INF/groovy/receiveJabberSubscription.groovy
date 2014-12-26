
def subscription = xmpp.parseSubscription(request)
System.out.println(subscription)
log.info "Subscription from ${subscription.fromJid.id}: ${subscription.subscriptionType}}"
