package com.learn.sparkcore.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Kelly
 * @create 2021-05-23 22:04
 */
object RDD_Operator_MapPartitionsWithIndex {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("mapPartitionsWithIndex")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1, 2, 3, 4), 2)
    val mapRDD = rdd.mapPartitionsWithIndex(
//      (index, iter) => {
//        if (index == 1) {
//          iter
//        } else {
//          Nil.iterator
//        }
//      }
      (index, iter) => {
        iter.map(
          num => {
            (index, num)
          }
        )
      }
    )
    mapRDD.collect().foreach(println)

    sc.stop()
  }

}
