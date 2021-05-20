package com.learn.chapter18.upperbounds

/**
 * @author Kelly
 * @create 2021-05-20 10:09
 */
object LowerBoundsDemo {
  def main(args: Array[String]): Unit = {
    biophony(Seq(new Bird, new Bird))
    println("=========================")
    biophony(Seq(new Bird, new Animal))
    println("=========================")
    biophony(Seq(new Animal, new Animal))
    println("=========================")
    biophony(Seq(new Animal, new Bird))
//    biophony(Seq(new Animal, new Earth))

  }

  def biophony[T <: Animal](things: Seq[T]) = things map(_.sound)

}
class Earth {
  def sound(): Unit = {
    println("hello~")
  }
}

class Animal extends Earth {
  override def sound(): Unit = {
    println("Animal sound~~")
  }
}

class Bird extends Animal {
  override def sound(): Unit = {
    println("Bird sound~~~`")
  }
}


