package hello.tests.info.kfgodel.processink.demos

import info.kfgodel.mathe.impl.V2
import info.kfgodel.processink.demos.ball.BouncingBall
import info.kfgodel.processink.impl.ProcessingApplet
import info.kfgodel.processink.impl.builder.DefaultBuilder
import mu.KotlinLogging
import processing.core.PConstants

/**
 * This serves as a demo and a live test of the way processink can be used
 * Date: 3/5/20 - 02:20
 */
private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
  val ball = BouncingBall.createDefault()

  val viewSize = V2(640, 480)

  val sketch = DefaultBuilder()
    .withSettings { settings -> settings.size(viewSize.coordinate1().toInt(), viewSize.coordinate2().toInt(), PConstants.P2D) }
    .drawing { api ->
      api.background(0xAAAAAAA)

      val ellipseCenter = ball.position() * viewSize
      val ellipseDimensions = viewSize.scaledBy(ball.diameter())
      api.ellipse(ellipseCenter.coordinate1().toFloat(), ellipseCenter.coordinate2().toFloat(),
        ellipseDimensions.coordinate1().toFloat(), ellipseDimensions.coordinate2().toFloat())
    }
    .build()

  ProcessingApplet.run(sketch)
}