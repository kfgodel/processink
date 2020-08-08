package info.kfgodel.processink.api.extended

import info.kfgodel.processink.api.viewports.ProcessingViewport

/**
 * This type represents the Processing API available when defining the sketch settings
 * Date: 2/5/20 - 21:04
 */
interface ProcessinkSettings : AppletWrapper {
  /**
   * Default behavior implemented by processing applet to setup the pixel environment.
   */
  fun defaultSettings()

  /**
   * Configures the sketch display area and renderer by using a viewport definition
   */
  fun viewport(viewport: ProcessingViewport) {
    viewport.invoke(this)
  }
}

