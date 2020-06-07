package info.kfgodel.processink.impl.builder

import info.kfgodel.processink.api.ProcessingSketch
import info.kfgodel.processink.api.builder.SketchBuilder
import info.kfgodel.processink.api.events.MouseEvent
import info.kfgodel.processink.api.original.ProcessingApi
import info.kfgodel.processink.api.original.ProcessingSettings
import info.kfgodel.processink.api.original.ProcessingSetup

/**
 * This class is the default implementation of the sketch builder
 * Date: 3/5/20 - 12:33
 */
class DefaultSketchBuilder : SketchBuilder {

  private var settingsBehavior: (ProcessingSettings)-> Unit = ProcessingSettings::defaultSettings
  private var setupBehavior: (ProcessingSetup)-> Unit = ProcessingSetup::defaultSetup
  private var drawBehavior: (ProcessingApi)-> Unit = ProcessingApi::defaultDraw

  private var mouseClickedHandler: (MouseEvent, ProcessingApi)-> Unit = this::ignoreMouseEvent
  private var mouseDraggedHandler: (MouseEvent, ProcessingApi)-> Unit = this::ignoreMouseEvent
  private var mouseEnteredHandler: (MouseEvent, ProcessingApi)-> Unit = this::ignoreMouseEvent
  private var mouseExitedHandler: (MouseEvent, ProcessingApi)-> Unit = this::ignoreMouseEvent
  private var mousePressedHandler: (MouseEvent, ProcessingApi)-> Unit = this::ignoreMouseEvent
  private var mouseReleasedHandler: (MouseEvent, ProcessingApi)-> Unit = this::ignoreMouseEvent
  private var mouseMovedHandler: (MouseEvent, ProcessingApi)-> Unit = this::ignoreMouseEvent
  private var mouseWheelHandler: (MouseEvent, ProcessingApi)-> Unit = this::ignoreMouseEvent

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

  override fun withSettings(customSettings: (ProcessingSettings) -> Unit) : SketchBuilder {
    this.settingsBehavior = customSettings
    return this
  }

  override fun withSetup(customSetup: (ProcessingSetup) -> Unit) : SketchBuilder {
    this.setupBehavior = customSetup
    return this
  }

  override fun drawing(customDraw: (ProcessingApi) -> Unit) : SketchBuilder {
    this.drawBehavior = customDraw
    return this
  }

  override fun whenMouseClicked(clickHandler: (MouseEvent, ProcessingApi) -> Unit): SketchBuilder {
    this.mouseClickedHandler = clickHandler
    return this
  }

  override fun whenMouseDragged(dragHandler: (MouseEvent, ProcessingApi) -> Unit): SketchBuilder {
    this.mouseDraggedHandler = dragHandler
    return this
  }

  override fun whenMouseEntered(enteredHandler: (MouseEvent, ProcessingApi) -> Unit): SketchBuilder {
    this.mouseEnteredHandler = enteredHandler
    return this
  }

  override fun whenMouseExited(exitedHandler: (MouseEvent, ProcessingApi) -> Unit): SketchBuilder {
    this.mouseExitedHandler = exitedHandler
    return this
  }

  override fun whenMousePressed(pressedHandler: (MouseEvent, ProcessingApi) -> Unit): SketchBuilder {
    this.mousePressedHandler = pressedHandler
    return this
  }

  override fun whenMouseReleased(releasedHandler: (MouseEvent, ProcessingApi) -> Unit): SketchBuilder {
    this.mouseReleasedHandler = releasedHandler
    return this
  }

  override fun whenMouseMoved(movedHandler: (MouseEvent, ProcessingApi) -> Unit): SketchBuilder {
    this.mouseMovedHandler = movedHandler
    return this
  }

  override fun whenMouseWheel(wheelHandler: (MouseEvent, ProcessingApi) -> Unit): SketchBuilder {
    this.mouseWheelHandler = wheelHandler
    return this
  }

  private fun ignoreMouseEvent(event:MouseEvent, processingApi: ProcessingApi) {
    //Ignoring mouse event
  }

}