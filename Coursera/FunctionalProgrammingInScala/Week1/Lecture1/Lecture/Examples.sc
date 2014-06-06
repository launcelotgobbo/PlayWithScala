object Examples {
	def loop: Boolean = loop                  //> loop: => Boolean

	def and(x:Boolean, y: => Boolean):Boolean = if (x) y else false
                                                  //> and: (x: Boolean, y: => Boolean)Boolean
	
	and(true, false)                          //> res0: Boolean = false
	and(false, false)                         //> res1: Boolean = false
	and(false, loop)                          //> res2: Boolean = false

	def abs (x: Double): Double = if (x > 0) x else -x
                                                  //> abs: (x: Double)Double
  abs(-5)                                         //> res3: Double = 5.0
  abs(5)                                          //> res4: Double = 5.0
            
	def factorial(x: Double): Double = {
		def factorialAcc(acc: Double, y: Double): Double =
			if (y == 0) acc else factorialAcc(acc * y, y - 1)
			
		factorialAcc(1, x)
	}                                         //> factorial: (x: Double)Double
	factorial(4)                              //> res5: Double = 24.0

	def gcd(x: Int, y: Int): Int = {
		if (y == 0)
			x
		else
			gcd(y, x % y)
	}                                         //> gcd: (x: Int, y: Int)Int
	gcd(3, 6)                                 //> res6: Int = 3

  def sqrt (x: Double): Double = {
	  def sqrtIter(guess: Double): Double =
	  	if (abs(guess - x / guess) < (guess * 1e-8))
	  		guess
	  	else
	  		sqrtIter(0.5 * (guess + x / guess))
  		
 		sqrtIter(1)
  }                                               //> sqrt: (x: Double)Double

  sqrt(1e50)                                      //> res7: Double = 1.0000000000000725E25
}