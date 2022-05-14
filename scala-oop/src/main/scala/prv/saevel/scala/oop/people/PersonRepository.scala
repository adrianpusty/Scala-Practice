package main.scala.prv.saevel.scala.oop.people

import main.scala.prv.saevel.scala.oop.persistence.Repository

trait PersonRepository extends Repository[Long, Person] {}
