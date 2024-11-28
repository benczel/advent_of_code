package com.advent.day.cube

import com.advent.day.cube.model.{Blue, Cube, Game, Green, Red, Set}

class Parser {

  def parseLine(line: String): Game = {
    val parsed = line.split(":")
    val id = parseGame(parsed.head.trim)
    val sets = parseSets(parsed.last.trim)

    Game(id, sets)
  }

  private def parseGame(game: String): Int = game.split(" ").last.toInt

  private def parseSets(sets: String): Array[Set] =
    sets.split(";").map(set => Set(parseCubes(set.trim)))

  private def parseCubes(cubes: String): Array[Cube] =
    cubes.split(",").map(e => parseCube(e.trim))

  private def parseCube(cube: String): Cube = {
    cube.split(" ") match {
      case Array(cnt: String, colour: String) if colour.equals("red") => Red(cnt.trim.toInt)
      case Array(cnt: String, colour: String) if colour.equals("green") => Green(cnt.trim.toInt)
      case Array(cnt: String, colour: String) if colour.equals("blue") => Blue(cnt.trim.toInt)
    }
  }
}

object Parser {
  def apply: Parser = new Parser()
}