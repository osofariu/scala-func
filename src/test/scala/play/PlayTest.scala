package play

import org.scalatest.{Matchers, path}

class PlayTest extends path.FunSpec with Matchers {

  describe("currying example") {

    def sum(f: Int => Int)(a: Int, b: Int) : Int = {
      if (a > b) 0 else f(a) + sum(f)(a + 1, b)
    }

    def sum2(f: Int => Int) : (Int, Int) => Int = {
      def sum2Helper(a: Int, b: Int) = {
        if (a > b) 0 else f(a) + sum(f)(a + 1, b)
      }
      sum2Helper
    }

    def fact(n: Int) : Int = {
      assert(n >= 0)
      if (n <= 1) 1 else n * fact(n-1)
    }

    def sumInts = sum(x => x)(_,_)
    def sumInts2 = sum2(x => x)


    it ("implement sum with currying") {
      sumInts(1, 2) shouldBe 3
      sumInts(1, 2) shouldBe sumInts2(1, 2)
    }
  }

  describe("more examples of curying") {
    /*
      1. Write a product function that calculates the product of the values of
        a function for the points on a given interval.
      2. Write factorial in terms of product.
      3. Can you write a more general function, which generalizes both sum
        and product?
     */

    def product(f: Int => Int)(start: Int, end: Int) : Int = {
      if (start > end) 1 else f(start) * product(f)(start + 1, end)
    }

    it("use product to define factorial") {
      product(x => x)(1, 4) shouldBe 24
    }

    def aggregate(f: Int => Int, ag: (Int, Int) => Int, ident: Int)(start: Int, end: Int) : Int = {
      if (start > end) ident else ag(f(start), aggregate(f, ag, ident)(start + 1, end))
    }

    it("works more generically") {
      aggregate(x => x, (a: Int, b: Int) => a + b, 0)(1,5) shouldBe 15
      aggregate(x => x, (a: Int, b: Int) => a * b, 1)(1, 5) shouldBe 120
    }

  }
}
