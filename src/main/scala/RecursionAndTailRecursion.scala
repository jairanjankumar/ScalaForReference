import utility.Utilities._

object RecursionAndTailRecursion extends App {

  ---------
  // Recursion
  def recursion[A](count: Int, item: A): List[A] = {
    count match {
      case 0 => Nil
      case n => item :: recursion(n - 1, item)
    }
  }

  println("RECURSION")
  println(recursion(0, "item")) // Nil
  println(recursion(1, 2)) // List(2)
  println(recursion(2, "item")) // List("item", "item")
  println(recursion(3, true)) // List(true, true, true)
  ---------

  // Tail Recursion
  // in Tail Recursion, before calling itself there should not be any pending task
  // in above Recursion example, "item :: recursion(n - 1, item)" is a pending task
  def tailRecursion[A](count:Int, item:A):List[A] = {

    def tailRecursionHelper(count: Int, item: A, acc: List[A]): List[A] = {
      count match {
        case 0 => acc
        case n => tailRecursionHelper(n - 1, item, item :: acc)
      }
    }
    tailRecursionHelper(count, item, Nil)
  }

  println(s"\nTAIL RECURSION")
  println(tailRecursion(0, "item")) // Nil
  println(tailRecursion(1, 2)) // List(2)
  println(tailRecursion(2, "item")) // List("item", "item")
  println(tailRecursion(3, true)) // List(true, true, true)
  ---------
}
