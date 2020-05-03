package info.kfgodel.processink.api

import info.kfgodel.processink.api.original.ProcessingApi
import info.kfgodel.processink.api.original.ProcessingSettings
import info.kfgodel.processink.api.original.ProcessingSetup

/**
 * This type represents a user defined processing "sketch" visualization.<br>
 * The sketch represents what the user wants Processing to do when it's run.<br>
 * It not only includes visualizations but any of the Processing features (music, sound, camera, etc)
 *
 * Created by kfgodel on 26/10/15.
 */
interface ProcessingSketch {
  /**
   * Called once by processing before the drawing context is created to setup the pixel environment settings.
   * Only few operations are allowed.<br>
   * @see [https://processing.org/reference/settings_.html](https://processing.org/reference/settings_.html)
   * @param settings The settings instance to configure processing
   */
  fun onSettings(settings: ProcessingSettings) {
    settings.defaultSettings()
  }

  /**
   * Called once after the sketch drawing context is created but before actual drawing is done. Allows configuring
   * the pixel environment settings as well as loading resources (or other draw operations).
   * @see [https://processing.org/reference/setup_.html](https://processing.org/reference/setup_.html)
   * @param setup The setup instance to configure processing or load resources
   */
  fun onSetup(setup: ProcessingSetup) {
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
  fun onDraw(api: ProcessingApi)

}