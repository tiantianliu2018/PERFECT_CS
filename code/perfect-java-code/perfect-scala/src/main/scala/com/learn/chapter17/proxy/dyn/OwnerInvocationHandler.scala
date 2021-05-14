package com.learn.chapter17.proxy.dyn

import java.lang.reflect.{InvocationHandler, Method}

/**
 * @author Kelly
 * @create 2021-05-14 16:18
 */
// 自己调用的代理
class OwnerInvocationHandler extends InvocationHandler {
  var person: PersonBean = _
  def this(person: PersonBean) {
    this
    this.person = person
  }

  @throws(classOf[Throwable])
  override def invoke(proxy: Any, method: Method, args: Array[AnyRef]): AnyRef = {
    if (method.getName().startsWith("get")) {
      // get 方法
      return method.invoke(person)
    } else if (method.getName.equals("setScore")) {
      // 自己不能调用, 不能给自己评分
      return new IllegalAccessException()
    } else if (method.getName.startsWith("set")) {
      //如果是 set 方法就直接调用
      return method.invoke(person, args(0).toString())
    }
    null
  }
}
