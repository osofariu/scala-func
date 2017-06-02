package wk5

import org.scalatest.{path, Matchers}
import MergeSort.sort

class MergeSortTest extends path.FunSpec with Matchers {

  describe("merge sort") {

    it("sorts lists of size 0") {
      sort(List()) shouldEqual(List)()
    }

    it("sorts lists of size 1") {
      sort(List(10)) shouldEqual(List(10))
    }

    it("sorts lists of size 2 previously in order") {
      sort(List(1, 2)) shouldEqual List(1, 2)
    }

    it("sorts lists of size 2 previously out of order") {
      sort(List(2, 1)) shouldEqual List(1, 2)
    }

    it("sorts lists of size 3 in reverse order") {
      sort(List(3, 2, 1)) shouldEqual List(1, 2, 3)
    }
    it("sorts lists of size 10 in apparent random order order") {
      sort(List(6, 3, 8, 9, 1, 5, 2, 5 , 6, 4)) shouldEqual List(1, 2, 3, 4, 5, 5, 6, 6,  8, 9)
    }
  }

}