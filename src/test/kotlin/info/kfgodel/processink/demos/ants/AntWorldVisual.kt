package info.kfgodel.processink.demos.ants

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.api.ext.processing.size
import info.kfgodel.processink.api.original.ProcessingCanvas
import info.kfgodel.processink.api.visuals.VisualDescription
import info.kfgodel.processink.api.visuals.basic.RectangleVisual
import java.awt.Color

/**
 * This type represents the visual description (in terms of processing) of the ant world for each frame
 * Created by tenpines on 04/11/15.
 */
class AntWorldVisual(private val world: AntWorld) : VisualDescription {

  override fun invoke(canvas: ProcessingCanvas) {
    canvas.background(-0x55555556)

    val cellSize = calculateCellSize(canvas)
    renderBlackCells(canvas, cellSize)
    renderAnt(canvas, cellSize)
  }

  private fun renderAnt(canvas: ProcessingCanvas, cellSize: Vector2D) {
    canvas.fill(Color.RED.rgb)
    val antRectangle: RectangleVisual = convertToRectangles(world.ant().position(), cellSize)
    antRectangle.invoke(canvas)
  }

  private fun renderBlackCells(canvas: ProcessingCanvas, cellSize: Vector2D) {
    canvas.fill(Color.BLACK.rgb)
    world.blackCells().stream()
      .map { blackCell -> convertToRectangles(blackCell, cellSize) }
      .forEach { rectangle -> rectangle.invoke(canvas) }
  }

  private fun convertToRectangles(blackCell: Vector2D, cellSize: Vector2D): RectangleVisual {
    val position: Vector2D = blackCell * cellSize
    return RectangleVisual(position, cellSize)
  }

  private fun calculateCellSize(canvas: ProcessingCanvas): Vector2D {
    // Amount of pixels / cells = pixels per cell
    return canvas.size / world.cellSpace()
  }
}