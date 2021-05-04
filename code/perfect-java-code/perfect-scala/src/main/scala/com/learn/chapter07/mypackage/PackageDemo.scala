package com.learn.chapter07 {
  // com.learn.chapter07 包下创建 user 类
  class User {

  }

  // com.learn.chapter07 包下创建 scala 包
//  package scala {
//    class User {
//
//    }
//  }

  // com.learn.chapter07 包下创建 mypackage 包
  package mypackage {
    class Person {
      val name = "Nick"

      def play(message: String): Unit = {
        println(this.name + " " + message)
      }

    }

    class User {

    }

    object Test {
      def main(args: Array[String]): Unit = {
        println("ok")
        val user = new User
        println("user = " + user)

//        val user2 = com.learn.chapter07.User()
//        println("user2 = " + user2)

      }
    }
  }
}


