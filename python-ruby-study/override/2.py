class Cal(object):
	_history = []
	def __init__(self, v1, v2):
		if isinstance(v1, int):
			self.v1 = v1
		if isinstance(v2, int):
			self.v2 = v2

	def add(self):
		result = self.v1 + self.v2
		Cal._history.append("add : %d+%d=%d" % (self.v1, self.v2, result))
		return result

	def subtract(self):
		result = self.v1 - self.v2
		Cal._history.append("subtract : %d-%d=%d" % (self.v1, self.v2, result))
		return result

	def setV1(self, v):
		if isinstance(v, int):
			self.v1 = v
	def getV1(self):
		return self.v1
	@classmethod
	def history(cls):
		for item in Cal._history:
			print(item)
	def __str__(self):
		return "Cal => v1 : %d, v2 : %d" % (self.v1, self.v2)

class CalMultiply(Cal):
	def multiply(self):
		result = self.v1 * self.v2
		Cal._history.append("multiply : %d*%d=%d" % (self.v1, self.v2, result))
		return result
	def __str__(self):
		return "CalMultiply => %s" % (super(CalMultiply, self).__str__())

class CalDivide(CalMultiply):
	def divide(self):
		result = self.v1 / self.v2
		Cal._history.append("divide : %d/%d=%d" % (self.v1, self.v2, result))
		return result
	def __str__(self):
		return "%s => %s" % (type(self).__name__, super(CalDivide, self).__str__())

p0 = CalDivide(100, 20)
print(p0.divide())
print(p0.add())
print(p0._history)
print(p0)
Cal.history()