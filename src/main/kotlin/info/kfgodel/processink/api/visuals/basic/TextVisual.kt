package info.kfgodel.processink.api.visuals.basic

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.api.ext.vector.x
import info.kfgodel.processink.api.ext.vector.y
import info.kfgodel.processink.api.extended.ProcessinkCanvas
import info.kfgodel.processink.api.visuals.VisualDescription

/**
 * This type represents the visual description of text for processing
 *
 * Created by kfgodel on 28/10/15.
 */
class TextVisual(private val text: String, private val position: Vector2D) : VisualDescription {

  override fun invoke(canvas: ProcessinkCanvas) {
    canvas.applet().text(text, position.x().float, position.y().float)
  }
}