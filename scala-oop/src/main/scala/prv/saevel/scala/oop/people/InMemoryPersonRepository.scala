package main.scala.prv.saevel.scala.oop.people

import main.scala.prv.saevel.scala.oop.persistence.InMemoryRepository

object InMemoryPersonRepository extends PersonRepository with InMemoryRepository[Long, Person]
