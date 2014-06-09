import patternMatching._

object patternMatchingTests {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  Prod(Number(1), Sum(Number(3), Number(44)))     //> res0: patternMatching.Prod = 1 x ( 3 + 44 )
  Sum(Prod(Number(4), Number(1)), Prod(Sum(Number(13), Number(1232)), Number(15)))
                                                  //> res1: patternMatching.Sum = 4 x 1 + ( 13 + 1232 ) x 15
}