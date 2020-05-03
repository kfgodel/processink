package hello.tests.info.kfgodel.processink.demos

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

  val sketch = DefaultBuilder()
    .withSettings { settings -> settings.size(640, 480, PConstants.P2D) }
    .drawing { api -> api.background(0xAAAAAAA) }
    .build()

  ProcessingApplet.run(sketch)
}