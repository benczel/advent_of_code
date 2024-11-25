package com.advent.day.trebuchet

import scala.io.Source

@main def main(): Unit = {

  val part1 =
    Source.fromResource("input.txt")
      .getLines()
      .map(Trebuchet1.keepDigitalCharOnly)
      .map(Trebuchet1.processCode)
      .map(_.toInt)
      .sum

  println(part1)
}