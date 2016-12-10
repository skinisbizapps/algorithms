package apps.biz.skini.ch02

/**
  * Created by skinibizapps on 12/3/16.
  */
object ThreeSum extends App {
  // given a list of N numbers, how many combinations of adding 3 numbers together will result
  // in a zero

  //standard algorithm uses three inner loops giving a ~ N^3 O(n)


  //faster implementation would be do a cartesian product of the first 2 numbers and sum them up.
  //Pick the 3rd number that totals to 0. this will result in O(n) of N^2 logN
}
