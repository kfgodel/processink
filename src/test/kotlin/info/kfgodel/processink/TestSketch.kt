package hello.tests.info.kfgodel.processink

import info.kfgodel.processink.api.ProcessingSketch
import info.kfgodel.processink.api.original.ProcessingApi
import info.kfgodel.processink.api.original.ProcessingSettings
import info.kfgodel.processink.api.original.ProcessingSetup
import info.kfgodel.processink.impl.runner.ProcessingApplet
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

/**
 * Date: 2/5/20 - 18:25
 */
class TestSketch : ProcessingSketch  {
  override fun onSettings(settings: ProcessingSettings) {
    logger.info("onSettings")
  }

  override fun onSetup(setup: ProcessingSetup) {
    logger.info("onSetup")
  }

  override fun onDraw(processingApi: ProcessingApi) {
    logger.info("onDraw")
    processingApi.defaultDraw()
  }
}