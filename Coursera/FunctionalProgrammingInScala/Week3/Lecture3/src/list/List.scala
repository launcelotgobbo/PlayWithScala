package list

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def insert(elem: T): List[T]
  def toString: String
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
  override def toString: String = "."
  def insert(elem: T): List[T] = new Cons[T](elem, new Nil[T])
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
	def isEmpty: Boolean = false
	
	def singleton[T](elem: T): List[T] = new Cons[T](elem, new Nil[T])
	
	def insert(elem: T): List[T] = new Cons[T] (head, tail insert elem)
	
	override def toString: String = head + "-" + tail.toString 
}

object List {
  def apply[T](x: T, y: T) = new Cons(x, new Cons(y, new Nil))
  def apply[T](x: T) = new Cons(x, new Nil)
  def apply() = new Nil
}

object lst {
  def main(args: Array[String]) = {
	  val simpleList = new Cons[Int](15, new Nil[Int]);
	  println (simpleList insert 25)
	  println (List(3, 4))
	  println (List(54))
	  println (List())
  }
}