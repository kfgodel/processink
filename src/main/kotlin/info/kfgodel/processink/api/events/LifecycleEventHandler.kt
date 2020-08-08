package info.kfgodel.processink.api.events

import info.kfgodel.processink.api.extended.ProcessinkApi
import info.kfgodel.processink.api.extended.ProcessinkSettings
import info.kfgodel.processink.api.extended.ProcessinkSetup

/**
 * This interface defines the lifecycle events Processink calls on a sketch
 * Date: 6/6/20 - 16:55
 */
interface LifecycleEventHandler {
  /**
   * Called once by processing before the drawing context is created to setup the pixel environment settings.
   * Only few operations are allowed.<br>
   * @see [https://processing.org/reference/settings_.html](https://processing.org/reference/settings_.html)
   * @param settings The settings instance to configure processing
   */
  fun onSettings(settings: ProcessinkSettings) {
    settings.defaultSettings()
  }

  /**
   * Called once after the sketch drawing context is created but before actual drawing is done. Allows configuring
   * the pixel environment settings as well as loading resources (or other draw operations).
   * @see [https://processing.org/reference/setup_.html](https://processing.org/reference/setup_.html)
   * @param setup The setup instance to configure processing or load resources
   */
  fun onSetup(setup: ProcessinkSetup) {
    setup.defaultSetup()
  }

  /**
   * Called each frame after setup has been called to change the contents of the viewport in order to update the frame
   * <br>
   * How frequent this method gets called depends on the fps configuration of the sketch and
   * how much each frame takes to render. If it takes too much the fps goal may not be met.
   *
   * @see [https://processing.org/reference/draw_.html](https://processing.org/reference/draw_.html)
   * @param api The api Processing offers to manipulate the pixel space
   */
  fun onDraw(api: ProcessinkApi)
}