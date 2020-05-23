package info.kfgodel.processink.demos

import info.kfgodel.processink.impl.ProcessingApplet
import info.kfgodel.processink.impl.builder.DefaultSketchBuilder

/**
 * This script serves as an example of the minimal setup for a processing sketch to run
 * Date: 21/5/20 - 20:54
 */
fun main() {
  // Create a sketch with all the defaults
  val minimalSketch = DefaultSketchBuilder().build()

  // Let processing run it
  ProcessingApplet.run(minimalSketch)
}