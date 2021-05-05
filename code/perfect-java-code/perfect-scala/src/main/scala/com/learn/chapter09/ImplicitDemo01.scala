package com.learn.chapter09

/**
 * @author Kelly
 * @create 2021-05-05 10:11
 */
object ImplicitDemo01 {
  def main(args: Array[String]): Unit = {
    // 添加隐式转换函数，增加 mysql 的功能
    implicit def addDelete(mySQL: MySQL): DB = {
      new DB
    }

    val sql = new MySQL
    sql.insert()
    sql.update()
    sql.delete()
  }

}
class MySQL {
  def insert(): Unit = {
    println("insert method")
  }
}

class DB {
  def delete(): Unit = {
    println("delete method")
  }

  def update(): Unit = {
    println("update method")
  }
}

class Dog {}
