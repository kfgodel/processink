package info.kfgodel.processink.api.visuals.basic

import info.kfgodel.processink.api.original.ProcessingCanvas
import info.kfgodel.processink.api.visuals.VisualDescription

/**
 * This type represents a single color filled background visual
 * Created by tenpines on 30/10/15.
 */
inline class BackgroundVisual(private val color: Int) : VisualDescription {
  override fun invoke(canvas: ProcessingCanvas) {
    canvas.background(color)
  }
}