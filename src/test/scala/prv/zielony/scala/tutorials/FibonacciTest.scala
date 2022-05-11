package prv.zielony.scala.tutorials

import org.junit.runner.RunWith
import org.scalacheck.{Gen, Prop}
import org.scalatest.FunSuite
import org.scalatest.Matchers.{convertToAnyShouldWrapper, equal}
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.{Checkers, PropertyChecks}

/**
 * Created by zielony on 01.02.16.
 */
@RunWith(classOf[JUnitRunner])
class FibonacciTest extends FunSuite with PropertyChecks with Checkers {

  val integerGreaterThanOneGenerator: Gen[Int] = Gen.choose(2, 10)

  val zeroGenerator: Gen[Int] = Gen.const(0)

  val oneGenerator: Gen[Int] = Gen.const(1)

  val nonNegativeIntGenerator: Gen[Int] = Gen.choose(0, 10)

  val negativeIntGenerator: Gen[Int] = Gen.choose(-100, -1)

  test("Defined for non-negative integers") {
    check(Prop.forAll(nonNegativeIntGenerator) { input =>
      Algorithmics.fibonacci(input).isDefined
    })
  }

  test("Undefined for negative integers") {
    check(Prop.forAll(negativeIntGenerator) {input =>
      Algorithmics.fibonacci(input).isEmpty
    })
  }

  test("Equal to 0 for 0") {
    check(Prop.forAll(zeroGenerator) { input =>
      val result = Algorithmics.fibonacci(input)

      result.isDefined && (result.get == 0)
    })
  }

  test("Equal to 1 for 1") {
    check(Prop.forAll(oneGenerator) { input =>
      val result = Algorithmics.fibonacci(input)

      result.isDefined && (result.get == 1)
    })
  }

  test("Recursive") {
    check(Prop.forAll(integerGreaterThanOneGenerator) { input =>
      val result = Algorithmics.fibonacci(input)

      result.isDefined && (result.get == (Algorithmics.fibonacci(input-1).get + Algorithmics.fibonacci(input-2).get))
    })
  }

  test("Check sequence correctness") {
    val expected = List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765)
      .map(i => Some(i))

    Range(0, 21)
      .map(index => (index, Algorithmics.fibonacci(index)))
      .foreach(tuple => tuple._2 should equal(expected(tuple._1)))
  }

}
