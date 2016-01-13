class C1
	def m()
		'parent'
	end
end

class C2 < C1
	def m()
		super() + ' child'
	end
end

c = C2.new()
p c.m()