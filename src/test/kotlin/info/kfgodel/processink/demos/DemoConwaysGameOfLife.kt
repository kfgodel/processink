package info.kfgodel.processink.demos

import info.kfgodel.mathe.api.ext.x
import info.kfgodel.processink.api.viewports.WindowViewport
import info.kfgodel.processink.demos.conway.camera.ConwayCamera
import info.kfgodel.processink.demos.conway.camera.ConwaySimulationVisual
import info.kfgodel.processink.demos.conway.world.ConwayWorld
import info.kfgodel.processink.impl.ProcessingApplet
import info.kfgodel.processink.impl.builder.DefaultSketchBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * This script demonstrates how to create a sketch for Conways game of life
 * Date: 23/5/20 - 21:51
 */

fun main() {
  val world = ConwayWorld.create(
    -2.0 x -1.0,
    -2.0 x 0.0, -1.0 x 0.0, 0.0 x 0.0, 1.0 x 0.0,
    -2.0 x 1.0
  )
  val camera = ConwayCamera.create(0.0 x 0.0, 100.0 x 80.0, world)

  // Evolve every half a second to produce the animation
  GlobalScope.launch {
    do {
      world.advanceOneGeneration()
      delay(500L)
    } while (true)
  }

  val conwaySketch = DefaultSketchBuilder()
    .withSettings(WindowViewport(800 x 600))
    .drawing(ConwaySimulationVisual.create(camera, 800 x 600))
    .build()

  ProcessingApplet.run(conwaySketch)
}