package wk3

class NonEmpty(v: Int, left: IntSet, right: IntSet) extends IntSet {
  override def contains(v_other: Int): Boolean = {
    if (v_other < v) left.contains(v_other)
    else if (v_other > v) right.contains(v_other)
    else true
  }

  override def incl(v_other: Int): IntSet = {
    if (v_other < v) new NonEmpty(v, left.incl(v_other), right)
    else if (v_other > v) new NonEmpty(v, left, right.incl(v_other))
    else this
  }
  override def union(otherSet: IntSet): IntSet = {
    println("this set: " + this)
    println("otherSet: " + otherSet + "\n")
    otherSet.union(left).union(right).incl(v)
  }

  override def toScalaSet: Set[Int] = {
    left.toScalaSet + v ++ right.toScalaSet
  }

  override def toString: String =
    prettySet(left) + "<" + v.toString + ">" + prettySet(right)

  def prettySet(set: IntSet): String = {
    if (set.toScalaSet.isEmpty) "()"
    else if(set.toScalaSet.size == 1) "<" + set.toScalaSet.toList.last + ">"
    else "(" + set.toString + ")"
  }
}
