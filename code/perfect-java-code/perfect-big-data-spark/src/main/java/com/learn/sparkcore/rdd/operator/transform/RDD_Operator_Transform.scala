package com.learn.sparkcore.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Kelly
 * @create 2021-05-23 21:20
 */
object RDD_Operator_Transform {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1, 2, 3, 4), 2)
    // 两个分区【1，2】，【3，4】
//    val mapRDD = rdd.mapPartitions(
//      iter => {
//        println(">>>>>>>>")
//        iter.map(_ * 2)
//      }
//    )
    val mapRDD = rdd.mapPartitions(
      iter => {
        List(iter.max).iterator
      }
)

    mapRDD.collect().foreach(println)

    sc.stop()
  }

}
