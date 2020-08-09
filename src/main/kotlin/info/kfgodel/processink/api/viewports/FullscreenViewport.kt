package info.kfgodel.processink.api.viewports

import info.kfgodel.processink.api.extended.ProcessinkSettings
import info.kfgodel.processink.api.original.OriginalEnvironmentApi
import info.kfgodel.processink.api.renderers.ProcessingRenderer

/**
 * This class represents the viewport configuration where a fullscreen render area is used.<br>
 * See for processing docs for semantics of this viewport type: https://processing.org/reference/fullScreen_.html
 * Date: 22/5/20 - 00:13
 */
class FullscreenViewport(
  private val renderer: ProcessingRenderer? = null,
  private val displayId: Int? = null
) : ProcessinkViewport, (ProcessinkSettings) -> Unit {

  override fun configure(environmentApi: OriginalEnvironmentApi) {
    if(renderer == null){
      if(displayId == null){
        environmentApi.fullScreen()
      }else{
        environmentApi.fullScreen(displayId)
      }
    }else {
      if(displayId == null){
        environmentApi.fullScreen(renderer.id)
      }else{
        environmentApi.fullScreen(renderer.id, displayId)
      }
    }
  }
}