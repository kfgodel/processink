package info.kfgodel.processink.demos

import info.kfgodel.mathe.api.ext.x
import info.kfgodel.processink.api.viewports.WindowViewport
import info.kfgodel.processink.demos.ants.AntWorld
import info.kfgodel.processink.demos.ants.AntWorldVisual
import info.kfgodel.processink.impl.ProcessingApplet
import info.kfgodel.processink.impl.builder.DefaultSketchBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * This scripts shows a demo for langston ants on processink
 * Date: 25/5/20 - 10:53
 */

fun main() {
  val world = AntWorld.create(200 x 150)
  animate(world)

  val conwaySketch = DefaultSketchBuilder()
    .withSettings(WindowViewport(800 x 600))
    .drawing(AntWorldVisual(world))
    .build()

  ProcessingApplet.run(conwaySketch)
}

private fun animate(world: AntWorld) {
  // Evolve every half a second to produce the animation
  GlobalScope.launch {
    do {
      delay(10L)
      world.advanceOneTimeUnit()
    } while (true)
  }
}