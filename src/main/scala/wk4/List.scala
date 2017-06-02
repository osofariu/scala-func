package wk4

trait List[+T] {
  def isEmpty : Boolean
  def head: T
  def tail: List[T]
  def prepend[U >: T](elem: U): List[U]
}

object Nil extends List[Nothing] {
  override def isEmpty: Boolean = true
  override def head: Nothing =  throw new Error("Nil.head")
  override def tail: Nothing = throw new Error("Nil.tail")
  override def prepend[T](elem: T): List[T] = new Cons(elem, Nil)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
  override def prepend[U >: T](elem: U): List[U] = {
    new Cons[U](elem, this)
  }
}

object List {
  def apply[T]() = Nil
  def apply[T](v: T) = new Cons(v, Nil)
  def apply[T](v: T, w: T) = new Cons(v, new Cons(w, Nil))
}

object Explore {
  List()
  List(1)
  List(1, 2)
}

object TryEmpty {
  val lv : List[String] = Nil
  assert(lv.isEmpty)
}