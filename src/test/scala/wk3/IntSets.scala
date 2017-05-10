package wk3

object IntSets {

  val set1 = new NonEmpty(12, Empty.incl(10), Empty.incl(14))
  val set2 = new NonEmpty(11, new NonEmpty(9, Empty.incl(8), Empty.incl(10)), new NonEmpty(20, Empty.incl(14), Empty.incl(100)))
  val set3 = new NonEmpty(11,
      new NonEmpty(9, new NonEmpty(10, Empty, new NonEmpty(8, Empty, Empty)), Empty.incl(10)),
      new NonEmpty(20, Empty.incl(14), Empty.incl(100))
  )
}
