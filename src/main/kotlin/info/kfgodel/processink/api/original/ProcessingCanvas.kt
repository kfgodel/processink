package info.kfgodel.processink.api.original

/**
 * This type represents the visual space that can be drawn on.<br></br>
 * It has all the methods that are used to draw or modify the canvas
 *
 * Created by kfgodel on 26/10/15.
 */
interface ProcessingCanvas : AppletWrapper, ProcessingStyle {
  /**
   * Default behavior implemented by Processing to draw a single frame
   */
  fun defaultDraw()

  /**
   * Current with of the pixel area
   */
  fun width(): Int
  /**
   * Current with of the pixel area
   */
  fun height(): Int

  /**
   * Draws a text string positioned under the indicated coordinates according to the current
   * positioning model.
   * @param text The string to display
   * @param x The x coordinate of the reference point
   * @param y The y coordinate of the reference point
   * @see [https://processing.org/reference/text_.html](https://processing.org/reference/text_.html)
   */
  fun text(text: String?, x: Float, y: Float)

  /**
   * Draws an ellipse or circle depending on the width and height, positioned using the current positioning mode
   * @param x The x coordinate of the reference point
   * @param y The y coordinate of the reference point
   * @param width The width of the ellipse
   * @param height The height of the ellipse
   * @see [https://processing.org/reference/ellipse_.html](https://processing.org/reference/ellipse_.html)
   */
  fun ellipse(x: Float, y: Float, width: Float, height: Float)

  /**
   * Redraws the viewport using a color
   * @param rgb The color to use
   * @see [https://processing.org/reference/background_.html](https://processing.org/reference/background_.html)
   */
  fun background(rgb: Int)

  /**
   * Draws a rectangle on teh given coordinates using the current rect mode
   * @param x The reference x coordinate
   * @param y The reference y coordinate
   * @param width The width of the rectangle
   * @param height The height of the rectangle
   * @see [https://processing.org/reference/rect_.html](https://processing.org/reference/rect_.html)
   */
  fun rect(x: Float, y: Float, width: Float, height: Float)
}