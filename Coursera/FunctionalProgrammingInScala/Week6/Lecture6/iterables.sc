object iterables {
	println ("Hello World")                   //> Hello World
	
  val xs = Array(1, 3, 4, -1, 123, -123)          //> xs  : Array[Int] = Array(1, 3, 4, -1, 123, -123)
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(2, 6, 8, -2, 246, -246)
  xs.toList                                       //> res1: List[Int] = List(1, 3, 4, -1, 123, -123)

	val s: Range = -1 to 5 by 2               //> s  : Range = Range(-1, 1, 3, 5)
	
	val q: Range = -1 to 5 by -2              //> q  : Range = Range()
	val r: List[Boolean] = List(true, false, false)
                                                  //> r  : List[Boolean] = List(true, false, false)
	
	((2 until 5) map (x => 6 % x == 0)).toList//> res2: List[Boolean] = List(true, true, false)

	def isPrime(n: Int) : Boolean =
		!((2 until n) exists (x => n % x == 0))
                                                  //> isPrime: (n: Int)Boolean
 	isPrime(13)                               //> res3: Boolean = true
	isPrime(12)                               //> res4: Boolean = false
	
	def doubleLoop(n: Int) = (1 until n) flatMap (i => (1 until i) map (j=> (i, j)))
                                                  //> doubleLoop: (n: Int)scala.collection.immutable.IndexedSeq[(Int, Int)]
	
	def getPrimes(n: Int) = doubleLoop(n) filter (pair => isPrime(pair._1 + pair._2))
                                                  //> getPrimes: (n: Int)scala.collection.immutable.IndexedSeq[(Int, Int)]
	
	getPrimes(7)                              //> res5: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
	def getPrimesLoop(n:Int) = for (iter <- doubleLoop(n) filter (pair => isPrime(pair._1 + pair._2))) yield iter
                                                  //> getPrimesLoop: (n: Int)scala.collection.immutable.IndexedSeq[(Int, Int)]

	getPrimesLoop(7)                          //> res6: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
                                                  
  def scalarProduct(xs: List[Double], ys: List[Double]): Double =
  	(for ((x, y) <- xs zip ys) yield(x * y)).sum
                                                  //> scalarProduct: (xs: List[Double], ys: List[Double])Double
  	
  scalarProduct(List(4, 5, -5), List(5, -2, 3))   //> res7: Double = -5.0
  
  val country = Map("A" -> "B", "C" -> "D", "E" -> "F")
                                                  //> country  : scala.collection.immutable.Map[String,String] = Map(A -> B, C -> 
                                                  //| D, E -> F)
  country get "A"                                 //> res8: Option[String] = Some(B)
  country get "F"                                 //> res9: Option[String] = None
}