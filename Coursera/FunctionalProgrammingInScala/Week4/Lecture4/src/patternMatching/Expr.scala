package patternMatching

trait Expr {
  	def eval: Int = {
	  this match {
	  	case Number(n) => n
	  	case Sum(e1, e2) => e1.eval + e2.eval
	  	case Prod(e1, e2) => e1.eval * e2.eval
	  }
	}
  	
  	override def toString: String = {
  	  this match {
  	    case Number(n) => n.toString
  	    case Prod(Sum(e1, e2), e3) => "( " + Sum(e1, e2).toString + " ) x " + e3.toString
  	    case Prod(e1, Sum(e2, e3)) => e1.toString + " x ( " + Sum(e2, e3).toString + " )" 
  	    case Sum(e1, e2) => e1.toString + " + " + e2.toString
  	    case Prod(e1, e2) => e1.toString + " x " + e2.toString
  	  }
  	}
}

case class Number (n: Int) extends Expr {
	def numValue = n
}

case class Sum (e1: Expr, e2: Expr) extends Expr {
	def leftOp = e1
	def rightOp = e2
}

case class Prod(e1: Expr, e2: Expr) extends Expr {
	def leftOp = e1;
	def rightOp = e2;
}