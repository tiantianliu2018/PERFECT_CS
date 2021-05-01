package com.learn.sparkcore.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Kelly
 * @create 2021-04-27 17:15
 */
object RDDOperatorTransformPar {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("transform")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1,2,3,4), 2)

    val mapRDD = rdd.map(
      num => {
        println("======= " + num)
        num
      }
    )

    val mapRDD2 = mapRDD.map(
      num => {
        println("####### " + num)
        num
      }
    )

    mapRDD2.collect()

    sc.stop()
  }
}
