package com.learn.chapter08

import com.learn.chapter08.Child.joinGame

/**
 * @author Kelly
 * @create 2021-05-04 11:05
 */
object ChildJoinGame {
  def main(args: Array[String]): Unit = {
    val child1 = new Child("小明")
    val child2 = new Child("小红")
    val child3 = new Child("小兰")

    Child.joinGame(child1)
    Child.joinGame(child2)
    Child.joinGame(child3)

    Child.showNum()
  }

}

// 伴生类
class Child(cName: String) {
  var name = cName
}

object Child {
  var totalChildrenNum = 0

  def joinGame(child: Child): Unit = {
    printf("[%s] 加入了游戏\n", child.name)
    totalChildrenNum += 1
  }

  def showNum(): Unit = {
    printf("当前有 %d 个小孩玩游戏\n", totalChildrenNum)
  }
}
