package com.advent.day.trebuchet

import scala.io.*

private def keepDigitalCharOnly(line:String):String = {
  line.replaceAll("\\D", "")
}

private def processCode(code:String):String = {
  code.length match
    case 1 => code ++ code
    case 2 => code
    case _ => StringBuffer(2).append(code.toCharArray.head).append(code.toCharArray.last).toString
}

@main def read():Unit = {
  val sum = Source.fromResource("input.txt").getLines()
    .map(keepDigitalCharOnly)
    .map(processCode)
    .map(_.toInt)
    .sum

  println(sum)
}