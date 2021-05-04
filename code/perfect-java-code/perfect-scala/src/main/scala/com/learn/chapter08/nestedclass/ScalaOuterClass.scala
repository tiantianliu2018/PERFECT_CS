package com.learn.chapter08.nestedclass

/**
 * @author Kelly
 * @create 2021-05-04 12:42
 */
object ScalaInnerClassDemo {
  def main(args: Array[String]): Unit = {
    val outer1 = new ScalaOuterClass
    val outer2 = new ScalaOuterClass

    val inner1 = new outer1.ScalaInnerClass
    val inner2 = new outer2.ScalaInnerClass

    inner1.info()

    val clazz = new ScalaOuterClass.ScalaStaticInnerClass

  }
}
class ScalaOuterClass {

  myOuter => // 外部类的别名

  var name = "tom"
  var age = 10

  // 成员内部类
  class ScalaInnerClass {
    // 访问方式  外部类名.this.属性名
    def info(): Unit = {
      println("name = " + ScalaOuterClass.this.name + ", age = " + ScalaOuterClass.this.age)
      println("name~= " + myOuter.name + ", age~= " + myOuter.age)
    }

    // 类型投影
    def test(ic: ScalaOuterClass#ScalaInnerClass): Unit = {
      System.out.println("使用了类型投影" + ic)
    }
  }

}

// 外部类的伴生对象
object ScalaOuterClass {
  // 静态内部类
  class ScalaStaticInnerClass{}
}