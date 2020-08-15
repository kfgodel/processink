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
   * Draws a rectangle at the given coordinates.<br>
   * Two points are used to define the rectangle and, depending on the rectMode, the interpretation of their
   * relationship and meaning.<br>
   * By default rectMode is CORNER, which interprets the first point as the top-left corner of the rectangle
   * and the second point as the width and height
   *
   * @param x First point x coordinate
   * @param y First point y coordinate
   * @param width Second point x coordinate
   * @param height Second point y coordinate
   * @see [https://processing.org/reference/rect_.html](https://processing.org/reference/rect_.html)
   */
  fun rect(x: Float, y: Float, width: Float, height: Float)

  /**
   * Defines how coordinates are interpreted when drawing a rectangle.<br>
   * There are 4 modes: CORNER, CORNERS, CENTER, or RADIUS.<br>
   * Each mode changes the semantic of what each point role is in the rectangle definition.
   * - CORNER: The 1st point is used as the top-left corner and the 2nd point is the width and height
   * - CORNERS: The 1st point is used as the top-left corner and the 2nd is the bottom-right corner
   * - CENTER: The 1st point is used as the center of the rectangle and the 2nd as width and height
   * - RADIUS: The 1st point is used as the center, the 2nd is half the width and height
   *
   * Each mode is a constant defined in PConstants
   */
  fun rectMode(mode: Int)
}