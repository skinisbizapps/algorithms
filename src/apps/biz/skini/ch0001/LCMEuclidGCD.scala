package apps.biz.skini.ch0001

/**
  * Created by skinibizapps on 12/10/16.
  */
object LCMEuclidGCD extends App {
  def gcd(value1: Int, value2: Int): Int = {
    println(s"executing gcd($value1, $value2)")
    val returnVal = if (value2 > 1) gcd(value2, value1 % value2) else value1
    println(s"returning value of $returnVal")
    returnVal
  }

  def lcm(value1: Int, value2: Int): Int = {
    val lcmValue = (value1 / gcd(value1, value2)) * value2
    return lcmValue
  }

  println(lcm(12, 15))
  println(lcm(1000055, 2000000))
}
