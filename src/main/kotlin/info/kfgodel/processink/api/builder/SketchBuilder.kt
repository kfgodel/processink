package info.kfgodel.processink.api.builder

import info.kfgodel.processink.api.ProcessingSketch
import info.kfgodel.processink.api.original.ProcessingApi
import info.kfgodel.processink.api.original.ProcessingSettings
import info.kfgodel.processink.api.original.ProcessingSetup

/**
 * This type allows the construction of a complex sketch defining it partially until it's readdy to build
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
  fun withSettings(customSettings: (ProcessingSettings) -> Unit): SketchBuilder

  /**
   * Accepts a block of code to define a custom sketch setup. This is done after the settings
   * phase and allows a sketch to define settings (if not done previously) and load or prepare assets if needed.
   * This code is executed after the settings code and before the drawing code.
   * @param customSetup The block of code to execute in the sketch to define its setup
   */
  fun withSetup(customSetup: (ProcessingSetup) -> Unit): SketchBuilder

  /**
   * Accepts a block of code to define custom drawing behavior on the generated sketch.
   * This code will be executed after settings and after setup code.
   * @param customDraw The block of code to execute in the sketch for each drawing frame
   */
  fun drawing(customDraw: (ProcessingApi) -> Unit): SketchBuilder


}