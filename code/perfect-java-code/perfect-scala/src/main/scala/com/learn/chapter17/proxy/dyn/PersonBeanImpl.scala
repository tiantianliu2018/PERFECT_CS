package com.learn.chapter17.proxy.dyn

/**
 * @author Kelly
 * @create 2021-05-14 16:15
 */
class PersonBeanImpl extends PersonBean {
  var name = ""
  var gender = ""
  var interests = ""

  var score: Int = _ // 评分值

  override def setName(name: String): Unit = {
    this.name = name
  }

  override def setGender(gender: String): Unit = {
    this.gender = gender
  }

  // 自己可以调用
  // 其它用户不能调用
  override def setInterests(interests: String): Unit = {
    this.interests = interests
  }

  // 自己不能调用
  // 其它用户可以调
  override def setScore(score: Int): Unit = {
    this.score = score
  }

  override def getName(): String = name

  override def getGender(): String = gender

  override def getInterests(): String = interests

  override def getScore(): Int = score


}
