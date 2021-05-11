package com.learn.chapter15.service

import com.learn.chapter15.bean.Customer

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.{break, breakable}

/**
 * @author Kelly
 * @create 2021-05-11 10:32
 */
class CustomerService {
  var customerNum: Int = 1
  val customers = ArrayBuffer(new Customer(1, "tom", '男', 10, "110", "tom@sohu.com"))


  /**
   * 添加客户信息
   * @return
   */
  def add(customer: Customer): Boolean = {
    customerNum += 1
    customer.id = customerNum
    customers.append(customer)  // 添加到列表中
    true
  }

  /**
   * 所有客户信息列表
   * @return
   */
  def list(): ArrayBuffer[Customer] = {
    this.customers
  }

  /**
   * 根据输入的 id 找到某个客户在列表中的位置
   * @param id
   * @return
   */
  def findIndexById(id: Int) = {
    var index = -1
    // 遍历 customers
    breakable {
      for (i <- 0 until(customers.length)) {
        if (customers(i).id == id) {
          index = i
          break()
        }
      }
    }
    index
  }

  /**
   * 根据输入的 id 删除客户
   * @param id
   * @return
   */
  def del(id: Int): Boolean = {
    val idx = findIndexById(id)
    if (idx != -1) {
      customers.remove(idx)
      true
    } else false
  }
}
