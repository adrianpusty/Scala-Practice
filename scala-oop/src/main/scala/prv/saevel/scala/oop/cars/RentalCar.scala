package main.scala.prv.saevel.scala.oop.cars

class RentalCar(private val serialNumber: Long, override val brand: String, override val model: String, override var owner: String, val rental: String) extends Car(serialNumber, brand, model, owner) {}
