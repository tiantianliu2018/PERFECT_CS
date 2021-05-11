package com.learn.chapter15.view

import com.learn.chapter15.bean.Customer
import com.learn.chapter15.service.CustomerService

import scala.io.StdIn
import scala.util.control.Breaks.{break, breakable}

/**
 * @author Kelly
 * @create 2021-05-11 10:23
 */
class CustomerView {
  // 控制是否退出循环
  var loop = true

  // 接收用户输入的选项
  var key = ' '

  val customerService = new CustomerService

  def mainMenu(): Unit ={
    do {
      println("-----------------客户信息管理软件-----------------")
      println("                 1 添 加 客 户")
      println("                 2 修 改 客 户")
      println("                 3 删 除 客 户")
      println("                 4 客 户 列 表")
      println("                 5 退 出")
      println("                 请选择(1-5)：")

      key = StdIn.readChar()

      key match {
        case '1' => add
        case '2' => println("修 改 客 户")
        case '3' => del
        case '4' => list
        case '5' => ackQuit
      }
    } while (loop)

    println("你退出了软件系统...")
  }

  /**
   * 显示所有客户列表界面
   */
  def list(): Unit = {
    println()
    println("---------------------------客户列表---------------------------")
    println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱" )

    val customers = customerService.list()
    // for 遍历
    for (customer <- customers) {
      println(customer)
    }

    println("-------------------------客户列表完成-------------------------")
    println()
  }

  /**
   * 添加客户信息界面
   */
  def add(): Unit = {
    println()
    println("---------------------添加客户---------------------")
    println("姓名：" )
    val name = StdIn.readLine()
    println("性别：" )
    val gender = StdIn.readChar()
    println("年龄：" )
    val age = StdIn.readShort()
    println("电话：" )
    val tel = StdIn.readLine()
    println("邮箱：" )
    val email = StdIn.readLine()

    // 构建对象
    val customer = new Customer(name, gender, age, tel, email)
    customerService.add(customer)
    println("---------------------添加完成---------------------")
    println()
  }

  /**
   * 根据 id 删除客户
   */
  def del: Unit = {
    println("---------------------删除客户---------------------")
    println("请选择待删除客户编号(-1 退出)：")
    val id = StdIn.readInt()
    if (id == -1) {
      println("---------------------删除没有完成---------------------")
      return
    }
    println("确认是否删除(Y/N)：")
    var choice = ' '
    breakable {
      do {
        choice = StdIn.readChar().toLower
        if (choice == 'y' || choice == 'n') break()
        println("确认是否删除(Y/N)：")
      } while (true)
    }

    if (choice == 'y') {
      if (customerService.del(id)) {
        println("---------------------删除成功---------------------")
        return
      }
    }
    println("---------------------删除没有完成---------------------")
    println()
  }

  /**
   * 用户确认是否退出
   */
  def ackQuit: Unit = {
    println("确认是否退出(Y/N)：")
    var choice = ' '
    breakable {
      do {
        choice = StdIn.readChar().toLower
        if (choice == 'y' || choice == 'n') break()
        println("确认是否退出(Y/N)：")
      } while(true)
    }
    if (choice == 'y') {
      println("退出成功")
      this.loop = false
      return
    }
    println("退出失败, 系统继续执行。。。")
  }
}
