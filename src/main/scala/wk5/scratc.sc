val l = List(1, 2, 3, 4, 11, 12, 13, 14)
l span (i => i < 10)


def pack[T](l: List[T]) : List[List[T]] = l match {
  case Nil => Nil
  case x :: xs => {
    val segments = xs span (item => item == x)
    (x :: segments._1) :: pack(segments._2)
  }
}

val l2 = List(1, 1, 2, 2, 2, 3)
pack(l2)


def encode[T](l: List[T]) : List[Tuple2[T, Int]] = {
  pack(l).map (l => (l.head, l.size))
}
encode(l2)
val z = 0
l2 reduceLeft((z, i) => z + i)

1 :: l2 reduceLeft(_ + _)

List(12) reduceLeft(_ + _)

//List[Int]() reduceLeft(_ + _)

l2.foldLeft(0)(_ + _)
(l2 foldLeft 0)(_ + _)

List[Int]().foldLeft(0)(_ + _)


def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())((t, z) => f(t) :: z)

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)( (t, z) => 1 + z )


mapFun[Int, Int](List[Int](1, 2, 3), (z) => z * 2)
lengthFun[Int](List(1, 2, 3, 4))

def mapFunReverse[T, U](xs: List[T])(f: T => U) : List[U] =
  (xs foldLeft List[U]())((z, t) => f(t) :: z)


mapFunReverse[Int, Int](List[Int](1, 2, 3))((z) => z * 2)
