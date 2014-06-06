import helloWorld.hello

object ClassHierarchy {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  hello                                           //> res0: helloWorld.hello.type = helloWorld.hello$@4d63e95
  hello.gcd(4, 12)                                //> res1: Int = 4

	def throwError(msg: String) : Nothing = throw new Error(msg)
                                                  //> throwError: (msg: String)Nothing
}