package com.learn.sparkcore.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Kelly
 * @create 2021-04-27 16:57
 */
object RDDOperatorTransform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("transform")
    val sc = new SparkContext(sparkConf)

    // TODO -- 算子 map
    val rdd = sc.makeRDD(List(1, 2, 3, 4))
    // 1，2，3，4 => 2,4,6,8
//    val mapRdd = rdd.map(mapFunc)
//    val mapRDD = rdd.map((num: Int) => {num * 2})
//    val mapRDD = rdd.map((num: Int) => num * 2)
//    val mapRDD = rdd.map((num) => num * 2)
//    val mapRDD = rdd.map(num => num * 2)
    val mapRDD = rdd.map(_ * 2)
    mapRDD.collect().foreach(println)

    sc.stop()
  }

  // 转换函数
  def mapFunc(num:Int): Int = {
    num * 2
  }

}
