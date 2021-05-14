package com.learn.chapter17.proxy.dyn

import java.lang.reflect.Proxy

/**
 * @author Kelly
 * @create 2021-05-14 16:27
 */
class MatchService {

  def getPersonInfo(name: String, gender: String, interests: String): PersonBean = {
    val person = new PersonBeanImpl()
    person.setName(name)
    person.setGender(gender)
    person.setInterests(interests)
    person
  }

  def getOwnerProxy(person: PersonBean): PersonBean = {
    Proxy.newProxyInstance(person.getClass.getClassLoader,
      person.getClass.getInterfaces,
      new OwnerInvocationHandler(person)).asInstanceOf[PersonBean]
  }

  def getNonOwnerProxy(person: PersonBean): PersonBean = {
    Proxy.newProxyInstance(person.getClass.getClassLoader,
      person.getClass.getInterfaces,
      new NonOwnerInvocationHandler(person)).asInstanceOf[PersonBean]
  }

  val tom = getPersonInfo("tom", "male", "like programming")

  val ownerProxy = getOwnerProxy(tom)
  println("Name is " + ownerProxy.getName()) // tom
  println("Interests is " + ownerProxy.getInterests()) // 爱好编程

  ownerProxy.setInterests("刷微博")
  println("Interests is " + ownerProxy.getInterests())

  // 给自己设置评分
  ownerProxy.setScore(100)
  println("Score is " + ownerProxy.getScore())  // 不通过，仍然为 0

  println("**** 测试 NonOwnerInvocationHandler **********")

  val marry = getPersonInfo("Marry", "女", "爱好购物...")
  // 返回一个其它用户调用的代理对象
  val nonOwnerProxy = getNonOwnerProxy(marry)
  println("Name is " + nonOwnerProxy.getName()) // mary
  println("Interests is " + nonOwnerProxy.getInterests()) // 爱好购物...

  //其它人不能修改兴趣，通过代理进行控制不能调用setInterests
  nonOwnerProxy.setInterests("爱好小猫咪~~") // 失败，在动态代理控制
  println("Interests is " + nonOwnerProxy.getInterests()) //爱好购物...

  nonOwnerProxy.setScore(68) //其它人可以评分ok
  println("score is " + nonOwnerProxy.getScore()) // 68


}
