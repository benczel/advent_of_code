package com.advent.day.cube


import scala.io.Source

@main def main(): Unit = {

  val part1 = Source.fromResource("input.txt")
    .getLines()
    .map(Parser.parseLine)
    .map(g => (g.id, Cube1.isPossible(g.sets)))
    .filter(_._2)
    .foldLeft(0)((acc, act) => acc + act._1)

  println(part1)


  val part2 = Source.fromResource("input.txt")
    .getLines()
    .map(Parser.parseLine)
    .map(g => Cube2.explode(g.sets))
    .map(Cube2.maxByColour)
    .map(Cube2.multiply)
    .sum

  println(part2)

}