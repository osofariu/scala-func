package wk2.rat

import org.scalatest.{Matchers, path}

class RationalTest extends path.FunSpec with Matchers {
  describe("construct, reduces, displays, and exposes nominator and denominator") {

    it("constructs Rational Number") {
      Rational(1, 2)
    }

    it("reveals numerator and denominator") {
      val rat = Rational(12, 13)
      rat.numerator shouldBe 12
      rat.denominator shouldBe 13
    }

    it("reduces rational to simplest form") {
      val rat = Rational(30, 42)
      rat.numerator shouldBe 5
      rat.denominator shouldBe 7
    }

    it("allows me to compare rationals") {
      val rat = Rational(1, 2)
      val otherRat = Rational(1, 2)
      rat shouldEqual otherRat
    }
  }
}
