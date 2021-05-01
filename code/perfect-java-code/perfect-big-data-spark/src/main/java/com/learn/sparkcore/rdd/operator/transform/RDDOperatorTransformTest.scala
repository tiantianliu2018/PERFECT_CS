package com.learn.sparkcore.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Kelly
 * @create 2021-04-27 17:07
 */
object RDDOperatorTransformTest {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("transform_test")
    val sc = new SparkContext(sparkConf)
    val rdd = sc.textFile("perfect-big-data-spark/src/main/resources/files/apache.log")

    // 长字符串 => 短字符串
    val mapRDD = rdd.map(
      line => {
        val fields = line.split(" ")
        fields(6)
      }
    )
    mapRDD.collect().foreach(println)
    sc.stop()
  }

}
