package wk5

import org.scalatest.{path, Matchers}

class FlattenTest extends path.FunSpec with Matchers {

  describe("Flatten") {

    it("works with empty lists") {
      Flatten.flatten(List()) shouldEqual  List()
    }

    it("works with already flat lists") {
      Flatten.flatten(List(1, 2, 3)) shouldEqual List(1, 2, 3)
    }

    it("works with nested lists where first item is not a list") {
      Flatten.flatten(List(List(List(3, List(4)), "three"))) shouldEqual List( 3, 4, "three")
    }

    it("works with nested lists where first item is list") {
      Flatten.flatten(List(1, List(2), List(List(3, List(4)), "three"))) shouldEqual List(1, 2, 3, 4, "three")
    }
  }

}