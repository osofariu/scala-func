import wk3.{Empty, NonEmpty}
import wk4.{Cons, List, Nil}

trait Foo {
  val x = 10
}

trait Bar extends Foo {
  override val x = 20
}


val foos = Array[Foo](new Foo {}, new Bar {})

val oneFoo : Foo = foos(0)
assert(oneFoo.x == 10)

val getTheBar = foos(1)
assert(getTheBar.x == 20)

getTheBar.x

getTheBar match {
  case v: Bar => println("it's a bar!")
  case v : Foo => println("it's a foo!")
}

val bars  = Array[Bar](new Bar(){})
val foos2 : Array[Foo] = bars.asInstanceOf[Array[Foo]]

foos2(0) match {
  case v: Bar => println("it's a bar!")
  case v : Foo => println("it's a foo!")
}
foos2(0).x

// Array[Bar] :< Array[Foo]
// replace the generic with specific

def f(xs: List[NonEmpty], x: wk3.Empty.type ) = xs prepend x

val ne = new NonEmpty(100, Empty, Empty)
f(new Cons(ne, Nil), Empty)

