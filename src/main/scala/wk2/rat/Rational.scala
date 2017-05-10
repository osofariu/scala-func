package wk2.rat

class Rational(n: Int, d: Int) {

  val numerator : Int = n / gcd(n, d)
  val denominator : Int = d / gcd(n, d)

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else  gcd(b, a % b)
  }

  override def equals(other: scala.Any): Boolean = other match {
    case other : Rational => numerator == other.numerator && denominator == other.denominator
    case _ => false
  }
}

object Rational {
  def apply(num: Int, denom: Int): Rational = {
    new Rational(num, denom)
  }
}

