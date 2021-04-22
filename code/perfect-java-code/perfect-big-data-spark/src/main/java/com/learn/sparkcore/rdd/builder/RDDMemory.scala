package com.learn.sparkcore.rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Kelly
 * @create 2021-04-22 15:30
 */
object RDDMemory {
  def main(args: Array[String]): Unit = {
    // TODO 准备环境
    // local[*] 当前本机最大核数
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)

    // TODO 创建 RDD
    // 从内存中创建 RDD，将内存中集合的数据当作数据源
    val seq = Seq[Int](1,2,3,4)
//    val rdd: RDD[Int] = sc.parallelize(seq)
    val rdd: RDD[Int] = sc.makeRDD(seq)

    rdd.collect().foreach(println)

    // TODO 关闭环境
    sc.stop()
  }

}
