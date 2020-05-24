package info.kfgodel.processink.demos.conway.gener

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.api.ext.x
import java.util.stream.Collectors

/**
 * This type represents the rule processor of the Conway game that applies to the cells of the world
 * in order to change their state.<br>
 *
 * Created by kfgodel on 15/11/15.
 */
class NextGenerationCalculator(private val livingCells: Set<Vector2D>) {
  private val deadNeighbors: MutableSet<Vector2D> = HashSet()
  private val RELATIVE_NEIGHBORS: Array<Vector2D> = arrayOf(
    -1 x -1, 0 x -1, 1 x -1,
    -1 x 0,/* me */ 1 x 0,
    -1 x 1, 0 x 1, 1 x 1
  )

  fun calculate(): Set<Vector2D> {
    val nextLivingCells: MutableSet<Vector2D> = HashSet()
    nextLivingCells.addAll(calculateSurvivors())
    nextLivingCells.addAll(calculateEmergents())
    return nextLivingCells
  }

  private fun calculateSurvivors(): Set<Vector2D> {
    return livingCells.stream()
      .filter { livingCell -> canSurvive(livingCell) }
      .collect(Collectors.toSet())
  }

  private fun canSurvive(livingCell: Vector2D): Boolean {
    var livingNeighbors = 0
    val neighbors = calculateNeighborsOf(livingCell)
    for (neighbor in neighbors) {
      if (livingCells.contains(neighbor)) {
        livingNeighbors++
      } else {
        // Used to verify if it becomes alive later
        deadNeighbors.add(neighbor)
      }
    }
    return livingNeighbors == 2 || livingNeighbors == 3
  }

  private fun calculateEmergents(): Set<Vector2D> {
    return deadNeighbors.stream()
      .filter { deadCell -> canRevive(deadCell) }
      .collect(Collectors.toSet())
  }

  private fun calculateNeighborsOf(livingCell: Vector2D): List<Vector2D> {
    return RELATIVE_NEIGHBORS
      .map(livingCell::plus)
  }

  private fun canRevive(deadCell: Vector2D): Boolean {
    val neighbors = calculateNeighborsOf(deadCell)
    var livingNeighbors = 0
    for (neighbor in neighbors) {
      if (livingCells.contains(neighbor)) {
        livingNeighbors++
      }
    }
    return livingNeighbors == 3
  }

}