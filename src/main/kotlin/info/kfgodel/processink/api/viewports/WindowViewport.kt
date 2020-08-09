package info.kfgodel.processink.api.viewports

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.api.ext.vector.x
import info.kfgodel.processink.api.ext.vector.y
import info.kfgodel.processink.api.original.OriginalEnvironmentApi
import info.kfgodel.processink.api.renderers.ProcessingRenderer

/**
 * This class represents the viewport configuration where a predefined size window is used as render area.<br>
 * See for processing docs for semantics of this viewport type: https://processing.org/reference/size_.html
 * Date: 22/5/20 - 00:24
 */
class WindowViewport(
  private val size: Vector2D,
  private val renderer: ProcessingRenderer? = null,
  private val outputPath: String? = null
) : ProcessinkViewport {

  override fun configure(environmentApi: OriginalEnvironmentApi) {
    if(renderer == null){
      environmentApi.size(size.x().toInt(), size.y().toInt())
    }else{
      if(outputPath == null){
        environmentApi.size(size.x().toInt(), size.y().toInt(), renderer.id)
      }else{
        environmentApi.size(size.x().toInt(), size.y().toInt(), renderer.id, outputPath)
      }
    }
  }
}