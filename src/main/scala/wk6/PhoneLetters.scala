package wk6

import scala.io.Source

class PhoneLetters {

  val wordsUrl = "https://raw.githubusercontent.com/dwyl/english-words/master/words.txt"
  val words: List[String] = Source.fromURL(wordsUrl).getLines.toList filter (word => word.forall(c => c.isLetter))

  def count = words.length
  def first(n: Int) = words take n

  def segmentN(n: Int) : List[Int] = {
    def segmentAcc(l  : List[Int], m: Int) : List[Int] = {
      (for (i <- 1 to m if (i + m <= n)) yield segmentAcc(i :: l, m - i)).toList
    }
    segmentAcc(List(), n)
  }
}
/*


N - subsets of all sizes that add-up to N
now many segments of N?

N -



 */