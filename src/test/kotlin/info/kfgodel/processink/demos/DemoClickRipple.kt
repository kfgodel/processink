package info.kfgodel.processink.demos

import info.kfgodel.mathe.api.ext.x
import info.kfgodel.processink.api.viewports.WindowViewport
import info.kfgodel.processink.api.visuals.basic.BackgroundVisual
import info.kfgodel.processink.api.visuals.basic.EllipseVisual
import info.kfgodel.processink.demos.ripple.RippleWorld
import info.kfgodel.processink.demos.ripple.SystemWorldClock
import info.kfgodel.processink.impl.ProcessingApplet
import info.kfgodel.processink.impl.builder.DefaultSketchBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * This scripts shows a demo of handling click events and a visualization on the sketch
 * Date: 6/6/20 - 19:08
 */
fun main() {
  val world = RippleWorld.create(SystemWorldClock())
  animate(world)

  val rippleSketch = DefaultSketchBuilder()
    .withSettings(WindowViewport(640 x 480))
    .whenMousePressed { mouseEvent, api ->
      world.mouseClickedOn(mouseEvent.position)
    }
    .drawing { api ->
      BackgroundVisual(-0x55555556).invoke(api)
      world.ripples().forEach { wave ->
        EllipseVisual(wave.position(), wave.radius() x wave.radius())
          .invoke(api)
      }
    }
    .build()

  ProcessingApplet.run(rippleSketch)
}

fun animate(world: RippleWorld) {
  // Update the world ripples every 100ms
  GlobalScope.launch {
    do {
      delay(100L)
      world.removeDeadRipples()
    } while (true)
  }
}
