import scala.collection.mutable.ListBuffer

object BackTickUse extends App {

  // Some scala tricks if you hate your co-workers

  // just variable name
  val isThisAQuestion_? = true
  println(s"isThisAQuestion_? :: ${isThisAQuestion_?}") //isThisAQuestion_? :: true

  // variable name with spaces and with backtick (`)
  val `Tell me your age !!` = 34
  println(s"Tell me your age !! :: ${`Tell me your age !!`}") //Tell me your age !! :: 34

  // say `true` as variable and assign false.. epic..
  val `true` = false
  val r1 = if (`true`) false else true
  println(s"r1 :: $r1") // r1 :: true

  // A function name like below
  def `Add 1 to specified Int`(x: Int) = x + 1

  val r2 = `Add 1 to specified Int`(4)
  println(s"r2 :: $r2") // r2 :: 5

  val `text/html` = 10
  println(s"text/html :: ${`text/html`}") // text/html :: 10

  //---------------------
  // Given a List(1, 1, 1, 1, 2, 2, 2, 3, 4, 4, 4, 1, 1, 5, 2, 2, 1, 1, 1)
  // write a function to accept int and return List[List[Int]] as below
  // for 1, function should return List(List(1, 1, 1, 1), List(1, 1), List(1, 1, 1))
  // for 2, List(List(2, 2, 2), List(2, 2))

  def giveMeList(i: Int): List[List[Int]] = {
    val v = List(1, 1, 1, 1, 2, 2, 2, 3, 4, 4, 4, 1, 1, 5, 2, 2, 1, 1, 1)

    val l = new ListBuffer[List[Int]]()
    val newL = new ListBuffer[Int]()

    v.foreach {
      case `i` => newL += i
      case _ => {
        if(!newL.isEmpty) l += newL.toList
        newL.clear()
      }
    }
    if(!newL.isEmpty) l += newL.toList

    l.toList.filterNot(_.isEmpty)
  }

  val r3 = giveMeList(1)
  println(r3) // List(List(1, 1, 1, 1), List(1, 1), List(1, 1, 1))
  //---------------------

}
