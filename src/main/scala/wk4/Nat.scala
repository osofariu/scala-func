package wk4

abstract class Nat {
  def isZero: Boolean
  def predecessor : Nat
  def successor : Nat
  def + (that: Nat): Nat
  def - (that: Nat) : Nat
}

object Zero extends Nat {
  override def isZero: Boolean = true
  override def predecessor: Nat = throw new IllegalArgumentException("0 doesn't have a predecessor")
  override def successor: Nat = new Succ(this)
  override def +(that: Nat): Nat = that
  override def -(that: Nat): Nat =
    if (that.isZero) this
    else throw new IllegalArgumentException("only 0 can be subtracted from 0")
}

class Succ(n: Nat) extends Nat {
  override def isZero: Boolean = false

  override def predecessor: Nat = n

  override def successor: Nat = new Succ(this)

  override def +(that: Nat): Nat = new Succ(n + that)

  override def -(that: Nat): Nat =
    if (that isZero) this
    else n - that.predecessor
}

