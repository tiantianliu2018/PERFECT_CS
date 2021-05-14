package com.learn.chapter17.proxy.dyn

import java.lang.reflect.{InvocationHandler, Method}

/**
 * @author Kelly
 * @create 2021-05-14 16:23
 */
// 其它用户调用
class NonOwnerInvocationHandler extends InvocationHandler{
  var person: PersonBean = _

  def this(person: PersonBean) = {
    this
    this.person = person
  }

  @throws(classOf[Throwable])
  override def invoke(proxy: Any, method: Method, args: Array[AnyRef]): AnyRef = {
    if (method.getName().startsWith("get")) {
      // get 方法，直接调用
      return method.invoke(person)
    } else if (method.getName.equals("setScore")) {
      // 其它用户可以调用 setHotOrNotRating,进行评分
      return method.invoke(person, Integer.valueOf(args(0).toString))
    } else if (method.getName.startsWith("set")) {
      // 其它用户不能调用 set 方法
      return new IllegalAccessException
    }
    null
  }
}
