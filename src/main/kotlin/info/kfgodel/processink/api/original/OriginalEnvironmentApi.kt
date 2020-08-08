package info.kfgodel.processink.api.original

/**
 * This type groups the methods Processing offers to handle the sketch "environment" which defines rendering conditions
 * like pixel density, viewport size, fullscreen, cursor, etc.
 *
 * Date: 8/8/20 - 17:53
 */
interface OriginalEnvironmentApi {

  /**
   * Configures the render space to use a window with indicated size using the default renderer
   * @param width The width of the viewport in pixels
   * @param height The height of the viewport in pixels
   * @see [https://processing.org/reference/size_.html](https://processing.org/reference/size_.html)
   */
  fun size(width: Int, height: Int)

  /**
   * Configures the render space to use a window with indicated size and the selected renderer
   * @param width The width of the viewport in pixels
   * @param height The height of the viewport in pixels
   * @param renderer one of the possible renderer constants
   * @see [https://processing.org/reference/size_.html](https://processing.org/reference/size_.html)
   */
  fun size(width: Int, height: Int, renderer: String)

  /**
   * Configures the render space area to be output on a file used the selected renderer
   * @param width The width of the viewport in pixels
   * @param height The height of the viewport in pixels
   * @param renderer one of the possible renderer constants
   * @param outputPath The path where the render output is expected to be produced (depends on the renderer)
   * @see [https://processing.org/reference/size_.html](https://processing.org/reference/size_.html)
   */
  fun size(width: Int, height: Int, renderer: String, outputPath: String)

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