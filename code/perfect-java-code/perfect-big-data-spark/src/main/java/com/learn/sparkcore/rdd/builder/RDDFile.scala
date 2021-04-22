package com.learn.sparkcore.rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


/**
 * @author Kelly
 * @create 2021-04-22 16:01
 */
object RDDFile {
  def main(args: Array[String]): Unit = {
    // TODO 准备环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)

    // TODO 从文件中创建 RDD
    // textFile 以行为单位读取数据，读取的数据都是字符串
    // wholeTextFiles 以文件为单位读取数据，读取的结果表示为元组
    // 元组的第一个元素表示文件路径，第二个元素表示文件内容
    val rdd: RDD[String] = sc.textFile("perfect-big-data-spark/src/main/resources/files/words.txt")

    val rdd2 = sc.wholeTextFiles("perfect-big-data-spark/src/main/resources/files")

    rdd.collect().foreach(println)
    rdd2.collect().foreach(println)

    // TODO 关闭环境
    sc.stop()
  }

}
