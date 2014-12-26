package io.vteial.seetu.model

import groovy.transform.Canonical
import groovy.transform.ToString
import groovyx.gaelyk.datastore.Entity
import groovyx.gaelyk.datastore.Ignore
import groovyx.gaelyk.datastore.Key

@Entity(unindexed=false)
@Canonical
@ToString(includeNames=true)
public class Item implements Serializable {

	static final String ID_KEY = "itemId"

	@Key
	long id

	String name

	int value

	float opearatorCommision

	int totalSubscribers

	float biddingShield

	Date startDate

	Date auctionDate

	String status

	long itemAccountId

	@Ignore
	Account itemAccount

	long commisionAccountId

	@Ignore
	Account commisionAccount

	String userId

	@Ignore
	User user

	List<Long> subscriberIds = []

	@Ignore
	List<Customer> subscribers = []

	String createBy

	String updateBy

	Date createTime

	Date updateTime

	String toString() {
		StringBuilder sb = new StringBuilder(User.class.getSimpleName())
		sb.append('[')

		sb.append("id:${this.id}, ")
		sb.append("name:${this.name}, ")
		sb.append("value:${this.value}, ")
		sb.append("opearatorCommision:${this.opearatorCommision}, ")
		sb.append("totalSubscribers:${this.totalSubscribers}, ")
		sb.append("biddingShield:${this.biddingShield}, ")
		sb.append("tartDate:${this.startDate}, ")
		sb.append("auctionDate:${this.auctionDate}, ")
		sb.append("itemAccountId:${this.itemAccountId}, ")
		sb.append("commisionAccountId:${this.commisionAccountId}, ")
		sb.append("userId:${this.userId}, ")
		sb.append("status:${this.status}")

		sb.append(']')
		return sb.toString()
	}

	void preUpdate(String updateBy) {
		this.updateBy = updateBy
		this.updateTime = new Date()
	}

	void prePersist(String createAndUpdateBy) {
		this.createBy = createAndUpdateBy
		this.updateBy = createAndUpdateBy
		Date now = new Date()
		this.createTime = now;
		this.updateTime = now;
	}
}
