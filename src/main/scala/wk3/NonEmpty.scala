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
    left union otherSet union right incl v
  }
}
