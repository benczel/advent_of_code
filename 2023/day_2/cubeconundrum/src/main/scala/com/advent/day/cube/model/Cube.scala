package com.advent.day.cube.model

sealed trait Cube
case class Red(count:Int) extends Cube
case class Blue(count:Int) extends Cube
case class Green(count:Int) extends Cube
