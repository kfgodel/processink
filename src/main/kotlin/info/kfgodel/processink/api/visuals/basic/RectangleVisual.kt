package info.kfgodel.processink.api.visuals.basic

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.api.ext.vector.height
import info.kfgodel.processink.api.ext.vector.width
import info.kfgodel.processink.api.ext.vector.x
import info.kfgodel.processink.api.ext.vector.y
import info.kfgodel.processink.api.original.ProcessingCanvas
import info.kfgodel.processink.api.visuals.VisualDescription

/**
 * This type represents a rectangle drawing
 * Created by tenpines on 04/11/15.
 */
class RectangleVisual(private val position: Vector2D, private val size: Vector2D) : VisualDescription {
  override fun invoke(canvas: ProcessingCanvas) {
    canvas.rect(position.x().float, position.y().float, size.width().float, size.height().float)
  }
}