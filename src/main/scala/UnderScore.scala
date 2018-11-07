import utility.Utilities._
object UnderScore extends App {

  // UnderScore is exploited in scala
  // Here are code to demonstrate some of them

  ---------
  val l = List(23, 34, 45, 223, 43, 465, 67, 23, 12, 56, 78, 9892)
  val (even, odd) = l partition (_ % 2 == 0)
  println(s"even :: $even")
  println(s"odd :: $odd")
  ---------

  def doubleInt(i: Int) = 2 * i
  def tripleInt(i: Int) = 3 * i
  def quadrupleInt(i: Int) = 4 * i
  val numList = List(1, 2, 3, 4, 5)

  val funList: List[Int => Int] = numList.flatMap {
    case 2 => List(doubleInt _)
    case 3 => List(tripleInt _)
    case 4 => List(quadrupleInt _)
    case _ => List()
  }

  val result = funList.foldLeft(1)((acc, fun) => acc + fun(acc))
  // 1 + doubleInt(1) + tripleInt(3) + quadrupleInt(12)
  // ((((1) + 2*1) + 3*3) + 4*12)
  println(s"result :: $result") // result :: 60
  ---------

  val k: Option[Int] = Some(1)
  k match {
    case Some(a) => println(a)
    case None => println("None")
  }
}
