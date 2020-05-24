package info.kfgodel.processink.api.viewports

import info.kfgodel.processink.api.original.ProcessingSettings
import info.kfgodel.processink.api.renderers.ProcessingRenderer

/**
 * This class represents the viewport configuration where a fullscreen render area is used.<br>
 * See for processing docs for semantics of this viewport type: https://processing.org/reference/fullScreen_.html
 * Date: 22/5/20 - 00:13
 */
class FullscreenViewport(
  private val renderer: ProcessingRenderer? = null,
  private val displayId: Int? = null
) : ProcessingViewport {

  override fun invoke(settings: ProcessingSettings) {
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