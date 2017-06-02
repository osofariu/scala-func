package wk4

import org.scalatest.{Matchers, path}
import wk3.{Empty, NonEmpty}

class ListTest extends path.FunSpec with Matchers {

  describe("List") {

    it("prepend to Nil") {
      val l = Nil.prepend(100)
      assert(l.head == 100)
      assert(l.tail == Nil)
    }

    it("prepend to Cons") {
      val l = new Cons[Int](100, Nil)
      val s = l.prepend(200)

      assert(s.head == 200)
      assert(s.tail.head == 100)
    }

    it("strange prepend") {
      def f(xs: List[NonEmpty], x: wk3.Empty.type ) = xs prepend x

      val ne = new NonEmpty(100, Empty, Empty)
      f(new Cons(ne, Nil), Empty)
    }
  }
}