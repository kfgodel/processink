package info.kfgodel.processink.api.original

/**
 * This type represents the Processing API available when defining the sketch settings
 * Date: 2/5/20 - 21:04
 */
interface ProcessingSettings : AppletWrapper {
  /**
   * Default behavior implemented by processing applet to setup the pixel environment.
   */
  fun defaultSettings()

  /**
   * Defines the configuration of the view port by setting a size and
   * a renderer type
   * @param width The width of the viewport in pixels
   * @param height The height of the viewport in pixels
   * @param renderer one of the possible renderer constants
   * @see [https://processing.org/reference/size_.html](https://processing.org/reference/size_.html)
   */
  fun size(width: Int, height: Int, renderer: String?)

  /**
   * Configures the view to use the fullscreen size (actual size depends on the current display and operating system)
   * using default renderer on the default display adapter
   * @see [https://processing.org/reference/fullScreen_.html](https://processing.org/reference/fullScreen_.html)
   */
  fun fullScreen()
  /**
   * Configures the view to use the fullscreen size with a specific renderer on the default display adapter
   * @param renderer The renderer to use in the viewport
   * @see [https://processing.org/reference/fullScreen_.html](https://processing.org/reference/fullScreen_.html)
   */
  fun fullScreen(renderer: String)
  /**
   * Configures the view to use the fullscreen size on a specific display adapter using default renderer
   * @param displayID The number that identifies the adapter
   * @see [https://processing.org/reference/fullScreen_.html](https://processing.org/reference/fullScreen_.html)
   */
  fun fullScreen(displayID: Int)
  /**
   * Configures the view to use the fullscreen size on a specific adapter using the selected renderer
   * @param renderer The renderer to use in the viewport
   * @param displayID The number that identifies the adapter
   * @see [https://processing.org/reference/fullScreen_.html](https://processing.org/reference/fullScreen_.html)
   */
  fun fullScreen(renderer: String, displayID: Int)

}