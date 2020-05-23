package info.kfgodel.processink.api.ext.viewports

import info.kfgodel.processink.api.ext.renderers.ProcessingRenderer
import info.kfgodel.processink.api.original.ProcessingSettings

/**
 * This class represents the viewport configuration where a fullscreen render area is used
 * Date: 22/5/20 - 00:13
 */
class FullscreenViewport(
  private val renderer: ProcessingRenderer? = null,
  private val displayId: Int? = null
) : ProcessingViewport {

  override fun accept(settings: ProcessingSettings) {
    if(renderer == null){
      if(displayId == null){
        settings.fullScreen()
      }else{
        settings.fullScreen(displayId)
      }
    }else {
      if(displayId == null){
        settings.fullScreen(renderer.id)
      }else{
        settings.fullScreen(renderer.id, displayId)
      }
    }
  }
}