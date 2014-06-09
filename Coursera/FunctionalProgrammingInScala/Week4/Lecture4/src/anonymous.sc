object anonymous {
  println ("This is week 4")                      //> This is week 4
  
	class AnonFunction extends Function1[Int, Int] {
		def apply(x: Int): Int = x * x
	}
	
	val x = new AnonFunction                  //> x  : anonymous.AnonFunction = <function1>
	x(5)                                      //> res0: Int = 25
	
	val lst1 = 'a' :: 'b' :: Nil              //> lst1  : List[Char] = List(a, b)
	val lst2 = 'c' :: 'd' :: Nil              //> lst2  : List[Char] = List(c, d)
	val lst3 = lst1 union lst2 union ('f' :: Nil)
                                                  //> lst3  : List[Char] = List(a, b, c, d, f)
}