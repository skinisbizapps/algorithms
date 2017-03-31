package apps.biz.skini.udacity

/**
  * Created by skinibizapps on 12/15/16.
  */
object Ex01 extends App {
  def naive(a: Int, b: Int): Int = {
    var z = 0
    var x = a
    var y = b
    while (x > 0) {
      z = z + y
      x = x - 1
    }
    z
  }

  def russian(a: Int, b: Int): Int = {
    // ab = xy + z
    // if(x is odd) move y to z, half x and double y => (x-1/2)*(2y) + z => 2 * 6 + 3
    // if(x is even) half x, double y => (x/2) * 2y + z => 1 * 12 + 3
    var x = a;
    var y = b;
    var z = 0
    println(s"russian a = $a, b = $b, x = $x, y = $y, z = $z")
    while (x > 0) {
      println(s"russian a = $a, b = $b, x = $x, y = $y, z = $z")
      if (x % 2 == 1) {
        println(s"russian a = $a, b = $b, x = $x, y = $y, z = $z")
        z = z + y
        println(s"russian a = $a, b = $b, x = $x, y = $y, z = $z")
      }
      println(s"russian a = $a, b = $b, x = $x, y = $y, z = $z")
      x = x >> 1
      println(s"russian a = $a, b = $b, x = $x, y = $y, z = $z")
      y = y << 1
      println(s"russian a = $a, b = $b, x = $x, y = $y, z = $z")
    }
    println(s"russian a = $a, b = $b, x = $x, y = $y, z = $z")
    z
  }

  println(naive(100, 10))
  println(naive(2, 5))
  println(naive(3, 5))

  println(russian(100, 10))
  println(russian(2, 5))
  println(russian(3, 5))
}
