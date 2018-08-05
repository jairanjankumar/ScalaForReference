import utility.Utilities._

import scala.util.{Failure, Success, Try}

object ScalaTry extends App {

  ---------
  def divide: Try[Int] = {
    val dividend: Int = 3
    val divisor: Int = 1
    val problem: Try[Int] = Try(dividend / divisor)

    problem.map(println)

    problem match {
      case Success(v) =>
        println(s"Result :: $v")
        Success(v)
      case Failure(e) =>
        println("Exception: " + e.getMessage)
        Failure(e)
    }
  }

  divide

  ---------
  //Worth to mention java style of Exception handling
  try {
    1 / 0
  } catch {
    case e: Exception => println(s"java try :: ${e.getMessage}")
  }
  finally {
    println("done with try")
  }
  ---------
}
