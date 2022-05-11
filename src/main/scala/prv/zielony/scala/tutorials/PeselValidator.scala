package prv.zielony.scala.tutorials

/**
 * Created by zielony on 02.02.16.
 */
object PeselValidator {

  /**
    * The aim is to validate the PESEL number, which is more or less a Polish ID number.
    * The validation should go as follows:
    * 1. The number has to have 11 digits
    * 2. The following algorithm should hold:
    *
    * We multiply digits respectively:
    *   - first by 1
    *   - second by 3
    *   - third by 7
    *   - fourth by 9
    *   - fifth by 1
    *   - sixth by 3
    *   - seventh by 7
    *   - eight by 9
    *   - ninth by 1
    *   - tenth by 3
    *   - eleventh by 1
    *   where the first digit is the one on the left-hand side as the number is written, i.e. for
    *   1234 the first digit is 1 and the fourth is 4.
    *   Next, we sum all the results. If the final result is divisible by 10, the PESEL number is correct.
    *   Otherwise, it isn't.
    */

  val PESEL_LENGTH = 11

  def validate(pesel: List[Int]): Boolean = {
    if (pesel.length != PESEL_LENGTH) {
      return false
    }

    val sum = Range(0, PESEL_LENGTH)
      .map(index => (index, pesel(index)))
      .map(tuple => multiplier(tuple._1) * tuple._2)
      .sum

    sum % 10 == 0
  }

  def multiplier(index: Int): Int = {
    index match {
      case 0 | 4 | 8 | 10 => 1
      case 1 | 5 | 9 => 3
      case 2 | 6 => 7
      case 3 | 7 => 9
      case _ => throw new RuntimeException("Incorrect index")
    }
  }
}