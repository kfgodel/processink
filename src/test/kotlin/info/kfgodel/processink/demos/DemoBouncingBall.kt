package hello.tests.info.kfgodel.processink.demos

import info.kfgodel.mathe.impl.V2
import info.kfgodel.processink.api.original.ProcessingApi
import info.kfgodel.processink.demos.ball.BouncingBall
import info.kfgodel.processink.impl.ProcessingApplet
import info.kfgodel.processink.impl.builder.DefaultBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mu.KotlinLogging
import processing.core.PConstants

/**
 * This serves as a demo and a live test of the way processink can be used
 * Date: 3/5/20 - 02:20
 */
private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
  val ball = BouncingBall.createDefault()
  /**
   * Animate the ball using co-routine threads
   */
  GlobalScope.launch {
    do {
      ball.move()
      delay(150L)
    } while (true)
  }

  val viewSize = V2(640, 480)
  val sketch = DefaultBuilder()
    .withSettings { settings -> settings.size(viewSize.component1().toInt(), viewSize.component2().toInt(), PConstants.P2D) }
    .drawing { api ->
      api.background(0xAAAAAAA)
      ball.renderWith(api, viewSize)
    }
    .build()

  ProcessingApplet.run(sketch)
}

private fun BouncingBall.renderWith(api: ProcessingApi, viewSize: V2) {
  val ellipseCenter = this.position() * viewSize
  val ellipseDimensions = viewSize.scaledBy(this.diameter())
  api.ellipse(ellipseCenter.component1().toFloat(), ellipseCenter.component2().toFloat(),
    ellipseDimensions.component1().toFloat(), ellipseDimensions.component2().toFloat())
}
