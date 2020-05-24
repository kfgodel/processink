package info.kfgodel.processink.demos.conway.camera

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.impl.V2
import info.kfgodel.processink.api.ext.vector.height
import info.kfgodel.processink.api.ext.vector.width
import info.kfgodel.processink.api.ext.vector.x
import info.kfgodel.processink.api.ext.vector.y
import info.kfgodel.processink.api.original.ProcessingCanvas
import info.kfgodel.processink.api.visuals.VisualDescription
import info.kfgodel.processink.api.visuals.basic.RectangleVisual
import java.awt.Color

/**
 * This type represents the visual description of a conway snapshot
 * Created by tenpines on 14/11/15.
 */
class SnapshotVisual : VisualDescription {
  private var snapshot: Snapshot? = null
  private var pixelSpace: Vector2D? = null
  private var cellSize: Vector2D? = null
    private get() {
      if (field == null) {
        field = calculateCellSize()
      }
      return field
    }

  private fun convertToRectangles(cellPosition: Vector2D): RectangleVisual {
    val position: Vector2D = cellPosition * cellSize!!
    val cellSize: Vector2D = cellSize!!
    return RectangleVisual(position, cellSize)
  }

  private fun calculateCellSize(): Vector2D {
    val amountOfHorizontalCells: Float = snapshot!!.dimension()?.x()?.float!!
    val cellWidth: Float = pixelSpace!!.width().float / amountOfHorizontalCells
    val amountOfVerticalCells: Float = snapshot!!.dimension()?.y()?.float!!
    val cellHeight: Float = pixelSpace!!.height().float / amountOfVerticalCells
    return V2(cellWidth, cellHeight)
  }

  companion object {
    fun create(snapshot: Snapshot?, pixelSpace: Vector2D?): SnapshotVisual {
      val visual = SnapshotVisual()
      visual.snapshot = snapshot
      visual.pixelSpace = pixelSpace
      return visual
    }
  }

  override fun invoke(canvas: ProcessingCanvas) {
    canvas.fill(Color.BLACK.rgb)
    snapshot!!.survivingCells()!!.stream()
      .map { cellPosition: Vector2D? -> convertToRectangles(cellPosition!!) }
      .forEach { rectangle -> rectangle.invoke(canvas) }
    canvas.fill(Color.RED.rgb)
    snapshot!!.dyingCells()!!.stream()
      .map { cellPosition: Vector2D? -> convertToRectangles(cellPosition!!) }
      .forEach { rectangle -> rectangle.invoke(canvas) }
    canvas.fill(Color.GREEN.rgb)
    snapshot!!.emergingCells()!!.stream()
      .map { cellPosition: Vector2D? -> convertToRectangles(cellPosition!!) }
      .forEach { rectangle -> rectangle.invoke(canvas) }
  }
}