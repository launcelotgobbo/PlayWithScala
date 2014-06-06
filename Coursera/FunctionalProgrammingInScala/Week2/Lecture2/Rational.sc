class Rational(x:Int, y: Int) {
	require(y != 0, "Denominator must be non zero")

	private def gcd(x: Int, y: Int): Int =
		if (y == 0) x else gcd(y, x % y)
	
	def this(x: Int) = this(x, 1)
	
	private val g = gcd(x, y)
	
	val numer = x / g
	val denom = y / g
	
	override def toString: String = numer + "/" + denom
	
	def printString: String = x + "/" + y
	
	def unary_- : Rational = new Rational(-numer, denom)

	def + (other: => Rational): Rational = new Rational(other.denom * numer + denom * other.numer, denom * other.denom)

	def - (other: => Rational): Rational = this + -other
	
	def < (other: => Rational): Boolean = numer * other.denom < denom * other.numer
	
	def == (other: => Rational): Boolean = !(this < other || other < this)
	
	def max(other: => Rational): Rational = if (this < other) other else this
}

object Rational {
	def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
                                                  //> gcd: (x: Int, y: Int)Int

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  new Rational(1, 2) + new Rational(2, 4)         //> res0: Rational = 1/1
  (new Rational(1, 2) - new Rational(2, 4)).printString
                                                  //> res1: String = 0/-4
	new Rational(1, 2) == new Rational(2, 4)  //> res2: Boolean = true
  new Rational(1, 2) max new Rational(1, 3)       //> res3: Rational = 1/2
  
  new Rational(4)                                 //> res4: Rational = 4/1
}