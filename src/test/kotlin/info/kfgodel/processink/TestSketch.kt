package hello.tests.info.kfgodel.processink

import info.kfgodel.processink.api.ProcessingSketch
import mu.KotlinLogging
import kotlin.math.log

private val logger = KotlinLogging.logger {}

/**
 * Date: 2/5/20 - 18:25
 */
class TestSketch : ProcessingSketch  {
  override fun onSettings() {
    logger.info("onSettings")
  }

  override fun onSetup() {
    logger.info("onSetup")
  }

  override fun onDraw() {
    logger.info("onDraw")
  }

  override fun onMouseClicked() {
    logger.info("onMouseClicked")
  }
}