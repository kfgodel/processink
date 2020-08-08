package hello.tests.info.kfgodel.processink.demos

import info.kfgodel.mathe.api.ext.x
import info.kfgodel.processink.api.extended.ProcessinkApi
import info.kfgodel.processink.api.viewports.WindowViewport
import info.kfgodel.processink.api.visuals.basic.BackgroundVisual
import info.kfgodel.processink.demos.ball.BouncingBall
import info.kfgodel.processink.impl.ProcessingApplet
import info.kfgodel.processink.impl.builder.DefaultSketchBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mu.KotlinLogging

/**
 * This serves as a demo and a live test of the way processink can be used
 * Date: 3/5/20 - 02:20
 */
private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
  val ball = BouncingBall.createDefault()

  animate(ball)

  val sketch = DefaultSketchBuilder()
    .withSettings(WindowViewport(640 x 480))
    .drawing { api ->
      BackgroundVisual(0xAAAAAAA).invoke(api)
      ball.renderWith(api)
    }
    .build()

  ProcessingApplet.run(sketch)
}

private fun animate(ball: BouncingBall) {
  // Animate the ball using co-routine threads
  GlobalScope.launch {
    do {
      ball.move()
      delay(150L)
    } while (true)
  }
}

private fun BouncingBall.renderWith(canvas: ProcessinkApi) {
  val ellipseCenter = this.position() * canvas.size
  val ellipseDimensions = canvas.size.scaledBy(this.diameter())
  canvas.ellipse(ellipseCenter.component1().float, ellipseCenter.component2().float,
    ellipseDimensions.component1().float, ellipseDimensions.component2().float)
}
