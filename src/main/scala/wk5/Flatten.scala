package wk5

object Flatten {

  def flatten(lst: List[Any]): List[Any] = {
    def partFlatten(item: Any): List[Any] = item match {
      case x :: xs => partFlatten(x) ::: flatten(xs)
      case other => List(other)
    }

    lst match {
      case List() => List()
      case s :: xs => s match {
        case s1 :: s2 => partFlatten(s1) ::: flatten(s2) ::: flatten(xs)
        case other => other :: flatten(xs)
      }
    }
  }
}
