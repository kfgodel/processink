package info.kfgodel.processink.api.viewports

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.api.renderers.ProcessingRenderer
import info.kfgodel.processink.api.ext.vector.x
import info.kfgodel.processink.api.ext.vector.y
import info.kfgodel.processink.api.original.ProcessingSettings

/**
 * This class represents the viewport configuration where a predefined size window is used as render area
 * Date: 22/5/20 - 00:24
 */
class WindowViewport(
  private val size: Vector2D,
  private val renderer: ProcessingRenderer? = null,
  private val outputPath: String? = null
) : ProcessingViewport {

  override fun invoke(settings: ProcessingSettings) {
    if(renderer == null){
      settings.size(size.x().toInt(), size.y().toInt())
    }else{
      if(outputPath == null){
        settings.size(size.x().toInt(), size.y().toInt(), renderer.id)
      }else{
        settings.size(size.x().toInt(), size.y().toInt(), renderer.id, outputPath)
      }
    }
  }
}