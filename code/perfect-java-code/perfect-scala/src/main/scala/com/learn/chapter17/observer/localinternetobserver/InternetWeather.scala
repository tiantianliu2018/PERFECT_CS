package com.learn.chapter17.observer.localinternetobserver

/**
 * @author Kelly
 * @create 2021-05-14 10:37
 */
object InternetWeather {
  def main(args: Array[String]): Unit = {
    val currentConditions = new CurrentConditions
    val weatherData = new WeatherData(currentConditions)
    weatherData.setData(30, 150, 40)
  }

}
