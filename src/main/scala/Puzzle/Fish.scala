/*
package Puzzle

import Puzzle.Fish.addRemove

import scala.collection.mutable.ListBuffer

class Fish {

  import Puzzle.Fish._

  def eatAndBeBig(fish: Int, tankFish: ListBuffer[Int]): (Int, ListBuffer[Int]) = {

    val eatableFishes = tankFish.partition(_ < fish)._1

    if (eatableFishes.isEmpty) fish -> tankFish
    else {
      val newFish = eatableFishes.sum + fish
      val newTankFish: ListBuffer[Int] = tankFish.partition(_ < fish)._2
      eatAndBeBig(newFish, newTankFish)
    }
  }

  def getCatalyst(fish: Int): Int = {

    val catalyst = fish - 1
    catalyst
  }

  def doTheCalculate(fish: Int, tankFishes: ListBuffer[Int], addition: ListBuffer[Int], checkPoint: Boolean): addRemove = {


    val newDynamics = eatAndBeBig(fish, tankFishes)
    val newFish = newDynamics._1
    val remainingFishes = newDynamics._2

    if (remainingFishes.nonEmpty) {
      val catalyst = getCatalyst(newFish)
      addition += catalyst

      val addFish = newFish + catalyst
      val afterCatalyst = eatAndBeBig(addFish, remainingFishes)
      val afterCatalystNewFish = afterCatalyst._1
      val afterCatalystRemainingFishes = afterCatalyst._2

      val checkP = if (remainingFishes.size == afterCatalystRemainingFishes.size) {
        true
      }
      else
        false

      val addRemove = if (afterCatalystRemainingFishes.isEmpty)
        (addition, afterCatalystRemainingFishes)
      else
        doTheCalculate(afterCatalystNewFish, afterCatalystRemainingFishes, addition, checkP)

      println(s"$checkP   $checkPoint")
      println(s"${addRemove._1} > $remainingFishes")
      if (addRemove._1.size > remainingFishes.size && (checkPoint || checkP))
        (addition -= catalyst, remainingFishes)
      else
          addRemove
    }
    else
      (addition, remainingFishes)
  }
}

object Fish extends App {

  val fish = 12
  val tankFishes: ListBuffer[Int] = ListBuffer(1, 2, 5, 19, 20, 40, 100, 101, 102, 10000, 10000, 10000, 10000)

  type addRemove = (ListBuffer[Int], ListBuffer[Int])

  val f = new Fish
  val addRemoveList = f.doTheCalculate(fish, tankFishes, ListBuffer[Int](),false)

  println(s"${addRemoveList._1}          ${addRemoveList._2}")

}
*/
