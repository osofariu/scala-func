package wk5

object MergeSort {

  def sort(xs: List[Int]) : List[Int]= {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (first, second) = xs.splitAt(n)
      merge(sort(first), sort(second))
    }
  }

  def merge(xs: List[Int], ys: List[Int]): List[Int] =
    (xs, ys) match {
      case (Nil, y) => y
      case (x, Nil) => x
      case (x :: xrest, y :: yrest) => if (x <= y) x :: merge(xrest, ys)
      else y :: merge(xs, yrest)
    }
}
