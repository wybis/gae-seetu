email						to : '/receiveEmail.groovy'

jabber	chat,	 			to : '/receiveJabberMessage.groovy'
jabber 	presence,			to : '/receiveJabberpresence.groovy'
jabber	subscription, 		to : '/receiveJabberSubscription.groovy'

get 	'/favicon.ico',		redirect : '/assets/favicon.png'
get     '/',				redirect : '/index'
get     '/index',			forward  : '/index.groovy'
get 	'/info',			forward  : '/info.groovy'
get		'/ping',			forward  : '/ping.groovy'
all 	'/_ah/warmup',		forward  : '/ping.groovy'

// cron
get 	'/cron/dailyBackup',			forward : '/cron/dailyBackup.groovy'

// data
get 	'/system/reset',    			forward : '/io/vteial/seetu/web/system/reset.groovy'
get 	'/system/init',	    			forward : '/io/vteial/seetu/web/system/init.groovy'
post 	'/system/saveMaster',			forward : '/io/vteial/seetu/web/system/saveMaster.groovy'
post 	'/system/saveTrans',			forward : '/io/vteial/seetu/web/system/saveTrans.groovy'
get 	'/system/clear',   				forward : '/io/vteial/seetu/web/system/clear.groovy'
get 	'/system/clearTrans',   		forward : '/io/vteial/seetu/web/system/clearTrans.groovy'

// session
get  	'/sessions/properties',			forward : '/io/vteial/seetu/web/session/properties.groovy'
post 	'/sessions/login',     			forward : '/io/vteial/seetu/web/session/login.groovy'
get  	'/sessions/logout',    			forward : '/io/vteial/seetu/web/session/logout.groovy'

// user
get     '/users',          				forward : '/io/vteial/seetu/web/user/list.groovy'
get    	'/users/user/@id', 				forward : '/io/vteial/seetu/web/user/findById.groovy?id=@id'
post   	'/users/user',     				forward : '/io/vteial/seetu/web/user/create.groovy'
put    	'/users/user/@id', 				forward : '/io/vteial/seetu/web/user/update.groovy?id=@id'
delete 	'/users/user/@id', 				forward : '/io/vteial/seetu/web/user/delete.groovy?id=@id'

// account
get     '/accounts/all',         		forward : '/io/vteial/seetu/web/account/all.groovy'
get     '/accounts',         			forward : '/io/vteial/seetu/web/account/list.groovy'
get    	'/accounts/account/@id', 		forward : '/io/vteial/seetu/web/account/findById.groovy?id=@id'

