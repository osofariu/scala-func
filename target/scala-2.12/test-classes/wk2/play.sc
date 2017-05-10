def r = new Range(1, 11, 1)
r.map(i => i).sum


val r2 = new Range(10, 1, 1)

r2.map(i => i).product


def gcd(a: Int, b: Int): Int = {
  println("gcd(" + a + "," + b + ")")
  if (a == b) a else {
    val diff = Math.max(a, b) - Math.min(a, b)
    gcd(Math.min(a, b), diff)
  }
}

gcd(30, 42)
