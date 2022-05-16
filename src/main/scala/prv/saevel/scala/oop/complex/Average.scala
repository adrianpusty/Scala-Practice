package prv.saevel.scala.oop.complex

object Average {

  def apply[T](data: List[T])(implicit addition: Addition[T], division: DivisionByInt[T]): T = {
    if (data.nonEmpty) {
      val sum = data.reduce((t1, t2) => addition.add(t1, t2))
      division.divideBy(sum, data.length)
    } else {
      addition.zero
    }
  }
}