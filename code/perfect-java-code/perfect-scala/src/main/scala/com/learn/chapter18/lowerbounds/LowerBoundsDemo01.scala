package com.learn.chapter18.lowerbounds

/**
 * @author Kelly
 * @create 2021-05-20 10:46
 */
object LowerBoundsDemo01 {
  def main(args: Array[String]): Unit = {
    println("ok!")
    // 满足下界的约束
    biophony(Seq(new Earth, new Earth)).map(_.sound())
    println("---------------------------")
    biophony(Seq(new Animal, new Animal)).map(_.sound())
    println("---------------------------")
    biophony(Seq(new Earth, new Animal)).map(_.sound())
    println("---------------------------")
    biophony(Seq(new Animal, new Earth)).map(_.sound())
    println("---------------------------")
    biophony(Seq(new Bird, new Bird)).map(_.sound())

//    biophony(Seq(new Animal, new Animal).map(_.sound())


  }

  // 下界
  def biophony[T >: Animal](things: Seq[T]) = things
}
class Earth {
  def sound() = println("sound ~ ")
}

class Animal extends Earth {
  override def sound(): Unit = println("Animal sound ~~ ")
}

class Bird extends Animal {
  override def sound(): Unit = println("Bird sound ~~~ ")
}
