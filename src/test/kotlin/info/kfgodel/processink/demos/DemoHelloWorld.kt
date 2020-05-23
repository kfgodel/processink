package info.kfgodel.processink.demos

import info.kfgodel.mathe.api.ext.x
import info.kfgodel.processink.api.ext.at
import info.kfgodel.processink.api.viewports.WindowViewport
import info.kfgodel.processink.impl.ProcessingApplet
import info.kfgodel.processink.impl.builder.DefaultSketchBuilder

/**
 * This script serves as an example on how to create a hello world text sketch
 * Date: 21/5/20 - 20:58
 */
fun main() {
  val helloWorldSketch = DefaultSketchBuilder()
    .withSettings(WindowViewport(200 x 100))
    .drawing("Hello World!".at(50 x 50))
    .build()

  ProcessingApplet.run(helloWorldSketch)
}