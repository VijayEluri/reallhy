object YS extends App {
  // 2014-12-02 Question 3
	var i = 2
	def prime(n:Long):Int = {
	if(n == 1) return i
	if(n%i == 0) prime(n/i) else { i += 1; prime(n)}
	}

	println(prime(2))
	println(prime(13195))
	println(prime(600851475143L))
}