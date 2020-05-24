package info.kfgodel.processink.demos.conway.states

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.demos.conway.world.FieldOfView

/**
 * Default implementation of a state area
 * Created by kfgodel on 14/11/15.
 */
class DefaultWorldAreaState(
  private val fieldOfView: FieldOfView,
  private val previousLivingCells: Set<Vector2D>,
  private val currentLivingCells: Set<Vector2D>
) : WorldAreaState {

  override fun dimension(): Vector2D {
    return fieldOfView.dimension()
  }

  override fun makeRelative(absolute: Vector2D): Vector2D {
    return fieldOfView.makeRelative(absolute)
  }

  override fun activeCellStates(): Map<Vector2D, CellState> {
    val statePerPosition = HashMap<Vector2D, CellState>()

    insideFieldOfView(previousLivingCells)
      .forEach { cell ->
        val stillAlive = currentLivingCells.contains(cell)
        val newState = if (stillAlive) CellState.SURVIVING else CellState.DYING
        statePerPosition[cell] = newState
      }

    insideFieldOfView(currentLivingCells)
      .filter { livingCell -> !previousLivingCells.contains(livingCell) }
      .forEach { newCell -> statePerPosition[newCell] = CellState.EMERGING }

    return statePerPosition
  }

  private fun insideFieldOfView(cells: Set<Vector2D>) = cells.stream()
    .filter { cell -> fieldOfView.includes(cell) }


}