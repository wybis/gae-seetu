package io.vteial.seetu.model

import groovy.transform.Canonical
import groovy.transform.ToString
import groovyx.gaelyk.datastore.Entity
import groovyx.gaelyk.datastore.Ignore
import groovyx.gaelyk.datastore.Key

@Entity(unindexed=false)
@Canonical
@ToString(includeNames=true)
public class AccountTransaction implements Serializable {

	static final String ID_KEY = "accountTranId"

	@Key
	long id

	String type

	double amount

	String description

	Date date

	double balance

	String status

	long accountId

	@Ignore
	Account account

	String userId

	@Ignore
	User user

	String createBy

	String updateBy

	Date createTime

	Date updateTime

	String toString() {
		StringBuilder sb = new StringBuilder(AccountTransaction.class.getSimpleName())
		sb.append('[')

		sb.append("id:${this.id}, ")
		sb.append("accountId:${this.accountId}, ")
		sb.append("type:${this.type}, ")
		sb.append("amount:${this.amount}, ")
		sb.append("balance:${this.balance}, ")
		sb.append("description:${this.description}, ")
		sb.append("date:${this.date}, ")
		sb.append("status:${this.status}, ")
		sb.append("userId:${this.userId}, ")

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
