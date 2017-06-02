package wk6

object VectorOps {

  def isPrime(n: Int): Boolean =
    (3 to n / 2).forall((c) => n % c != 0)

  def scalarProduct(as: List[Double], bs: List[Double]): Double =
    (for ((a, b) <- as zip bs)
      yield a * b) sum
}

object Queens {
  def nQueens(n: Int): Set[List[Int]] = {

    def isSafe(col: Int, queens: List[Int]): Boolean = {
      val queensWithRow = queens.reverse.zipWithIndex.reverse
      val nextRow = queens.size

      queensWithRow.forall {
        case (c, r) => c != col && Math.abs(c - col) != Math.abs(r - nextRow)
      }
    }

    def placeQueens(k: Int): Set[List[Int]] = {
      if (k == 0) Set(List())
      else for {
        queens <- placeQueens(k - 1)
        column <- 0 until n
        if isSafe(column, queens)
      } yield column :: queens
    }
    placeQueens(n)
   
  }
}
