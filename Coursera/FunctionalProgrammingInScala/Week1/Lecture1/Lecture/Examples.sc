import math.abs

object Examples {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def sqrt(guess: Double, x: Double): Double =
  	if (abs(guess - x / guess) < x * 1e-8)
  		guess
  	else
  		sqrt(0.5 * (guess + x / guess), x)//> sqrt: (guess: Double, x: Double)Double
  		
  sqrt(2, 1)                                      //> res0: Double = 1.000000000000001
}