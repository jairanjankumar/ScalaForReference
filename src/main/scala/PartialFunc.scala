import utility.Utilities._

object PartialFunc extends App {

  val divide = new PartialFunction[Int, Int] {
    val someInt = 10
    def apply(x: Int) = someInt / x
    def isDefinedAt(x: Int) = x != 0
  }

  val x1 = 1
  val x2 = 0

  val r1 = if (divide.isDefinedAt(x1)) divide(x1) else 0
  val r2 = if (divide.isDefinedAt(x2)) divide(x2) else 0

  println(s"r1 : $r1, r2 : $r2")

  ---------
  //Same as above
  val divide2: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 10 / d
  }
  ---------

 // List(0,1,2) map { divide }  - map would fail, rather use collect
  val res3: List[Int] = List(0,1,2) collect { divide }
  res3 foreach println
}
