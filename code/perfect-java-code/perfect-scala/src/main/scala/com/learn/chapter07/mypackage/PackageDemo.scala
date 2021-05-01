package com.learn.chapter07 {
  package mypackage {
    class Person {
      val name = "Nick"

      def play(message: String): Unit = {
        println(this.name + " " + message)
      }

    }

    object Test {
      def main(args: Array[String]): Unit = {
        println("ok")
      }
    }
  }
}


