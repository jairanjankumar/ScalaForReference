object IfYouHateYourCoworker extends App {

  // Some scala tricks if you hate your co-workers

  // just variable name
  val isThisAQuestion_? = true
  println(s"isThisAQuestion_? :: ${isThisAQuestion_?}") //isThisAQuestion_? :: true

  // variable name with spaces
  val `Tell me your age !!` = 34
  println(s"Tell me your age !! :: ${`Tell me your age !!`}")  //Tell me your age !! :: 34

  // say `true` as variable and assign false.. epic..
  val `true` = false
  val r1 = if(`true`) false else true
  println(s"r1 :: $r1")  // r1 :: true

  // A function name like below
  def `Add 1 to specified Int`(x:Int) = x + 1
  val r2 = `Add 1 to specified Int`(4)
  println(s"r2 :: $r2") // r2 :: 5

  val `text/html` = 10
  println(s"text/html :: ${`text/html`}") // text/html :: 10

}
