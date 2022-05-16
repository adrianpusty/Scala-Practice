package prv.saevel.scala.oop.complex

class ComplexNumber(val real: Double, val imaginary: Double)
{
  val modulus: Double = mod(this)
  override def toString = s"ComplexNumber($real, $imaginary)"

  def mod(t: ComplexNumber): Double = Math.sqrt(t.real * t.real + t.imaginary * t.imaginary)
}

object ComplexNumber {

  implicit val addition: Addition[ComplexNumber] = new Addition[ComplexNumber] {
    override def zero: ComplexNumber = new ComplexNumber(0, 0)

    override def add(x: ComplexNumber, y: ComplexNumber): ComplexNumber = new ComplexNumber(x.real + y.real, x.imaginary + y.imaginary)
  }

  implicit val division: DivisionByInt[ComplexNumber] = new DivisionByInt[ComplexNumber] {
    override def divideBy(t: ComplexNumber, i: Int): ComplexNumber = {
      new ComplexNumber(t.real / i, t.imaginary / i)
    }
  }
}