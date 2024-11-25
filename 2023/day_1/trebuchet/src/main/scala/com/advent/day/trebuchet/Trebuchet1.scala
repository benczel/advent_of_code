package com.advent.day.trebuchet

object Trebuchet1 {

  def keepDigitalCharOnly(line: String): String = {
    line.replaceAll("\\D", "")
  }

  def processCode(code: String): String = {
    code.length match
      case 1 => code ++ code
      case 2 => code
      case _ => StringBuffer(2).append(code.toCharArray.head).append(code.toCharArray.last).toString
  }
}