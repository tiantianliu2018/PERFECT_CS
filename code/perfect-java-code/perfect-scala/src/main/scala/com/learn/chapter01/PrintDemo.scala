package com.learn.chapter01

/**
 * @author Kelly
 * @create 2021-04-19 11:21
 */
object PrintDemo {
  def main(args: Array[String]): Unit = {
    var str1:String = "Hello"
    var str2:String = " world!"
    println(str1 + str2)



    var name:String = "Tom"
    var age:Int = 10
    var salary:Float = 10.67F
    var height:Double = 185.6
    // 格式化输出
    printf("name:%s age=%d salary=%.2f height=%.2f",name,age,salary,height)
    println()
    // 使用 $ 输出内容
    println(s"个人信息如下：\n名字: $name \t年龄: $age \t薪水: $salary")
    println(s"个人信息如下：\n名字: ${name} \t年龄: ${age} \t薪水: ${salary * 10}")
  }

}
