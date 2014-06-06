abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
	def toString: String
	def union(other: IntSet): IntSet
}

class Empty extends IntSet {
	def contains(x: Int) = false
	def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
	override def toString: String = "."
	def union(other: IntSet): IntSet = other
}

class NonEmpty(elem:Int, left: IntSet, right: IntSet) extends IntSet {
	def contains(x: Int): Boolean = {
		if (x == elem) true
		else
			if (x < elem)
				left contains x
			else
				right contains x
	}
	
	def incl(x: Int): IntSet = {
		if (x > elem) new NonEmpty(elem, left, right incl x)
		else if (x < elem) new NonEmpty(elem, left incl x, right)
		else this
	}
	
	override def toString: String = left.toString + "-" + elem + "-" + right.toString

	def union(other: IntSet): IntSet =
			(((left union right) union other) incl elem)
}

object value {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  new NonEmpty(10, new Empty, new Empty).incl(20).incl(30).incl(-5).incl(-10)
                                                  //> res0: IntSet = .--10-.--5-.-10-.-20-.-30-.
}