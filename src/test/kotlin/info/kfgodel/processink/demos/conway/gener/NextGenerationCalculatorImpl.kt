package info.kfgodel.processink.demos.conway.gener

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.api.ext.x
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.HashSet

/**
 * This type implements the rules of the conways game
 * Created by tenpines on 15/11/15.
 */
class NextGenerationCalculatorImpl : NextGenerationCalculator {
  private var livingCells: Set<Vector2D>? = null
  private var deadNeighbors: MutableSet<Vector2D>? = null
  override fun calculate(): Set<Vector2D> {
    val nextLivingCells: MutableSet<Vector2D> = HashSet()
    nextLivingCells.addAll(calculateSurvivors())
    nextLivingCells.addAll(calculateEmergents())
    return nextLivingCells
  }

  private fun calculateEmergents(): Set<Vector2D> {
    return deadNeighbors!!.stream()
      .filter { deadCell: Vector2D -> canRevive(deadCell) }
      .collect(Collectors.toSet())
  }

  private fun calculateSurvivors(): Set<Vector2D> {
    return livingCells!!.stream()
      .filter { livingCell: Vector2D -> canSurvive(livingCell) }
      .collect(Collectors.toSet())
  }

  private fun canSurvive(livingCell: Vector2D): Boolean {
    val neighbors: Set<Vector2D> = calculateNeighborsOf(livingCell)
    var livingNeighbors = 0
    for (neighbor in neighbors) {
      if (livingCells!!.contains(neighbor)) {
        livingNeighbors++
      } else {
        // Used to verify if it becomes alive later
        deadNeighbors!!.add(neighbor)
      }
    }
    return livingNeighbors == 2 || livingNeighbors == 3
  }

  private fun calculateNeighborsOf(livingCell: Vector2D): Set<Vector2D> {
    return Arrays.stream(RELATIVE_NEIGHBORS)
      .map(livingCell::plus)
      .collect(Collectors.toSet())
  }

  private fun canRevive(deadCell: Vector2D): Boolean {
    val neighbors: Set<Vector2D> = calculateNeighborsOf(deadCell)
    var livingNeighbors = 0
    for (neighbor in neighbors) {
      if (livingCells!!.contains(neighbor)) {
        livingNeighbors++
      }
    }
    return livingNeighbors == 3
  }

  companion object {
    private val RELATIVE_NEIGHBORS: Array<Vector2D> = arrayOf(
      -1 x -1, 0 x -1, 1 x -1,
      -1 x 0 ,/* me */ 1 x 0,
      -1 x 1 , 0 x 1, 1 x 1
    )

    fun create(livingCells: Set<Vector2D>?): NextGenerationCalculatorImpl {
      val calculator = NextGenerationCalculatorImpl()
      calculator.livingCells = livingCells
      calculator.deadNeighbors = HashSet()
      return calculator
    }
  }
}