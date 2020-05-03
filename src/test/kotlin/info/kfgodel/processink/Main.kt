package info.kfgodel.processink

import hello.tests.info.kfgodel.processink.TestSketch
import info.kfgodel.processink.impl.ProcessingApplet
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
  logger.info("Iniciando {}", Thread.currentThread().name)
  val sketch = TestSketch()
  ProcessingApplet.run(sketch)
  logger.info("Finalizando {}", Thread.currentThread().name)
}

