package info.kfgodel.processink.api.builder

import info.kfgodel.processink.api.ProcessingSketch
import info.kfgodel.processink.api.events.MouseEvent
import info.kfgodel.processink.api.extended.ProcessinkApi
import info.kfgodel.processink.api.extended.ProcessinkSettings
import info.kfgodel.processink.api.extended.ProcessinkSetup

/**
 * This type allows the construction of a complex sketch defining it configuration partially until
 * it's ready to be built
 *
 * Date: 3/5/20 - 12:31
 */
interface SketchBuilder {

  /**
   * Creates a sketch instance with the expected behavior configured on this builder.
   * If not customization is made, then a default sketch is created (behaves as implemented by Processing
   * out-of-the-box)
   */
  fun build(): ProcessingSketch

  /**
   * Accepts a block of code to configure the settings for processing.<br>
   * Processing will use the settings to create the pixel space to draw in before the sketch is
   * started. This code is executed before the sketch setup and drawing code.
   * @param customSettings The block of code to execute in the sketch to define its settings
   */
  fun withSettings(customSettings: (ProcessinkSettings) -> Unit): SketchBuilder

  /**
   * Accepts a block of code to define a custom sketch setup. This is done after the settings
   * phase and allows a sketch to define settings (if not done previously) and load or prepare assets if needed.
   * This code is executed after the settings code and before the drawing code.
   * @param customSetup The block of code to execute in the sketch to define its setup
   */
  fun withSetup(customSetup: (ProcessinkSetup) -> Unit): SketchBuilder

  /**
   * Accepts a block of code to define custom drawing behavior on the generated sketch.
   * This code will be executed after settings and after setup code.
   * @param customDraw The block of code to execute in the sketch for each drawing frame
   */
  fun drawing(customDraw: (ProcessinkApi) -> Unit): SketchBuilder

  /**
   * Defines a mouse click event handler to be called for that event
   */
  fun whenMouseClicked(clickHandler: (MouseEvent, ProcessinkApi) -> Unit): SketchBuilder
  /**
   * Defines a mouse drag event handler to be called for that event
   */
  fun whenMouseDragged(dragHandler: (MouseEvent, ProcessinkApi) -> Unit): SketchBuilder
  /**
   * Defines a mouse into sketch window event handler to be called for that event
   */
  fun whenMouseEntered(enteredHandler: (MouseEvent, ProcessinkApi) -> Unit): SketchBuilder
  /**
   * Defines a mouse out of sketch window event handler to be called for that event
   */
  fun whenMouseExited(exitedHandler: (MouseEvent, ProcessinkApi) -> Unit): SketchBuilder
  /**
   * Defines a mouse button press event handler to be called for that event
   */
  fun whenMousePressed(pressedHandler: (MouseEvent, ProcessinkApi) -> Unit): SketchBuilder
  /**
   * Defines a mouse button release event handler to be called for that event
   */
  fun whenMouseReleased(releasedHandler: (MouseEvent, ProcessinkApi) -> Unit): SketchBuilder
  /**
   * Defines a mouse move event handler to be called for that event
   */
  fun whenMouseMoved(movedHandler: (MouseEvent, ProcessinkApi) -> Unit): SketchBuilder
  /**
   * Defines a mouse wheel event handler to be called for that event
   */
  fun whenMouseWheel(wheelHandler: (MouseEvent, ProcessinkApi) -> Unit): SketchBuilder


}