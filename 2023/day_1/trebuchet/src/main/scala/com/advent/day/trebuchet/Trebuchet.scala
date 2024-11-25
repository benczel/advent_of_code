package com.advent.day.trebuchet

import scala.io._

def keepDigitalCharOnly(line:String):String = {
  line.replaceAll("\\D", "")
}

def processCode(code:String):String = {
  code.length match
    case 1 => code ++ code
    case 2 => code
    case _ => code.toCharArray.head.toString ++ code.toCharArray.last.toString
}

@main def read():Unit = {
  println(Source.fromResource("input.txt").getLines()
    .map(keepDigitalCharOnly)
    .map(processCode)
    .map(_.toInt)
    .sum)
}