object polynom {
  class Poly(terms0: Map[Int, Double]) {
  	def this(bindings: (Int, Double)*) = this(bindings.toMap)
  	
  	def terms = terms0 withDefaultValue 0.0
 // 	def + (other: Poly) : Poly = new Poly(terms ++ (other.terms map adjust))
 // 	def adjust(otherTerms: (Int, Double)) = {
 // 		val (expr, coeff) = otherTerms
 //		expr -> (coeff + terms(expr))
 // 	}
  	
  	def + (other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))
  	
  	def addTerm(terms: Map[Int, Double], term: (Int, Double)) = {
  		val (expr, coeff) = term
  		terms + (expr -> (coeff + terms(expr)))
  	}
  	
  	override def toString : String =
  		(for ((expr, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + expr) mkString " + "
  }
  
  val p1 = new Poly (1 -> 2.0, 3 -> 4.0, 5 -> 6)  //> p1  : polynom.Poly = 6.0x^5 + 4.0x^3 + 2.0x^1
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0)           //> p2  : polynom.Poly = 7.0x^3 + 3.0x^0
  p1 + p2                                         //> res0: polynom.Poly = 6.0x^5 + 11.0x^3 + 2.0x^1 + 3.0x^0
}