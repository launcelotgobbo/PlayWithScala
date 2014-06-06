object Examples {
  println("Welcome to the Week 2")                //> Welcome to the Week 2
  
  def abs(x: Int): Int = if (x > 0) x else -x     //> abs: (x: Int)Int
  
  // Higher order functions as essential building blocks
  def sumRange(fun: Int => Int, left: Int, right: Int): Int = {
  	if (left > right) 0 else fun(left) + sumRange(fun, left + 1, right)
  }                                               //> sumRange: (fun: Int => Int, left: Int, right: Int)Int
  sumRange((x: Int) => x * x, 3, 10)              //> res0: Int = 380
  
  // Tail-recursive implementation of previous sumRange code
  def sumTailRecursion(fun: Int => Int)(left: Int, right: Int): Int = {
  	def sumTailAcc(acc: Int, left: Int): Int =
  		if (left > right) acc else sumTailAcc(acc + fun(left), left + 1)
  	
  	sumTailAcc(0, left)
  }                                               //> sumTailRecursion: (fun: Int => Int)(left: Int, right: Int)Int
  sumTailRecursion((x:Int) => x * x)(3, 10)       //> res1: Int = 380
  
  sumTailRecursion(abs)(-3, 3)                    //> res2: Int = 12
  
  // Tail recursive product function
  def product(fun: Int => Int)(left: Int, right: Int): Int = {
  	def productAcc(acc: Int, left: Int) : Int =
  		if (left > right) acc
  		else productAcc(acc * fun(left), left + 1)
  
  	productAcc(1, left)
  }                                               //> product: (fun: Int => Int)(left: Int, right: Int)Int
  
  // Re-defining currying based on tail recursive product function
  def factorial(n: Int): Int = product((x:Int) => x)(1, n)
                                                  //> factorial: (n: Int)Int
  factorial(5)                                    //> res3: Int = 120

	// Further generalization of the functions above using aspects of currying
	// Beautiful!
	def generalRangeFunction(combine: (Int, Int) => Int)(identity: Int)(fun: Int => Int)(left:Int, right: Int): Int = {
		def accumulator(acc: Int, left: Int): Int =
			if (left > right) acc
			else accumulator(combine(acc, fun(left)), left + 1)
		
		accumulator(identity, left)
	}                                         //> generalRangeFunction: (combine: (Int, Int) => Int)(identity: Int)(fun: Int 
                                                  //| => Int)(left: Int, right: Int)Int
	
	def fact(n: Int): Int = generalRangeFunction((x: Int, y: Int) => x*y)(1)((x:Int) => x)(1, n)
                                                  //> fact: (n: Int)Int
  def sumOfSq(x: Int, y: Int): Int = generalRangeFunction((x:Int, y: Int) => x + y)(0)((x:Int) => x * x)(x, y)
                                                  //> sumOfSq: (x: Int, y: Int)Int
  sumOfSq(5, 6)                                   //> res4: Int = 61
 	fact(5)                                   //> res5: Int = 120
}