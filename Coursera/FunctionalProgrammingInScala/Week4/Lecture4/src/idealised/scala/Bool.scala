package idealised.scala

abstract class Bool {
  def ifThenElse[T] (t: => T, e: => T): T
  
  def && (x: => Bool): Bool = ifThenElse(x, False)
  def || (x: => Bool): Bool = ifThenElse(True, x)
  def unary_! : Bool = ifThenElse[Bool](False, True)
  
  def == (x: => Bool): Bool = ifThenElse(x, x.unary_!)
  def != (x: => Bool): Bool = ifThenElse(x.unary_!, x)
  
  def < (x: Bool): Bool = ifThenElse(False, x)
    // !this && x
  
  
}

object True extends Bool {
  def ifThenElse[T] (t: => T, e: => T): T = t
  override def toString = "TRUE"
}

object False extends Bool {
  def ifThenElse[T] (t: => T, e: => T): T = e
  override def toString = "FALSE"
}

object mainScript {
  def main(args: Array[String]) = {
    println (False)
    println (True)
    println (True && False)
    println (False || True)
    println (False && False)
    println (True && True)
    println (!False)
    println (False < True)
    println (True < False)
    println (True < True)
    println (False < False)
  } 
}

