package com.learn.chapter17.proxy.dyn

/**
 * @author Kelly
 * @create 2021-05-14 16:13
 */

// Subject(是一个 trait/Java 中 interface)
trait PersonBean {
  def setName(name: String)

  def setGender(gender: String)

  def setInterests(interests: String)

  def setScore(score:Int)

  def getName(): String

  def getGender(): String

  def getInterests(): String

  def getScore(): Int



}
