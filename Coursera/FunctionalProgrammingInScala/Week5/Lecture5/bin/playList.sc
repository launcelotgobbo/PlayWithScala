import scala.math.Ordering._

object playList {
  val fruits = List("apples", "oranges", "bananas", "grapefruit")
  
  def removeAt[T](n: Int, xs: List[T]) : List[T] = {
  
  	def removeAtAcc[T](n: Int, lst: List[T], acc: List[T]) : List[T] = {
			if (lst.isEmpty && n > 0)
				throw new Error("Insufficient data")
			else if (n == 0 && !lst.isEmpty)
				acc ::: lst.tail
			else
				removeAtAcc(n - 1, lst.tail, acc ::: (lst.head :: Nil))
  	}

	removeAtAcc(n, xs, Nil)
	}
	
	def removeAtLib[T] (n: Int, xs:List[T]) : List[T] = (xs take n) ::: (xs drop n + 1)
	
	removeAt[String](3, fruits)
	removeAtLib[String] (3, fruits)
	
	
	
	def msort[T](xs: List[T])(implicit ord: Ordering[T]) : List[T] = {
		def merge[T](xs: List[T], ys: List[T]) : List[T] = {
			(xs, ys) match {
				case (Nil, ys1) => ys1
				case (xs1, Nil) => xs1
				case (x :: xs1, y :: ys1) =>
					if (ord.lt(x, y)) x :: merge(xs1, ys)
					else y :: merge(xs, ys1)
			}
		}
	
		val n = xs.length / 2
		if (n == 0) xs
		else {
			val (left, right) = xs.splitAt(n)
			merge[T](msort[T](left), msort[T](right))
		}
	}

	msort[Int](List(1, 2, -1, -2, 5, 4, -10, 9, -14, 14))
}