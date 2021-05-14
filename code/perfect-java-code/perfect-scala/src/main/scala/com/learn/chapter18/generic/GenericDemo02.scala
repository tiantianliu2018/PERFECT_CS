package com.learn.chapter18.generic
import com.learn.chapter18.generic.SeasonEnum

/**
 * @author Kelly
 * @create 2021-05-14 16:59
 */
object GenericDemo02 {
  def main(args: Array[String]): Unit = {
    val class01 = new EnglishClass[SeasonEnum.SeasonEnum, String, String](SeasonEnum.spring, "0705班","高级班")
    println("class01 " + class01.classSeason + " " + class01.className + " " + class01.classType)

    val class02 = new EnglishClass[SeasonEnum.SeasonEnum, String, String](SeasonEnum.summer, "0802班", "中级班")
    println("class02 " + class02.classSeason + " " + class02.className + " " + class02.classType)
  }

}

class EnglishClass[A, B, C](val classSeason: A, val className: B, val classType: C)

//季节是枚举类型
object SeasonEnum extends Enumeration {
  type SeasonEnum = Value
  val spring,autumn,summer,winter = Value
}
