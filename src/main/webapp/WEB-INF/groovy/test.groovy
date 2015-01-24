import io.vteial.seetu.model.Account


println '''
<html><head><title>Test</title><head><body><pre>
'''
println '-----------------------------------------------------------------'
try {
	def entitys = datastore.execute {
		from Account.class.simpleName
		where agencyId == 1
	}
	println(entitys)
}
catch(Throwable t) {
	t.printStackTrace(out)
}
println '-----------------------------------------------------------------'
System.out.println('hi')
println '''
</pre></body></html>
'''