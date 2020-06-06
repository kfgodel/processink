package info.kfgodel.processink.impl.builder

import info.kfgodel.processink.api.ProcessingSketch
import info.kfgodel.processink.api.events.MouseEvent
import info.kfgodel.processink.api.original.ProcessingApi
import info.kfgodel.processink.api.original.ProcessingSettings
import info.kfgodel.processink.api.original.ProcessingSetup

/**
 * This class implements the sketch interface by delegating each responsibility to a different
 * code block. It allows configuring the behavior of each part separately
 *
 * Date: 3/5/20 - 12:54
 */
class PluggableSketch(
  private val settingsBehavior: (ProcessingSettings) -> Unit,
  private val setupBehavior: (ProcessingSetup) -> Unit,
  private val drawBehavior: (ProcessingApi) -> Unit,
  private var mouseClickedHandler: (MouseEvent, ProcessingApi)-> Unit,
  private var mouseDraggedHandler: (MouseEvent, ProcessingApi)-> Unit,
  private var mouseEnteredHandler: (MouseEvent, ProcessingApi)-> Unit,
  private var mouseExitedHandler: (MouseEvent, ProcessingApi)-> Unit,
  private var mousePressedHandler: (MouseEvent, ProcessingApi)-> Unit,
  private var mouseReleasedHandler: (MouseEvent, ProcessingApi)-> Unit,
  private var mouseMovedHandler: (MouseEvent, ProcessingApi)-> Unit,
  private var mouseWheelHandler: (MouseEvent, ProcessingApi)-> Unit
) : ProcessingSketch {

  override fun onSettings(settings: ProcessingSettings) {
    settingsBehavior.invoke(settings)
  }

  override fun onSetup(setup: ProcessingSetup) {
    setupBehavior.invoke(setup)
  }

  override fun onDraw(api: ProcessingApi) {
    drawBehavior.invoke(api)
  }

  override fun onMouseClicked(event: MouseEvent, api: ProcessingApi) {
    mouseClickedHandler.invoke(event, api)
  }

  override fun onMouseDragged(event: MouseEvent, api: ProcessingApi) {
    mouseDraggedHandler.invoke(event, api)
  }

  override fun onMouseEntered(event: MouseEvent, api: ProcessingApi) {
    mouseEnteredHandler.invoke(event, api)
  }

  override fun onMouseExited(event: MouseEvent, api: ProcessingApi) {
    mouseExitedHandler.invoke(event, api)
  }

  override fun onMouseMoved(event: MouseEvent, api: ProcessingApi) {
    mouseMovedHandler.invoke(event, api)
  }

  override fun onMousePressed(event: MouseEvent, api: ProcessingApi) {
    mousePressedHandler.invoke(event, api)
  }

  override fun onMouseReleased(event: MouseEvent, api: ProcessingApi) {
    mouseReleasedHandler.invoke(event, api)
  }

  override fun onMouseWheel(event: MouseEvent, api: ProcessingApi) {
    mouseWheelHandler.invoke(event, api)
  }
}