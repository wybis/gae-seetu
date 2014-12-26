package io.vteial.seetu.model

import groovy.transform.Canonical
import groovyx.gaelyk.datastore.Entity
import groovyx.gaelyk.datastore.Ignore
import groovyx.gaelyk.datastore.Key

@Entity(unindexed=false)
@Canonical
public class Account implements Serializable {

	static final String ID_KEY = "accountId"

	@Key
	long id

	String name

	String aliasName

	String type

	boolean isMinus

	double balance

	String status

	String userId

	@Ignore
	User user

	String createBy

	String updateBy

	Date createTime

	Date updateTime

	String toString() {
		StringBuilder sb = new StringBuilder(Account.class.getSimpleName())
		sb.append('[')

		sb.append("id:${this.id}, ")
		sb.append("name:${this.name}, ")
		sb.append("type:${this.type}, ")
		sb.append("isMinus:${this.isMinus}, ")
		sb.append("balance:${this.balance}, ")
		sb.append("status:${this.status}, ")
		sb.append("userId:${this.userId} ")

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
	public boolean hasSufficientBalance(double amount) {

		if (this.isMinus) {
			return true
		}

		return this.balance >= amount
	}

	public void withdraw(double amount) {
		this.balance -= amount
	}

	public void deposit(double amount) {
		this.balance += amount
	}
}
