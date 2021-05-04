package com.learn.chapter07.myabstract

/**
 * @author Kelly
 * @create 2021-05-02 10:55
 */
object BankDemo {
  def main(args: Array[String]): Unit = {
    val account = new Account("123456", 1000000.00, "abc")
    account.query("abc")
    account.withDraw("abc", 100)
    account.query("abc")

  }

}
class Account(inAccount: String, inBalance: Double, inPwd: String) {
  // 账户属性
  val accountId = inAccount
  var balance = inBalance
  var password = inPwd

  // 查询方法
  def query(pwd: String): Unit = {
    if (!this.password.equals(pwd)) {
      println("查询密码错误")
      return
    }
    printf("账号为 %s 当前余额为 %.2f", this.accountId, this.balance)
    println()
  }

  // 取款
  def withDraw(pwd: String, money: Double): Any ={
    if (!this.password.equals(pwd)) {
      println("查询密码错误")
      return
    }
    // 判断取款金额
    if (money > this.balance) {
      println("余额不足")
      return
    }
    this.balance -= money
    money
  }
}
