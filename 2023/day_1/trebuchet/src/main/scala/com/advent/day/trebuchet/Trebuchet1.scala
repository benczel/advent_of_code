package com.advent.day.trebuchet

object Trebuchet1 {

  def keepDigitalCharOnly(line: String): Array[Char] = {
    line.toCharArray.filter(_.isDigit)
  }

  def processCodes(codes: Array[Int]): Int = {
    10 * codes.head + codes.last
  }
}