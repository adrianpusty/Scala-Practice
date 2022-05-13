import scala.runtime.Nothing$
import scala.util.Random

class C1 {
  private val name: String = "Jane"

  //// private[this] - only for this instance. It cannot be invoked from another instance of the same class.
  private[this] val surname: String = "Smith"

//    private[this] def emitNoise2(): String // does not compile // "Abstract member may not have private modifier"
  protected[this] def emitNoise3(): String = "noise generated"

  def main(): Unit = {
    println(name)
    println(surname)

    val v1 = new C1()
    println(v1.name)
//    println(v1.surname) // does not compile // "Symbol surname is inaccessible from this place"
  }
}

class C2 {
  def main(): Unit = {
    val v1 = new C1()
//    println(v1.name) // does not compile // Symbol name is inaccessible from this place
//    println(v1.surname) // does not compile // "Symbol surname is inaccessible from this place"
  }
}

abstract class Animal(private[this] val name: String) {
  def emitNoise: String // you can skip parenthesis if there are no parameters

//    def equals(otherAnimal: Animal): Boolean =
//      name.equals(otherAnimal.name) // without '[this]' in name declaration it would compile
}

class Cat extends Animal("Puszek")
{
  override def emitNoise = "Meow"
}

class Cat2(val name: String) extends Animal(name) // pass value to a constructor
{
  override def emitNoise = "Meow"
}

val cat2 = new Cat2("Okruszek")
val cat1 = new Cat //() // compiles also without parenthesis

cat1.emitNoise
//cat1.emitNoise() // exception at runtime // not enough arguments for method apply: (index: Int)Char in class StringOps. // Unspecified value parameter index.

object ET extends Animal("E.T.") {
  override def emitNoise = "E.T Phone Home"
}

ET.emitNoise

trait Chipped {
  val chipId: String

  protected def transmitLocationOfTheChip(): Unit

  private def doSomethingShady(): Unit = {}
}

object ET2 extends Chipped {
  override val chipId: String = "ET-123456"

  override protected def transmitLocationOfTheChip(): Unit = {}
}

object ET3 extends Animal("ET") with Chipped {
  override val chipId: String = "ET-123456"

  override def emitNoise = "E.T Phone Home"

  override protected def transmitLocationOfTheChip(): Unit = {}
}

trait Id[T] {
  val id: T
}

// did not compile when Id trait was defined below ET4
object ET4 extends Animal("ET") with Id[String]
{
  override def emitNoise = "E.T Phone Home"
  override val id = "654321"
}

ET2.chipId

/**
  * anonymous instance of a trait
  */
val chippedAnon = new Chipped {
  override val chipId: String = "Secret-123456"

  override protected def transmitLocationOfTheChip(): Unit = {}
}

trait PrimaryKey[T] {
  val id: T
}

trait ForeignKey[T] {
  val id: T
}

class User(val name: String, val surname: String, val age: Option[Int] = None) {
  def renameTo(newSurname: String): User = new User(name, newSurname, age)
}

//object GenericRepositoryObject[EntityType, PrimaryKeyType] {} // '[...]' causes compilation error. Need to change 'object' to 'class' to get rid of it

class GenericRepository[EntityType, PrimaryKeyType]
{
  //  var data2: java.lang.Object //tidbit about default value // this will actually not compile, you have to assign something //compare it with java
  var data = Map[PrimaryKeyType, EntityType]()

  def saveToDb //[EntityType, PrimaryKeyType]
  (entity: EntityType with PrimaryKey[PrimaryKeyType]): Unit =
    data = data + (entity.id -> entity)

  def saveToDb2(entity: EntityType with PrimaryKey[PrimaryKeyType]): Unit =
    data = data.+((entity.id.->(entity))) //different notation

  def get(pk: PrimaryKeyType): Option[EntityType] = data.get(pk)
}

val userRepo = new GenericRepository[User, Long]
val userWithPk = new User("Jan", "Kowalski") with PrimaryKey[Long] {
  override val id = Random.nextLong()
}

val user2 = userWithPk renameTo "Nowak"
val user2 = userWithPk renameTo ("Nowak")
user2.surname

userRepo.saveToDb(userWithPk)
userRepo.get(userWithPk.id)

def abc(/*val*/a: String): Unit = {} //will not compile if you put 'val' keyword before 'a'


//val s: String = ???
//val user: User = ???
//val obj: java.lang.Object = ???
//// ??? is only instance of type Nothing. You cannot have any other instance of it.

//val s: String = None // does not compile

object Scope
{
  import scala.collection.mutable.Map
  val map: Map[String, String] = Map[String, String]() //factory is used here // will fail in runtime without '()' at the end
  map + ("12345" -> "abcd")
}

//////////////////////////////////////////////////////////////

trait Car {
  val brand: String
  val year: String
}

class Mitsubishi(override val year: String) extends Car {
  override val brand: String = "Mitsubishi"
}

class Mercedes(override val year: String) extends Car {
  override val brand: String = "Mercedes"
}

object Car {
  def apply(year: String): Car = new Mitsubishi(year)
}

import prv.zielony.scala.tutorials._ // underscore imports all members from the package
val defaultCar = Car("2022") // invoke apply method in the companion object //factory / paraconstructor // should return Mitsubishi
defaultCar

val doSth: (Int => String) = (i: Int) => "abc"
val doSth: (Int => String) = (_: Int) => "abc" // "I dont care about input"

Option(1) // apply method on the companion method of Option

trait T1
{
  val tv1: String = "hello trait"
  def td1(): Unit = println("println from trait")
}

class C1
{
  val cv1: String = "hello class"
  def cd1(): Unit = println("println from class")
}

class C2 extends C1 with T1
{
  override def td1(): Unit = println("println overriden")
}

val c2 = new C2
c2.tv1
c2.td1()
c2.cv1
c2.cd1()

trait Trait1 {}
trait Trait2 {}
trait Trait3 {}
class Class1 {}
class Class2 extends Class1
  with Trait1
  with Trait2
  with Trait3 {}