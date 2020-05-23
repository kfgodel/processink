package info.kfgodel.processink.api.ext.processing

import info.kfgodel.processink.api.original.ProcessingSettings
import info.kfgodel.processink.api.viewports.ProcessingViewport

/**
 * This file declares extensions to original Processing API for manipulating the sketch settings
 * Date: 22/5/20 - 00:03
 */

/**
 * Configures the sketch display area and renderer
 */
fun ProcessingSettings.viewport(viewport: ProcessingViewport) {
  viewport.invoke(this)
}
