var sth: Int = 10 // scala uses primitives/wrapper classes under the hood but we as programmers use only one version instead of primitive or wrapper. eg. 'Int' instead of 'integer' or 'Integer'
val sth: Int = 10 // in functional programming it's encouraged to use val

val a = 198
val b = 198.13
val c = true
val d = a + b

val javaFloat: java.lang.Float = 12.34f

1 to 7        // inclusive // Range(1, 2, 3, 4, 5, 6, 7)
1 until 7     // exclusive // Range(1, 2, 3, 4, 5, 6)
Range(1, 7)   // exclusive // Range(1, 2, 3, 4, 5, 6)

for(i <- 1 until 10)
{
  println("i: " + i)
}

var i = 0
if(i == 1)
{
  println("One")
}
else
{
  println("Two")
}

def isOne(i: Int): String = {
  if (i == 1)
    {
      "YES" // last line -> return
    }
  else
  {
    "NO" // last line -> return
  }
}

class Main
{
  def main(args: Array[String]): Unit = {
    println("Hello, Scala!")
  }
}


def defaultParameterNumber(a: Int = 1, b: Option[Int] = None, c: Int = 3, d: Int = 4): Unit = {
  println(a + ", " + b + ", " + c + ", " + d)
}
defaultParameterNumber(10) // more than 1 default value - works fine

// private var age: Option[Int] = None // it's default parameter
class Person(val name: String, var surname: String, private var age: Option[Int] = None) // these parameters will be automatically fields of the class. If we don't want it we should declare them as private
{
  def this(name: String, surname: String) = {
    this(name, surname, None)
  }

  private def whoAreYou() = {
    name + " " + surname
  }
}

val p1 = new Person("Jan", "Kowalski", Option(31))
val p2 = new Person("Jan", "Kowalski")

{
  // val - getter
  //p2.name = "Stefan" // does not compile
  p2.name

  // var - getter, setter
  p2.surname = "Nowak"
  p2.surname

  // private var - neither getter nor setter
  //p2.age = Option(3) // does not compile // Symbol age is inaccessible from this place
  //p2.age // does not compile // Symbol age is inaccessible from this place
}

// ??? - compiles but at runtime throws not implemented error

//class Main
object Main //object creates singleton
{
  def main(args: Array[String]): Unit = {
    println("Hello, Scala!")
  }
}