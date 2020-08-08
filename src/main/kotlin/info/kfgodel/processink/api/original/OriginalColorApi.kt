package info.kfgodel.processink.api.original

/**
 * This type groups the methods Processing offers to handle color in the sketches
 *
 * Date: 8/8/20 - 19:00
 */
interface OriginalColorApi {

  /**
   * Redraws the viewport using a color
   * @param rgb The color to use
   * @see [https://processing.org/reference/background_.html](https://processing.org/reference/background_.html)
   */
  fun background(rgb: Int)

}