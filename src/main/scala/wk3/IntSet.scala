package wk3

abstract class IntSet {
  def incl(v: Int): IntSet
  def contains(v: Int): Boolean
  def union(otherSet: IntSet) : IntSet
}
