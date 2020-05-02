package info.kfgodel.processink

import hello.tests.info.kfgodel.processink.TestSketch
import info.kfgodel.processink.impl.runner.SketchToPAppletAdapter
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
  logger.info("Iniciando {}", Thread.currentThread().name)
  val sketch = TestSketch()
  SketchToPAppletAdapter.run(sketch)
  logger.info("Finalizando {}", Thread.currentThread().name)
}

