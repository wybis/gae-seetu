package io.vteial.seetu.model;

import groovy.transform.Canonical
import groovy.transform.ToString
import groovyx.gaelyk.datastore.Entity
import groovyx.gaelyk.datastore.Key

@Entity(unindexed=false)
@Canonical
@ToString(includeNames=true)
public class Role implements Serializable {

	static final SYS_ADMIN = 'Sys Admin'

	static final APP_ADMIN = 'App Admin'

	static final FOREMAN = 'Foreman'

	static final SUBSCRIBER = 'Subscriber'

	static final List<String> ROLES = [
		SYS_ADMIN,
		APP_ADMIN,
		FOREMAN,
		SUBSCRIBER
	]

	@Key
	String id

	String name

	String createBy

	String updateBy

	Date createTime

	Date updateTime

	String toString() {
		StringBuilder sb = new StringBuilder(AutoNumber.class.getSimpleName())
		sb.append('[')

		sb.append("id:${this.id}, ")
		sb.append("name:${this.name}")

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
