package com.learn.chapter18.contextbounds

/**
 * @author Kelly
 * @create 2021-05-20 11:33
 */
object ContextBoundsDemo {
  implicit val personComparator = new Ordering[Person] {
    override def compare(p1: Person, p2: Person): Int = p1.age - p2.age
  }
  def main(args: Array[String]): Unit = {

    val p1 = new Person("mary", 30)
    val p2 = new Person("smith", 35)

    val res = new ComparaCommon(p1, p2).greater
    println("res = " + res)

    val compareCommon2 = new CompareCommon2(p1, p2)
    println("greater res2 = " + compareCommon2.greater)
    println("lower res2 = " + compareCommon2.lower)

    println("==================")
    println("personComparator hashcode=" + personComparator.hashCode())
    val res3 = new CompareCommon3(p1, p2).greater
    println("res3 = " + res3) // "smith", 35



  }

}

class Person(val name: String, val age: Int) {
  override def toString: String = this.name + "\t" + this.age
}

/**
 * [T: Ordering] 泛型
 * obj1: T, obj2: T 接受 T 类型的对象
 * implicit comparetor: Ordering[T] 是一个隐式参数
 */
class ComparaCommon[T: Ordering](o1: T, o2: T)(implicit comparator: Ordering[T]) {
  def greater = if (comparator.compare(o1, o2) > 0) o1 else o2

}

/**
 * 将隐式参数放到方法内
 */
class CompareCommon2[T: Ordering](o1: T, o2: T) {
  def greater = {
    def f1(implicit cmptor: Ordering[T]) = cmptor.compare(o1, o2)
    if (f1 > 0) o1 else o2
  }

  def lower = {
    def f1(implicit cmptor: Ordering[T]) = cmptor.compare(o1, o2)
    if (f1 > 0) o2 else o1
  }
}

/**
 * 使用 implicitly 语法糖，最简单
 */
class CompareCommon3[T: Ordering](o1: T, o2:T) {
  def greater = {
    // 发生隐式转换，获取到隐式值 comparator
    // 底层仍然使用编译器来完成绑定(赋值的)工作
    val comparator = implicitly[Ordering[T]]

    println("comparator hashcode=" + comparator.hashCode())
    if (comparator.compare(o1, o2) > 0) o1 else o2
  }
}

