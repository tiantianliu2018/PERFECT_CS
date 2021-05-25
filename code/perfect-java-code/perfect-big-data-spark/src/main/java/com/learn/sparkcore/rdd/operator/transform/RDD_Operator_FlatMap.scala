package com.learn.sparkcore.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Kelly
 * @create 2021-05-24 12:57
 */
object RDD_Operator_FlatMap {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("flatmap")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(List(1, 2), List(3, 4)), 1)

    val flatMapRDD = rdd.flatMap(
      list => list
    )

    flatMapRDD.collect().foreach(println)

    sc.stop()
  }

}
