package com.advent.day.cube

import com.advent.day.cube.model.{Cube, Set, Red, Green, Blue}

object Cube2 extends CubeConundrum {

  def explode(sets: Array[Set]): Array[(String, Int)] = {
    sets.flatMap(_.cubes).map {
      case Red(count) => ("red", count)
      case Green(count) => ("green", count)
      case Blue(count) => ("blue", count)
    }
  }
  
  def maxByColour(elements: Array[(String, Int)]): Array[Int] = {
    elements.groupBy(_._1)
      .view
      .mapValues(_.maxBy(_._2))
      .map(_._2._2)
      .toArray
  }

  def multiply(cubes: Array[Int]): Int = {
    cubes.foldLeft(1) (
      (acc, act) => acc * act
    )
  }
}