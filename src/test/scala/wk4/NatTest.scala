package wk4

import org.scalatest.{path, Matchers}

class NatTest extends path.FunSpec with Matchers {

  describe("Nat operations") {

    it("is zero when it should") {

      val n = Zero
      assert(n.isZero)
    }

    it("isn't zero when it shouldn't be") {
      val n = new Succ(Zero)
      assert(!n.isZero)
    }

    it("has a predecessor") {
      val n = new Succ(Zero)
      assert(n.predecessor.isZero)
    }

    it("has a successor") {
      val n = Zero
      assert(n.successor.predecessor == Zero)
    }

    it("can be added to another one") {
      val first = new Succ(Zero)
      val second = new Succ(Zero)
      assert((first + second).predecessor.predecessor.isZero)
    }

    it("can be subtracted from another") {
      val first = new Succ(new Succ(Zero))
      val second = new Succ(Zero)
      assert((first - second).predecessor == Zero)

    }
  }
}