package info.kfgodel.processink.api.ext.viewports

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.api.ext.vector.x
import info.kfgodel.processink.api.ext.vector.y
import info.kfgodel.processink.api.original.ProcessingSettings

/**
 * This class represents the viewport configuration where a predefined size window is used as render area
 * Date: 22/5/20 - 00:24
 */
class WindowViewport(private val size: Vector2D, private val renderer: String?) : ProcessingViewport {
  override fun accept(settings: ProcessingSettings) {
    settings.size(size.x().toInt(), size.y().toInt(), renderer)
  }
}