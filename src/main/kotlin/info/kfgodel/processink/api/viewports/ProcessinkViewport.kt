package info.kfgodel.processink.api.viewports

import info.kfgodel.processink.api.extended.ProcessinkSettings
import info.kfgodel.processink.api.original.OriginalEnvironmentApi

/**
 * This interface represents a configuration for the display area in which the sketch will be rendered.
 * By using instances of this type a sketch size and renderer settings can be defined.
 *
 * Date: 22/5/20 - 00:16
 */
interface ProcessinkViewport : (ProcessinkSettings) -> Unit {

  /**
   * Configures settings of the applet environment using its API
   */
  fun configure(environmentApi: OriginalEnvironmentApi)

  /**
   * When used to configure settings it affects the applet
   */
  override fun invoke(settings: ProcessinkSettings) {
    settings.viewport(this)
  }
}