package prv.zielony.scala.tutorials.day1

/**
  * Created by zielony on 01.02.16.
  */
object Algorithmics {

  /**
    * The goal of the first exercise is to implement the factorial function defined as:
    *    - for negative numbers (None)
    *    - for zero: 1
    *    - for positive numbers: factorial(n) = n * factorial(n-1)
    */

  def factorial(input: Int): Option[Int] = {
    if (input > 0) {
      for (x <- Option(input); y <- factorial(input - 1)) yield x * y
    }
    else if (input == 0) {
      Option(1)
    }
    else {
      None
    }
  }

  /**
    * The goal is to implement a function calculating Fibonacci numbers, defined as:
    *  - for negative numbers: undefined (None)
    *  - for zero: 0
    *  - for one: 1
    *  - for positive numbers: f(n) = f(n-1) + f(n-2)
    */

  def fibonacci(n: Int): Option[Int] = {
    if (n == 1) {
      Option(1)
    }
    else if (n == 0) {
      Option(0)
    }
    else if (n > 1) {
      for (x <- fibonacci(n - 1); y <- fibonacci(n - 2)) yield x + y
      //        (fibonacci(n-1) ++ fibonacci(n-2)).reduceOption(_ + _) // alternatively
    }
    else {
      None
    }
  }
}
