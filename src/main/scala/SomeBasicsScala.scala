import com.sun.codemodel.internal.JStringLiteral
import utility.Utilities._

object SomeBasicsScala extends App {

  ---------
  // All below are same
  val b1: Byte = 40
  val b2 = 40: Byte
  val b3 = 40.asInstanceOf[Byte]
  val b4 = 40.toByte // convert Int to Byte

  ---------
  val result1 = 10 + 20
  val result2 = 10.+(20)

  ---------
  val e = 10
  val result3 =
    if (e > 10) "Greater than 10"
    else if (e < 10) "less than 10"
    else "equal to 10"

  println(result3) //equal to 10

  ---------
  //String Interpolator
  val si = 10
  println(s"si value $si")
  println(s"Si plus one value ${si + 1}")

  println(raw" with raw String \n Interpolator") // \n - treated as simple string
  println(" without raw String \n Interpolator") // \n - new line

  println(f"${scala.math.Pi}%2.2f")
  ---------

  //y is the default parameter
  def defaultValueFun(x: Int, y: Int = 500) = {
    x + y //last evaluated statement
  }

  val noDefaultPassed = defaultValueFun(100, 200)
  println(s"noDefaultPassed :: $noDefaultPassed") // noDefaultPassed :: 300

  val defaultPassed = defaultValueFun(100)
  println(s"defaultPassed :: $defaultPassed") // defaultPassed :: 600
  ---------

  val result4 = (1 to 10).toList
  println(result4) // List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  val result5 = (10 to 1 by -1).toList
  println(result5) // List(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)

  for (i <- 1 to 10) {
    println(i)
  }

  // for comprehension
  val result6 = for (i <- 1 to 10) yield (i + 1)
  println(result6) //Vector(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
  // Vector is high performing List

  val alternateNum = for (i <- 1 to 10 by 2) yield i
  println(alternateNum) // Vector(1, 3, 5, 7, 9)

  ---------
  val l1 = Nil
  val l2 = List()
  //but good to create with Type
  val l3: List[String] = Nil
  val l4 = List[String]()

  val l5 = 1 :: 2 :: 3 :: Nil
  val l6 = List(1, 2, 3)

  ---------
  // Null is only there in scala to interact with java code
  // Use option to avoid null in scala
  val o1: Option[String] = Some("text")
  val o2: Option[String] = None

  ---------
  val r1 = "this is a long text" +
    "and how to handle this"

  println(s"r1 :: $r1") // r1 :: this is a long textand how to handle this

  val r2 =
    """this is a long text
              and how to handle this"""

  println(s"r2 :: $r2")
  //above will print something like below
  // r2 :: this is a long text
  //               and how to handle this

  val r3 =
    """this is a long text
      |and how to handle this
      |even more""".stripMargin

  println(s"r3 :: $r3") // this will well formated with new line
  // so r2 will be printed as below
  // r3 :: this is a long text
  // and how to handle this
  // even more

  ---------

  object thisIsAOject //already initialized!

  val a = thisIsAOject
  val b = thisIsAOject

  a.equals(b) //object equality
  a == b //object equality
  a eq b //reference equality

  ---------
  //Collections
  // Vector
  // Map
  // Set

  val vector = Vector(1, 2, 3, 4)

  // All below are same
  val m1: Map[Int, String] = Map.apply((1, "One"), (2, "Two"))
  val m2: Map[Int, String] = Map((1, "One"), (2, "Two"))
  val m3: Map[Int, String] = Map(1 -> "One", 2 -> "Two")

  val s1 = Set(4, 3, 1, 3)
  println(s"s1 :: $s1") //Set(4, 3, 1) -- Duplicate will be removed

  ---------
  // just a tuple
  val t1 = (1, "One")
  val t2 = 1 -> "One"
  ---------

}
