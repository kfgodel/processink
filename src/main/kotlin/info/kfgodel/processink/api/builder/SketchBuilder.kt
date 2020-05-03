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
   * Defines a custom block of code to configure the settings on the generated sketch
   * @param customSettings The block of code to execute in the sketch to define its settings
   */
  fun withSettings(customSettings: (ProcessingSettings) -> Unit): SketchBuilder

  /**
   * Defines a custom block of code to configure the setup on the generated sketch
   * @param customSetup The block of code to execute in the sketch to define its setup
   */
  fun withSetup(customSetup: (ProcessingSetup) -> Unit): SketchBuilder

  /**
   * Defines a custom block of code to use on the generated sketch for drawing
   * @param customDraw The block of code to execute in the sketch for each drawing frame
   */
  fun drawing(customDraw: (ProcessingApi) -> Unit): SketchBuilder


}