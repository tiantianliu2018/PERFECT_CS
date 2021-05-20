package com.learn.chapter18.viewbounds

/**
 * @author Kelly
 * @create 2021-05-20 11:09
 */
object MyImplicit {
  implicit def person2OrderedPerson(p: Person) = new Ordered[Person] {
    override def compare(that: Person): Int = p.age - that.age
  }

}
