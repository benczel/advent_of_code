package com.advent.day.trebuchet

import scala.io.Source

@main def main(): Unit = {

  val part1 = Source.fromResource("input.txt")
    .getLines()
    .map(Trebuchet1.keepDigitalCharOnly)
    .map(_.map(_.toString.toInt))
    .map(Trebuchet1.processCodes)
    .sum

  println(part1)

  val part2 = Source.fromResource("input.txt")
    .getLines()
    .map(Trebuchet2.searchNumbers)
    .map(Trebuchet2.processCodes)
    .sum

  println(part2)
}
