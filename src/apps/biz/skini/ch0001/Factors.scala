package apps.biz.skini.ch0001

import scala.collection.mutable

/**
  * Created by skinibizapps on 12/10/16.
  */
object Factors extends App {

  val returnList = mutable.ListBuffer[Long]()

  def factor(value: Long): List[Long] = {
    var index = 2
    var newValue = value
    val sqrtVal = math.sqrt(value)
    val fResult = (value: Long, maxVal: Long) => value < maxVal

    while (fResult(index, sqrtVal.toInt)) {
      println(s"newValue is $newValue and index is $index")
      if ((index == 2 || (index > 2 && index % 2 != 0)) && newValue % index == 0) {
        returnList.+=(index)
        newValue = newValue / index
      } else {
        index = index.+(1)
      }
    }
    returnList.+=(newValue)
    returnList.toList
  }


  print(factor(204)) //2*2*3*17
  print(2 * 3 * 3 * 3 * 21491747l * 106377431l)
  print(factor(123456789012345678l)) //2*3*3*3*21491747*106377431
}
