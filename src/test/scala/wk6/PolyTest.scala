package wk6

import org.scalatest.{path, Matchers}

class PolyTest extends path.FunSpec with Matchers {


  describe("Poly implementation") {

    case class Poly(coefficients: Map[Int, Double]) {
      val terms: Map[Int, Double] = coefficients withDefaultValue 0.0
      def this(c: (Int, Double)*) = this(c.toMap)

      def +(other: Poly): Poly = {
        def adjust(p: (Int, Double)): (Int, Double) = p._1 -> (p._2 + terms(p._1))
        Poly(terms ++ (other.terms map adjust))
      }

      def otherAdd(other: Poly): Poly = {
        Poly((other.terms foldLeft terms) (addTerm))
      }
      def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
        val (power, coeff) = term
        terms + (power -> (coeff + terms(power)))
      }

      override def toString: String =
        (for ((power, coeff) <- terms.toList.sorted.reverse) yield coeff + "*x^" + power) mkString " + "
    }

    it("Can be printed") {
      val p = new Poly(0 -> 3.0, 1 -> 10.0, 3 -> 1.0)
      p.toString shouldBe "1.0*x^3 + 10.0*x^1 + 3.0*x^0"
    }

    it("Can be added") {
      val p1 = new Poly(0 -> 3.0, 1 -> 10.0,          3 -> 1.0, 4 -> 3.0)
      val p2 = new Poly(0 -> 2.0, 1 -> 2.0, 2 -> 2.0, 3 -> 5.0)
      val p12 = new Poly(0 -> 5.0, 1 -> 12.0, 2 -> 2.0, 3 -> 6.0, 4 -> 3.0)
      (p1 + p2) shouldEqual p12
      (p1 otherAdd p2) shouldEqual p12
    }
  }
}
