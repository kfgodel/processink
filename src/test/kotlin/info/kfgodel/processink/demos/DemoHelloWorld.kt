package info.kfgodel.processink.demos

import info.kfgodel.mathe.impl.V2
import info.kfgodel.processink.api.ext.viewports.WindowViewport
import info.kfgodel.processink.impl.ProcessingApplet
import info.kfgodel.processink.impl.builder.DefaultSketchBuilder

/**
 * This script serves as an example on how to create a hello world text sketch
 * Date: 21/5/20 - 20:58
 */
fun main() {
  val helloWorldSketch = DefaultSketchBuilder()
    .withSettings(WindowViewport(V2(200, 100)))
    .drawing { it.text("Hello World!", 50f, 50f) }
    .build()

  ProcessingApplet.run(helloWorldSketch)
}