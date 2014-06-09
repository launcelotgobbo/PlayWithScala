import idealised.scala._

object testNat {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  println (False)                                 //> FALSE
  
  println (Zero)                                  //> 0
  println (Zero.successor)                        //> 1+0
  println(Zero.successor + Zero.successor.successor)
                                                  //> 1+1+1+0
}