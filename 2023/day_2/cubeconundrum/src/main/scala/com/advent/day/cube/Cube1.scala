package com.advent.day.cube

import com.advent.day.cube.model.{Blue, Cube, Game, Green, Red, Set}

object Cube1 extends CubeConundrum {
  
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
}