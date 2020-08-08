package info.kfgodel.processink.impl.builder

import info.kfgodel.processink.api.ProcessingSketch
import info.kfgodel.processink.api.builder.SketchBuilder
import info.kfgodel.processink.api.events.MouseEvent
import info.kfgodel.processink.api.extended.ProcessinkApi
import info.kfgodel.processink.api.extended.ProcessinkSettings
import info.kfgodel.processink.api.extended.ProcessinkSetup

/**
 * This class is the default implementation of the sketch builder
 * Date: 3/5/20 - 12:33
 */
class DefaultSketchBuilder : SketchBuilder {

  private var settingsBehavior: (ProcessinkSettings)-> Unit = ProcessinkSettings::defaultSettings
  private var setupBehavior: (ProcessinkSetup)-> Unit = ProcessinkSetup::defaultSetup
  private var drawBehavior: (ProcessinkApi)-> Unit = ProcessinkApi::defaultDraw

  private var mouseClickedHandler: (MouseEvent, ProcessinkApi)-> Unit = this::ignoreMouseEvent
  private var mouseDraggedHandler: (MouseEvent, ProcessinkApi)-> Unit = this::ignoreMouseEvent
  private var mouseEnteredHandler: (MouseEvent, ProcessinkApi)-> Unit = this::ignoreMouseEvent
  private var mouseExitedHandler: (MouseEvent, ProcessinkApi)-> Unit = this::ignoreMouseEvent
  private var mousePressedHandler: (MouseEvent, ProcessinkApi)-> Unit = this::ignoreMouseEvent
  private var mouseReleasedHandler: (MouseEvent, ProcessinkApi)-> Unit = this::ignoreMouseEvent
  private var mouseMovedHandler: (MouseEvent, ProcessinkApi)-> Unit = this::ignoreMouseEvent
  private var mouseWheelHandler: (MouseEvent, ProcessinkApi)-> Unit = this::ignoreMouseEvent

  override fun build(): ProcessingSketch {
    return PluggableSketch(
      settingsBehavior,
      setupBehavior,
      drawBehavior,
      mouseClickedHandler,
      mouseDraggedHandler,
      mouseEnteredHandler,
      mouseExitedHandler,
      mousePressedHandler,
      mouseReleasedHandler,
      mouseMovedHandler,
      mouseWheelHandler
    )
  }

  override fun withSettings(customSettings: (ProcessinkSettings) -> Unit) : SketchBuilder {
    this.settingsBehavior = customSettings
    return this
  }

  override fun withSetup(customSetup: (ProcessinkSetup) -> Unit) : SketchBuilder {
    this.setupBehavior = customSetup
    return this
  }

  override fun drawing(customDraw: (ProcessinkApi) -> Unit) : SketchBuilder {
    this.drawBehavior = customDraw
    return this
  }

  override fun whenMouseClicked(clickHandler: (MouseEvent, ProcessinkApi) -> Unit): SketchBuilder {
    this.mouseClickedHandler = clickHandler
    return this
  }

  override fun whenMouseDragged(dragHandler: (MouseEvent, ProcessinkApi) -> Unit): SketchBuilder {
    this.mouseDraggedHandler = dragHandler
    return this
  }

  override fun whenMouseEntered(enteredHandler: (MouseEvent, ProcessinkApi) -> Unit): SketchBuilder {
    this.mouseEnteredHandler = enteredHandler
    return this
  }

  override fun whenMouseExited(exitedHandler: (MouseEvent, ProcessinkApi) -> Unit): SketchBuilder {
    this.mouseExitedHandler = exitedHandler
    return this
  }

  override fun whenMousePressed(pressedHandler: (MouseEvent, ProcessinkApi) -> Unit): SketchBuilder {
    this.mousePressedHandler = pressedHandler
    return this
  }

  override fun whenMouseReleased(releasedHandler: (MouseEvent, ProcessinkApi) -> Unit): SketchBuilder {
    this.mouseReleasedHandler = releasedHandler
    return this
  }

  override fun whenMouseMoved(movedHandler: (MouseEvent, ProcessinkApi) -> Unit): SketchBuilder {
    this.mouseMovedHandler = movedHandler
    return this
  }

  override fun whenMouseWheel(wheelHandler: (MouseEvent, ProcessinkApi) -> Unit): SketchBuilder {
    this.mouseWheelHandler = wheelHandler
    return this
  }

  private fun ignoreMouseEvent(event:MouseEvent, processingApi: ProcessinkApi) {
    //Ignoring mouse event
  }

}