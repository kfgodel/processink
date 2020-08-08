package info.kfgodel.processink.api.original

/**
 * This type groups the methods Processing offers to draw different shapes into a 2d and 3d space
 * Date: 8/8/20 - 18:56
 */
interface OriginalShapeApi {

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
   * Draws a rectangle on teh given coordinates using the current rect mode
   * @param x The reference x coordinate
   * @param y The reference y coordinate
   * @param width The width of the rectangle
   * @param height The height of the rectangle
   * @see [https://processing.org/reference/rect_.html](https://processing.org/reference/rect_.html)
   */
  fun rect(x: Float, y: Float, width: Float, height: Float)

}