class C1(object):
	def m(self):
		return 'parent'

class C2(C1):
	def m(self):
		return super(C2, self).m() + ' child'
	

o = C2()
print(o.m())