object lst {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val meanList = List(4.5, 12.0, 132.1) :: 123.5 :: 12.0 :: Nil
                                                  //> meanList  : List[Any] = List(List(4.5, 12.0, 132.1), 123.5, 12.0)
	val nilList = List()                      //> nilList  : List[Nothing] = List()
	val matrix = List(1, 0) :: List(0, 1)     //> matrix  : List[Any] = List(List(1, 0), 0, 1)
}