package io.vteial.seetu.web.system;

import io.vteial.seetu.model.Customer
import io.vteial.seetu.model.Item
import io.vteial.seetu.model.Role
import io.vteial.seetu.model.User
import io.vteial.seetu.model.constants.UserStatus

println 'init started...'

try {
	User user = new User()
	user.id = 'foreman1'
	user.password = '1234'
	user.emailId = 'foreman1@gmail.com'
	user.firstName = 'Foreman'
	user.lastName = 'Foreman'
	user.status = UserStatus.ACTIVE
	user.roleId = Role.FOREMAN

	User sessionUser = user

	userService.add(sessionUser, user)

	List<Long> subscriberAccountIds = []
	for(int i = 1; i < 7; i++) {
		Customer subscriber = new Customer()
		subscriber.identiyNumber = "subscriber-$i"
		subscriber.firstName = "Subscriber - $i"
		subscriber.lastName = "Subscriber - $i"

		customerService.add(sessionUser, subscriber)

		subscriberAccountIds << subscriber.accountId
	}

	Item item = new Item()
	item.name = 'Six Thousand'
	item.value = 6000
	item.opearatorCommision = 5
	item.totalSubscribers = 6
	item.biddingShield = 40
	item.startDate = new Date()
	item.auctionDate = item.startDate + 1

	item.subscriberIds = subscriberAccountIds

	itemService.add(sessionUser, item)
}
catch(Throwable t) {
	t.printStackTrace(out)
}

println 'init finished...'
