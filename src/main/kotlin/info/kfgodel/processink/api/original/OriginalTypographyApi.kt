package info.kfgodel.processink.api.original

/**
 *  This type groups the methods Processing offers to handle text in the sketches.<br>
 *
 * Date: 8/8/20 - 18:51
 */
interface OriginalTypographyApi {

  /**
   * Draws a text string positioned under the indicated coordinates according to the current
   * positioning model.
   * @param text The string to display
   * @param x The x coordinate of the reference point
   * @param y The y coordinate of the reference point
   * @see [https://processing.org/reference/text_.html](https://processing.org/reference/text_.html)
   */
  fun text(text: String?, x: Float, y: Float)

}