package info.kfgodel.processink.api.ext

import info.kfgodel.processink.api.ext.viewports.ProcessingViewport
import info.kfgodel.processink.api.original.ProcessingSettings

/**
 * This file declares extensions to original Processing API for manipulating the sketch settings
 * Date: 22/5/20 - 00:03
 */

/**
 * Configures the sketch display area and renderer
 */
fun ProcessingSettings.viewport(viewport: ProcessingViewport) {
  viewport.accept(this)
}
