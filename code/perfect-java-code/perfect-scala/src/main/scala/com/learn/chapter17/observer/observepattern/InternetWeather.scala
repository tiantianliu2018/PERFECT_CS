package com.learn.chapter17.observer.observepattern

/**
 * @author Kelly
 * @create 2021-05-14 11:07
 */
object InternetWeather {
  def main(args: Array[String]): Unit = {
    val currentConditions = new CurrentConditions
    val weatherDataSt = new WeatherDataSt

    // 将观察者 currentConditions 注册
    weatherDataSt.registerObserver(currentConditions)

    val sinaCurrentConditions = new SinaCurrentConditions
    weatherDataSt.registerObserver(sinaCurrentConditions)

    // 更新天气情况
    weatherDataSt.setData(27, 150, 40)
  }

}
