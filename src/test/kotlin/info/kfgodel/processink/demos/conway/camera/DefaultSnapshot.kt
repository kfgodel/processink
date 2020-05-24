package info.kfgodel.processink.demos.conway.camera

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.demos.conway.states.CellState
import info.kfgodel.processink.demos.conway.states.WorldAreaState
import java.util.*

/**
 * This type implements the snapshot of a conways world
 * Created by kfgodel on 14/11/15.
 */
class DefaultSnapshot(private val worldAreaState: WorldAreaState) : Snapshot {
  private val survivingCells = ArrayList<Vector2D>()
  private val dyingCells = ArrayList<Vector2D>()
  private val emergingCells = ArrayList<Vector2D>()

  init {
      classifyCellsByState()
  }

  override fun survivingCells(): List<Vector2D> {
    return survivingCells
  }

  override fun dyingCells(): List<Vector2D> {
    return dyingCells
  }

  override fun emergingCells(): List<Vector2D> {
    return emergingCells
  }

  override fun dimension(): Vector2D {
    return worldAreaState.dimension()
  }

  private fun classifyCellsByState() {
    val entries = worldAreaState.activeCellStates().entries
    for ((position, cellState) in entries) {
      val cellList: MutableList<Vector2D> = when (cellState) {
        CellState.DYING -> dyingCells
        CellState.EMERGING -> emergingCells
        CellState.SURVIVING -> survivingCells
      }
      val relativePosition: Vector2D = worldAreaState.makeRelative(position)
      cellList.add(relativePosition)
    }
  }
}