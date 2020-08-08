package info.kfgodel.processink.demos.conway.visuals

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.api.extended.ProcessinkCanvas
import info.kfgodel.processink.api.visuals.VisualDescription
import info.kfgodel.processink.api.visuals.basic.RectangleVisual
import info.kfgodel.processink.demos.conway.camera.Snapshot
import java.awt.Color

/**
 * This type represents the visual description of a conway snapshot
 * Created by kfgodel on 14/11/15.
 */
class SnapshotVisual(private val snapshot: Snapshot) : VisualDescription {

  override fun invoke(canvas: ProcessinkCanvas) {
    val cellSize = calculateCellSize(canvas)
    renderWith(Color.BLACK.rgb, snapshot.survivingCells(), canvas, cellSize)
    renderWith(Color.RED.rgb, snapshot.dyingCells(), canvas, cellSize)
    renderWith(Color.GREEN.rgb, snapshot.emergingCells(), canvas, cellSize)
  }

  private fun calculateCellSize(canvas: ProcessinkCanvas): Vector2D {
    // available pixels over amount of cells = pixels per cell
    return canvas.size() / snapshot.dimension()
  }

  private fun renderWith(color: Int, cells: List<Vector2D>, canvas: ProcessinkCanvas, cellSize: Vector2D) {
    canvas.applet().fill(color)
    cells.stream()
      .map { cell -> this.convertToRectangles(cell, cellSize) }
      .forEach { rectangle -> rectangle.invoke(canvas) }
  }

  private fun convertToRectangles(cellPosition: Vector2D, cellSize: Vector2D): RectangleVisual {
    val rectanglePosition: Vector2D = cellPosition * cellSize
    return RectangleVisual(rectanglePosition, cellSize)
  }

}