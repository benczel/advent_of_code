package com.advent.day.cube

import com.advent.day.cube.model.{Blue, Cube, Game, Green, Red, Set}

object Cube1 {

  private val redCubes = 12
  private val greenCubes = 13
  private val blueCubes = 14

  def parseLine(line: String): Game = {
    val parsed = line.split(":")
    val id = parseGame(parsed.head.trim)
    val sets = parseSets(parsed.last.trim)

    Game(id, sets)
  }

  def isPossible(sets: Array[Set]): Boolean = {
    !sets.map(
      e => IsPossibleSet(e.cubes)
    )
      .contains(false)
  }

  private def IsPossibleSet(set: Array[Cube]): Boolean = {
    !set.map {
      case Red(cnt) => cnt <= redCubes
      case Blue(cnt) => cnt <= blueCubes
      case Green(cnt) => cnt <= greenCubes
    }.contains(false)
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