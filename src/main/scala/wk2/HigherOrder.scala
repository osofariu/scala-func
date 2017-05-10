package wk2

class HigherOrder {
  def prod(fn: Int => Int)(inputs: (Int, Int)) = {
    def r = new Range(inputs._1, inputs._2 + 1, 1)
    r.map(fn).product
  }

  def prodNoMap(fn: Int => Int)(a: Int, b: Int) : Int = {
    if (a > b)
      1
    else {
      fn(a) * prodNoMap(fn)(a + 1, b)
    }
  }

  def doit(fn_all: (Seq[Int]) => Int)(fn_each: Int => Int)(inputs: (Int, Int)) = {
    def r = new Range(inputs._1, inputs._2 + 1, 1)
    fn_all(r.map(fn_each))
  }

  def mapReduce(f: Int => Int)(reduce: (Int, Int) => Int, u: Int)(a: Int, b: Int) : Int = {
    if (a > b)
      u
    else {
      reduce(f(a), mapReduce(f)(reduce, u)(a + 1, b))
    }
  }
}


