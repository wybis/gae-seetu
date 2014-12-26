package io.vteial.seetu.model

import groovy.transform.Canonical
import groovy.transform.ToString
import groovyx.gaelyk.datastore.Entity
import groovyx.gaelyk.datastore.Ignore
import groovyx.gaelyk.datastore.Key

@Entity(unindexed=false)
@Canonical
@ToString(includeNames=true)
public class ItemTransaction implements Serializable {

	static final String ID_KEY = "itemTranId"

	@Key
	long id

	double winningBidAmount

	double commisionAmount

	double winnerBidAmount

	double discountAmount

	double discountShareAmount

	String description

	int nthBid

	Date date

	String status

	long winnerAccountId

	@Ignore
	Account winnerAccount

	long itemId

	@Ignore
	Item item

	String userId

	@Ignore
	User user

	String createBy

	String updateBy

	Date createTime

	Date updateTime

	String toString() {
		StringBuilder sb = new StringBuilder(User.class.getSimpleName())
		sb.append('[')

		sb.append("id:${this.id}, ")
		sb.append("winningBidAmount:${this.winningBidAmount}, ")
		sb.append("commisionAmount:${this.commisionAmount}, ")
		sb.append("winnerBidAmount:${this.winnerBidAmount}, ")
		sb.append("discountAmount:${this.discountAmount}, ")
		sb.append("discountShareAmount:${this.discountShareAmount}, ")
		sb.append("nthBid:${this.nthBid}, ")
		sb.append("date:${this.date}, ")
		sb.append("winnerAccountId:${this.winnerAccountId}, ")
		sb.append("itemId:${this.itemId}, ")
		sb.append("userId:${this.userId}")
		sb.append("status:${this.status}, ")
		sb.append("description:${this.description}, ")

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

	// Domain Operations
	void computeDiscountAmount() {
		this.discountAmount = this.item.value - this.winningBidAmount
	}

	void computeDiscountShareAmount() {
		this.discountShareAmount = this.discountAmount / this.item.totalSubscribers
		this.discountShareAmount = Math.round(this.discountShareAmount * 100) / 100
		long temp = this.discountShareAmount
		this.discountShareAmount = temp
	}

	void computeCommisionAmount() {
		this.commisionAmount = (this.item.value * this.item.opearatorCommision) / 100
		this.commisionAmount = Math.round(this.commisionAmount * 100) / 100
	}

	void computeWinnderBidAmount() {
		this.winnerBidAmount = this.winningBidAmount - this.commisionAmount
	}

}
