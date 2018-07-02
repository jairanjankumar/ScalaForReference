import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSuite, Matchers}

@RunWith(classOf[JUnitRunner])
class PatternMatching extends FunSuite with Matchers {

  ///////////////////////////////////////////////////

  test(" Integer ") {

    val x: Int = 10
    x should be(10)
  }

  ///////////////////////////////////////////////////

  test(" get from tuple ") {

    val (x, y) = (123, "text")
    x should be(123)
    y should be("text")
  }

  ///////////////////////////////////////////////////

  test(" Getting the whole item along with individual items ") {

    val t@(x, y) = (123, "text")
    x should be(123)
    y should be("text")
    t should be(123 -> "text")
    t should be(123, "text")
  }

  ///////////////////////////////////////////////////

  test(" With an Option, Some ") {

    val Some(x) = Some(10)
    x should be(10)
  }

  ///////////////////////////////////////////////////

  test("_ is used for not interested element") {

    // In tuple
    val (a, _, c) = (1, "not interested", "Text")
    a should be(1)
    c should be("Text")

    //here just to check Option
    val Some(_) = Some(100)

    // here just to check item is Int"
    val _: Int = 10
  }

  ///////////////////////////////////////////////////

  test("Working with Lists") {

    val l1@List() = Nil
    l1 should be('empty)
    l1 should be(Nil)
    l1 should be(List())

    // Nil represents an empty list
    val l2@Nil = Nil
    l2 should be('empty)

    // :: can be used to check List item
    val i :: Nil = List(10)
    i should be(10)

    // or List() can also be used
    val List(j) = List(10)
    j should be(10)

    // to check EXACT number of items in List
    val first :: second :: third :: Nil = List("Item1", "Item2", "Item3")
    first should be("Item1")
    second should be("Item2")
    third should be("Item3")

    // same, but using List to check EXACT number of items in List
    val List(fst, snd, trd) = List("Item1", "Item2", "Item3")
    fst should be("Item1")
    snd should be("Item2")
    trd should be("Item3")

    // head and tail
    val head :: tail = (1 to 5).toList
    head should be(1)
    tail should be(List(2, 3, 4, 5))

    // first, second and rest
    val List(f, s, rest@_*) = (1 to 5).toList
    f should be(1)
    s should be(2)
    rest should be(List(3, 4, 5))

    // first, second and and do not care about rest
    val List(fi, se, _*) = (1 to 5).toList
    fi should be(1)
    se should be(2)

    // first, second and and do not care about rest, but using ::
    val fir :: sec :: _ = (1 to 5).toList
    fir should be(1)
    sec should be(2)

    // first, second. rest and all
    val all@firs :: seco :: r = (1 to 5).toList
    firs should be(1)
    seco should be(2)
    r should be(List(3, 4, 5))
    all should be(List(1, 2, 3, 4, 5))
  }

  ///////////////////////////////////////////////////

  test("Tuple, match") {

    val tuple: Any = (1, 2.0, "text")

    val output = tuple match {
      case (x, y) => s"Int $x and double $y"
      case (x, y, z) => s"Int $x , double $y and String $z"
      case _ => s"No match"
    }

    output should be("Int 1 , double 2.0 and String text")
  }

  ///////////////////////////////////////////////////

  test("Match Error") {

    // try to match with tuple
    val triple: Any = (1, 2.0, "xyz")
    a[MatchError] should be thrownBy {
      val (x, y) = triple
    }
  }

  ///////////////////////////////////////////////////

}
