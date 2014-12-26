email						to : '/receiveEmail.groovy'

jabber	chat,	 			to : '/receiveJabberMessage.groovy'
jabber 	presence,			to : '/receiveJabberpresence.groovy'
jabber	subscription, 		to : '/receiveJabberSubscription.groovy'

get 	'/favicon.ico',		redirect : '/assets/favicon.png'
get     '/',				redirect : '/index'
get     '/index',			forward  : '/index.groovy'
get 	'/info',			forward  : '/info.groovy'
//get	'/json',			forward  : '/json.groovy'
all 	'/_ah/warmup',		forward  : '/ping.groovy'

// cron
get 	'/cron/dailyBackup',			forward : '/cron/dailyBackup.groovy'

// data
get 	'/system/init',	    			forward : '/io/vteial/seetu/web/system/init.groovy'
get 	'/system/clear',   				forward : '/io/vteial/seetu/web/system/clear.groovy'
get 	'/system/initTransactions',   	forward : '/io/vteial/seetu/web/system/initTransactions.groovy'
get 	'/system/clearTransactions',   	forward : '/io/vteial/seetu/web/system/clearTransactions.groovy'

// session
get  	'/sessions/properties',			forward : '/io/vteial/seetu/web/session/properties.groovy'
post 	'/sessions/login',     			forward : '/io/vteial/seetu/web/session/login.groovy'
get  	'/sessions/logout',    			forward : '/io/vteial/seetu/web/session/logout.groovy'

// user
get      '/users',          			forward : '/io/vteial/seetu/web/user/list.groovy'
//get    '/users/user/@id', 			forward : '/io/vteial/seetu/web/user/findById.groovy?id=@id'
//post   '/users/user',     			forward : '/io/vteial/seetu/web/user/create.groovy'
//put    '/users/user/@id', 			forward : '/io/vteial/seetu/web/user/update.groovy?id=@id'
//delete '/users/user/@id', 			forward : '/io/vteial/seetu/web/user/delete.groovy?id=@id'

// customer
get      '/customers/all',     			forward : '/io/vteial/seetu/web/customer/all.groovy'
get      '/customers',         			forward : '/io/vteial/seetu/web/customer/list.groovy'
//get    '/customers/customer/@id', 	forward : '/io/vteial/seetu/web/user/findById.groovy?id=@id'
//post   '/customers/customer',     	forward : '/io/vteial/seetu/web/user/create.groovy'
//put    '/customers/customer/@id', 	forward : '/io/vteial/seetu/web/user/update.groovy?id=@id'
//delete '/customers/customer/@id', 	forward : '/io/vteial/seetu/web/user/delete.groovy?id=@id'

// account
get      '/accounts/all',         		forward : '/io/vteial/seetu/web/account/all.groovy'
get      '/accounts',         			forward : '/io/vteial/seetu/web/account/list.groovy'
//get    '/accounts/account/@id', 		forward : '/io/vteial/seetu/web/account/findById.groovy?id=@id'
//post   '/accounts/account',     		forward : '/io/vteial/seetu/web/account/create.groovy'
//put    '/accounts/account/@id', 		forward : '/io/vteial/seetu/web/account/update.groovy?id=@id'
//delete '/accounts/account/@id', 		forward : '/io/vteial/seetu/web/account/delete.groovy?id=@id'

get     '/accountTransactions/all',    	forward : '/io/vteial/seetu/web/account/allTransaction.groovy'

// item
get     '/items/all',          			forward : '/io/vteial/seetu/web/item/all.groovy'
get     '/items',          				forward : '/io/vteial/seetu/web/item/list.groovy'
//get    '/items/item/@id', 			forward : '/io/vteial/seetu/web/item/findById.groovy?id=@id'
//post   '/items/item',     			forward : '/io/vteial/seetu/web/item/create.groovy'
//put    '/items/item/@id', 			forward : '/io/vteial/seetu/web/item/update.groovy?id=@id'
//delete '/items/item/@id', 			forward : '/io/vteial/seetu/web/item/delete.groovy?id=@id'

get    '/itemTransactions/all',    		forward : '/io/vteial/seetu/web/item/allTransaction.groovy'
