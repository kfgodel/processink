package info.kfgodel.processink.demos.conway.camera

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.demos.conway.states.CellState
import info.kfgodel.processink.demos.conway.world.ConwayWorld
import info.kfgodel.processink.demos.conway.world.DefaultFieldOfView
import info.kfgodel.processink.demos.conway.world.FieldOfView

/**
 * Implementation of the camera
 * Created by kfgodel on 14/11/15.
 */
class DefaultConwayCamera(
  private val target: Vector2D,
  private val size: Vector2D
) : ConwayCamera {

  override fun takeSnapshot(world: ConwayWorld): Snapshot {
    val fieldOfView = calculateFieldOfView()
    val area = world.getStateInside(fieldOfView)
    return groupCellsByStateIn(fieldOfView, area.activeCellStates())
  }

  private fun groupCellsByStateIn(view: FieldOfView, cellStates: Map<Vector2D, CellState>): Snapshot {
    val survivingCells = ArrayList<Vector2D>()
    val dyingCells = ArrayList<Vector2D>()
    val emergingCells = ArrayList<Vector2D>()

    for ((position, cellState) in cellStates.entries) {
      val viewPosition: Vector2D = view.makeRelative(position)
      val cellList: MutableList<Vector2D> = when (cellState) {
        CellState.DYING -> dyingCells
        CellState.EMERGING -> emergingCells
        CellState.SURVIVING -> survivingCells
      }
      cellList.add(viewPosition)
    }
    return DefaultSnapshot(view.size(), survivingCells, dyingCells, emergingCells)
  }

  private fun calculateFieldOfView(): FieldOfView {
    val quadrant: Vector2D = size.scaledBy(0.5)
    val topLeft: Vector2D = target.minus(quadrant)
    val bottomRight: Vector2D = target.plus(quadrant)
    return DefaultFieldOfView(topLeft, bottomRight)
  }

}