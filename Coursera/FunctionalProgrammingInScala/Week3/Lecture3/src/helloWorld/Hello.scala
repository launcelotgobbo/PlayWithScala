package helloWorld

object hello {
  def main(args: Array[String]) = println("Hello world!")
  
  def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
}