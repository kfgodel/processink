package info.kfgodel.processink.demos

import info.kfgodel.processink.impl.ProcessingApplet
import info.kfgodel.processink.impl.builder.DefaultSketchBuilder
import processing.core.PConstants

/**
 * This script serves as an example on how to create a hello world text sketch
 * Date: 21/5/20 - 20:58
 */
fun main() {
  val helloWorldSketch = DefaultSketchBuilder()
    .withSettings { it.size(200, 100, PConstants.P2D) }
    .drawing { it.text("Hello World!", 50f, 50f) }
    .build()

  ProcessingApplet.run(helloWorldSketch)
}