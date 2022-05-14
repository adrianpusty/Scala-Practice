package main.scala.prv.saevel.scala.oop.cars

import main.scala.prv.saevel.scala.oop.persistence.InMemoryRepository

object InMemoryCarRepository extends CarRepository with InMemoryRepository[Long, Car]
{
  override def findByBrand(brand: String): List[Car] = items.filter(car => car.brand == brand)

  override def findByModel(model: String): List[Car] = items.filter(car => car.model == model)
}
