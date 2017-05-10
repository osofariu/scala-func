package wk3

import org.scalatest.{Matchers, path}
import wk3.IntSets.{set1, set2, set3}

class IntSetTest extends path.FunSpec with Matchers {

  describe("IntSet operations") {

    it("adds elements of my set to a scala set") {
      set1.toScalaSet.toArray shouldBe Array(10, 12, 14)
    }

    it("unions are ways of combining sets") {
      set1.union(set2).toScalaSet.toArray.sorted shouldBe Array(8, 9, 10, 11, 12, 14, 20, 100)
      set1.union(set3).toScalaSet.toArray.sorted shouldBe Array(8, 9, 10, 11, 12, 14, 20, 100)
    }
  }
}
