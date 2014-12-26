package io.vteial.seetu.web.init

import io.vteial.seetu.model.User

Date now = new Date()
User user = new User()
user.id = 'vteial'
user.password = '1234'
user.emailId = 'vteial@gmail.com'
user.status = 'active'
user.firstName = 'Eialarasu'
user.lastName = 'VT'
user.createTime = now
user.updateTime = now
user.save()

user = new User()
user.id = 'donkhan'
user.password = '1234'
user.emailId = 'routetokamil@gmail.com'
user.status = 'active'
user.firstName = 'Kamilkhan'
user.lastName = 'A'
user.createTime = now
user.updateTime = now
user.save()

user = new User()
user.id = 'hari'
user.password = '1234'
user.emailId = 'jayaramanhari@gmail.com'
user.status = 'active'
user.firstName = 'Hari'
user.lastName = 'Jayaraman'
user.createTime = now
user.updateTime = now
user.save()

user = new User()
user.id = 'vrsumitha'
user.password = '1234'
user.emailId = 'sumitha.v.r@gmail.com'
user.status = 'active'
user.firstName = 'Sumitha'
user.lastName = 'Vasanthan'
user.createTime = now
user.updateTime = now
user.save()

println 'Users created...'
