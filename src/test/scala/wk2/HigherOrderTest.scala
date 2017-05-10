package wk2

import org.scalatest.Matchers
import org.scalatest._

class HigherOrderTest extends path.FunSpec with Matchers {

  val ho: HigherOrder = new HigherOrder

  describe("product of function values for points on interval") {

    it("applies and computes product when min input < max input") {
      ho.prod(i => i * 2)(2, 3).shouldEqual(24)
      ho.prodNoMap(i => i * 2)(2, 3).shouldEqual(24)
    }

    it("returns nothing when the min input > max input") {
      ho.prod(i => i)(3, 2).shouldEqual(1)
      ho.prodNoMap(i => i)(3, 2).shouldEqual(1)
    }

    it("can be used to compute factorial by using the identity function") {
      ho.prod(i => i)(1, 4).shouldEqual(24)
      ho.prodNoMap(i => i)(1, 4).shouldEqual(24)
    }

    it("can take in the product as a funtion, so we can generalize it") {
      ho.doit((a: Seq[Int]) => a.sum)(i => i * 3)(2, 3).shouldEqual(15)
      ho.mapReduce(i => i * 3)((a,b) => a + b, 0)(2, 3).shouldEqual(15)
    }

    it("can compute factorial using the generic doit function") {
      ho.doit((a: Seq[Int]) => a.product)(i => i)(1, 10).shouldEqual(3628800)
      ho.mapReduce(i => i)((a, b) => a * b, 1)(1, 10).shouldEqual(3628800)
    }
  }
}
