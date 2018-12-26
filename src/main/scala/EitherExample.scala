object EitherExample extends App {

  val in = 10

  val result: Either[Int, String] = if (in < 20)
    Right("Less than 20")
  else
    Left(in)

  println( result match {
    case Right(x) => "Right Side :: " + x
    case Left(x) => "Left " + x
  })

}
