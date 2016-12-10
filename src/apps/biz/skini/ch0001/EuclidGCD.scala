package apps.biz.skini.ch0001

/**
  * Created by skinibizapps on 12/10/16.
  */
object EuclidGCD extends App {

  def gcd(value1: Int, value2: Int): Int = {
    println(s"executing gcd($value1, $value2)")
    val returnVal = if (value2 > 1) gcd(value2, value1 % value2) else value1
    println(s"returning value of $returnVal")
    returnVal
  }

  println(gcd(10, 8))
  println(gcd(78, 66))
  println(gcd(27, 33))
  //print(10%8)
  /*
  gcd(10,8)
    gcd(8, 10%8 == 2)
      gcd(2, 8%2 == 0)
  10, 8, 10%8 (2)
  8, 2, 8%2 (0)
   */
}
