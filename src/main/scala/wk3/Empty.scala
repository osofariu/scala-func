package wk3

object Empty extends IntSet {
  override def contains(v: Int) : Boolean = false
  override def incl(v: Int): IntSet = new NonEmpty(v, Empty, Empty)
  override def union(otherSet: IntSet): IntSet = otherSet
  override def toScalaSet: Set[Int] = Set[Int]()
  override def toString: String = toScalaSet.toString
}
