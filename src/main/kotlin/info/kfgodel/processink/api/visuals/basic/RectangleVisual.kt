package info.kfgodel.processink.api.visuals.basic

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.api.ext.vector.height
import info.kfgodel.processink.api.ext.vector.width
import info.kfgodel.processink.api.ext.vector.x
import info.kfgodel.processink.api.ext.vector.y
import info.kfgodel.processink.api.extended.ProcessinkCanvas
import info.kfgodel.processink.api.visuals.VisualDescription

/**
 * This type represents a rectangle drawing
 * Created by kfgodel on 04/11/15.
 */
class RectangleVisual(private val position: Vector2D, private val size: Vector2D) : VisualDescription {
  override fun invoke(canvas: ProcessinkCanvas) {
    canvas.applet().rect(position.x().float, position.y().float, size.width().float, size.height().float)
  }
}