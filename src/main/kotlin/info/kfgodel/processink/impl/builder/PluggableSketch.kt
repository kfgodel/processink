package info.kfgodel.processink.impl.builder

import info.kfgodel.processink.api.ProcessingSketch
import info.kfgodel.processink.api.events.MouseEvent
import info.kfgodel.processink.api.extended.ProcessinkApi
import info.kfgodel.processink.api.extended.ProcessinkSettings
import info.kfgodel.processink.api.extended.ProcessinkSetup

/**
 * This class implements the sketch interface by delegating each responsibility to a different
 * code block. It allows configuring the behavior of each part separately
 *
 * Date: 3/5/20 - 12:54
 */
class PluggableSketch(
        private val settingsBehavior: (ProcessinkSettings) -> Unit,
        private val setupBehavior: (ProcessinkSetup) -> Unit,
        private val drawBehavior: (ProcessinkApi) -> Unit,
        private var mouseClickedHandler: (MouseEvent, ProcessinkApi)-> Unit,
        private var mouseDraggedHandler: (MouseEvent, ProcessinkApi)-> Unit,
        private var mouseEnteredHandler: (MouseEvent, ProcessinkApi)-> Unit,
        private var mouseExitedHandler: (MouseEvent, ProcessinkApi)-> Unit,
        private var mousePressedHandler: (MouseEvent, ProcessinkApi)-> Unit,
        private var mouseReleasedHandler: (MouseEvent, ProcessinkApi)-> Unit,
        private var mouseMovedHandler: (MouseEvent, ProcessinkApi)-> Unit,
        private var mouseWheelHandler: (MouseEvent, ProcessinkApi)-> Unit
) : ProcessingSketch {

  override fun onSettings(settings: ProcessinkSettings) {
    settingsBehavior.invoke(settings)
  }

  override fun onSetup(setup: ProcessinkSetup) {
    setupBehavior.invoke(setup)
  }

  override fun onDraw(api: ProcessinkApi) {
    drawBehavior.invoke(api)
  }

  override fun onMouseClicked(event: MouseEvent, api: ProcessinkApi) {
    mouseClickedHandler.invoke(event, api)
  }

  override fun onMouseDragged(event: MouseEvent, api: ProcessinkApi) {
    mouseDraggedHandler.invoke(event, api)
  }

  override fun onMouseEntered(event: MouseEvent, api: ProcessinkApi) {
    mouseEnteredHandler.invoke(event, api)
  }

  override fun onMouseExited(event: MouseEvent, api: ProcessinkApi) {
    mouseExitedHandler.invoke(event, api)
  }

  override fun onMouseMoved(event: MouseEvent, api: ProcessinkApi) {
    mouseMovedHandler.invoke(event, api)
  }

  override fun onMousePressed(event: MouseEvent, api: ProcessinkApi) {
    mousePressedHandler.invoke(event, api)
  }

  override fun onMouseReleased(event: MouseEvent, api: ProcessinkApi) {
    mouseReleasedHandler.invoke(event, api)
  }

  override fun onMouseWheel(event: MouseEvent, api: ProcessinkApi) {
    mouseWheelHandler.invoke(event, api)
  }
}