package main.scala.prv.saevel.scala.oop.cars

import main.scala.prv.saevel.scala.oop.persistence.Repository

trait CarRepository extends Repository[Long, Car]
{
  def findByBrand(brand: String): List[Car]
  def findByModel(model: String): List[Car]
}
