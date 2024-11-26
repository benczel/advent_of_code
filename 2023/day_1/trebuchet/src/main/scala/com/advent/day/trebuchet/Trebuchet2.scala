package com.advent.day.trebuchet


object Trebuchet2 {

  private val numberMapping = Map(
    "one" -> 1,
    "two" -> 2,
    "three" -> 3,
    "four" -> 4,
    "five" -> 5,
    "six" -> 6,
    "seven" -> 7,
    "eight" -> 8,
    "nine" -> 9,
  )

  def searchNumbers(line: String): Array[Int] = {
    line.tails.flatMap(tail =>
      tail.headOption match {
        case Some(c) if c.isDigit => Some(c.toString.toInt)
        case _ => numberMapping.find((digitString, _) => tail.startsWith(digitString)).map(_._2)
      }
    ).toArray
  }

  def processCodes(codes: Array[Int]): Int = {
    10 * codes.head + codes.last
  }
}