package wk4

abstract class PureBoolean {

  def ifThenElse[T](t: T, e: T) : T

  def unary_! : PureBoolean= ifThenElse(myFalse, myTrue)
  def == (other: PureBoolean) : PureBoolean = ifThenElse(other, other.unary_!)
  def != (other: PureBoolean) : PureBoolean = ifThenElse(other.unary_!, other)
  def <  (other: PureBoolean) : PureBoolean
}

object myTrue extends PureBoolean {
  override def ifThenElse[T](t: T, e: T): T = t
  override def <(other: PureBoolean): PureBoolean = {
    myFalse
  }
}

object myFalse extends PureBoolean {
  override def ifThenElse[T](t: T, e: T): T = e
  override def <(other: PureBoolean): PureBoolean =
    other.ifThenElse(myTrue, myFalse)
}


object Trial {

  val x = 12
  val y = 13
//
//  val xIs12 : PureBoolean = {
//    // returns myTrue
//
//  }
//
//  myTrue.ifThenElse[Int]()
}