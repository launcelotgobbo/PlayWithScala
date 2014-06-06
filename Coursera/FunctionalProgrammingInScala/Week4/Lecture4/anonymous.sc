object anonymous {
  println ("This is week 4")                      //> This is week 4
  
	class AnonFunction extends Function1[Int, Int] {
		def apply(x: Int): Int = x * x
	}
	
	val x = new AnonFunction                  //> x  : anonymous.AnonFunction = <function1>
	x(5)                                      //> res0: Int = 25
	
}