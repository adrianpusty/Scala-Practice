package main.scala.prv.saevel.scala.oop.people

import main.scala.prv.saevel.scala.oop.persistence.PrimaryKey

import scala.util.Random

class Person private(override val id: Long, val name: String, val surname: String) extends PrimaryKey[Long] {}

object Person
{
  def apply(name: String, surname: String): Person = new Person(Random.nextLong, name, surname)
}
