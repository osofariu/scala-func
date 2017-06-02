package wk6

import org.scalatest.{Matchers, path}

class VectorOpsTest extends path.FunSpec with Matchers {

  describe("Operations") {

    val vec1 = Vector(1, 5, 3, 6, 2, 7, 9)

    it("appends -- instead of :: use :+ ") {
      vec1 :+ 10 shouldBe Vector(1, 5, 3, 6, 2, 7, 9, 10)
    }

    it("preppends") {
      10 +: vec1 shouldBe Vector(10, 1, 5, 3, 6, 2, 7, 9)
    }

    it("fold left with operator, but initial value goes first") {
      (0 /: vec1)( (acc, e) => acc + 2 * e) shouldBe 66
    }
  }

  describe("prime") {

    it("works") {
      VectorOps.isPrime(2) shouldBe true
      VectorOps.isPrime(12) shouldBe false
      VectorOps.isPrime(13) shouldBe true
      VectorOps.isPrime(19) shouldBe true
      VectorOps.isPrime(20) shouldBe false
    }
  }

  describe("queens") {
    it("queens of size 4") {
      Queens.nQueens(4) shouldBe Set(List(2, 0, 3, 1), List(1, 3, 0, 2))
    }
    it("queens of sze 5") {
      Queens.nQueens(5) shouldBe Set(List(0, 3, 1, 4, 2), List(2, 0, 3, 1, 4), List(0, 2, 4, 1, 3), List(2, 4, 1, 3, 0), List(1, 3, 0, 2, 4), List(3, 0, 2, 4, 1), List(4, 2, 0, 3, 1), List(4, 1, 3, 0, 2), List(3, 1, 4, 2, 0), List(1, 4, 2, 0, 3))
    }
  }
}
