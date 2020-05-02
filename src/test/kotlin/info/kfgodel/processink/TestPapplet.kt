package info.kfgodel.processink

import mu.KotlinLogging
import org.slf4j.LoggerFactory
import processing.core.PApplet

/**
 * Date: 2/5/20 - 01:18
 */
private val logger = KotlinLogging.logger {}
class TestPapplet : PApplet() {
    init {
        logger.info("Init. {}" , Thread.currentThread().name)
    }

    override fun setup() {
        logger.info("Configurando sketch. {}" , Thread.currentThread().name)
        super.setup()
    }

    override fun draw() {
        super.draw()
        logger.info("Dibujando sketch. {}" , Thread.currentThread().name)
    }
}