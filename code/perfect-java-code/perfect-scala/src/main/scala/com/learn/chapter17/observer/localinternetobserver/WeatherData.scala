package com.learn.chapter17.observer.localinternetobserver

/**
 * @author Kelly
 * @create 2021-05-14 10:26
 */
class WeatherData {
  private var temperature: Float = _  // 温度
  private var pressure: Float = _     // 气压
  private var humidity: Float = _   // 湿度

  private var currentConditions: CurrentConditions = _

  private var qqCurrentConditions: CurrentConditions = _

  def this(currentConditions: CurrentConditions) {
    this
    this.currentConditions = currentConditions
    this.qqCurrentConditions = currentConditions
  }

  def getTemperature(): Float = {
    this.temperature
  }

  def getPressure(): Float = {
    this.pressure
  }

  def getHumidity(): Float = {
    this.humidity
  }

  def dataChange() = {
    currentConditions.update(getTemperature(), getPressure(), getHumidity())
    qqCurrentConditions.update(getTemperature(), getPressure(), getHumidity())
  }

  def setData(temperature: Float, pressure: Float, humidity: Float): Unit = {
    this.temperature = temperature
    this.pressure = pressure
    this.humidity = humidity

    // 更改公告板上的天气数据
    dataChange()
  }





}
