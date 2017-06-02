package wk3

import org.scalatest.{Matchers, path}
import wk3.IntSets.{set1, set2, set3}

class IntSetTest extends path.FunSpec with Matchers {

  describe("IntSet operations") {

    it("adds elements of my set to a scala set") {
      Array(10, 12, 14).foreach(v => set1.contains(v))
    }

    it("unions are ways of combining sets") {
      val sets1_2 = set1.union(set2)
      Array(8, 9, 10, 11, 12, 14, 20, 100).foreach(v => assert(sets1_2.contains(v)))

      val sets1_3 = set1.union(set3)
      Array(8, 9, 10, 11, 12, 14, 20, 100).foreach(v => assert(sets1_3.contains(v)))
    }
  }
}
