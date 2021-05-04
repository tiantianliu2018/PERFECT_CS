package com.learn.chapter07 {

  package object scala {
    var name = "King"

    def sayHi(): Unit ={
      println("package object say hi~")
    }
  }
  package scala {
    class Person {
      val name = "Nick"

      def play(message: String): Unit = {
        println(this.name + message)
      }
    }

    class User {
      def testUser(): Unit ={
        println("name = " + name)

      }
    }

    object Test100 {
      def main(args: Array[String]): Unit = {
        println("name = " + name)
        name = "yy"
        sayHi()
      }
    }

  }
}
