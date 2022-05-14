package main.scala.prv.saevel.scala.oop

import main.scala.prv.saevel.scala.oop.cars.{CarRepository, InMemoryCarRepository, RentalService}
import main.scala.prv.saevel.scala.oop.people.{InMemoryPersonRepository, PersonRepository}

object Context
{
  implicit val carRepository: CarRepository = InMemoryCarRepository

  implicit val personRepository: PersonRepository = InMemoryPersonRepository

  implicit val rentalService: RentalService = new RentalService
}
