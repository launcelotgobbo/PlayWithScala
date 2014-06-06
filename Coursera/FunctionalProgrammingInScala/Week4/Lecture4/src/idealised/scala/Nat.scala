package idealised.scala

abstract class Nat {
	def isZero: Boolean
	def predecessor: Nat
	def successor: Nat = new Succ(this)
	def + (that: => Nat): Nat
	def - (that: => Nat): Nat
	override def toString: String
}

object Zero extends Nat {
  def isZero: Boolean = true
  
  def predecessor = throw new NoSuchElementException("Zero.predecessor")
  
  def + (that: => Nat): Nat = that
  def - (that: => Nat): Nat = if (that.isZero) this else throw new NoSuchElementException("Zero - Non Zero")
  
  override def toString: String = "0"
}

class Succ(n: Nat) extends Nat {
  def isZero: Boolean = false
  
  def predecessor: Nat = n
  
  def + (that: => Nat) = new Succ(n + that)
  
  def - (that: => Nat) = if (that.isZero) this else n - that.predecessor
  
  override def toString: String = "1+" + n
}