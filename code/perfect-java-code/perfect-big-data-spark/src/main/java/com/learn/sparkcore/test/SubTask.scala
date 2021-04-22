package com.learn.sparkcore.test

/**
 * @author Kelly
 * @create 2021-04-20 15:10
 */
class SubTask extends Serializable {
  var data : List[Int] = _
  var logic : (Int) => Int = _

  def calculate() = {
    data.map(logic)
  }


}
