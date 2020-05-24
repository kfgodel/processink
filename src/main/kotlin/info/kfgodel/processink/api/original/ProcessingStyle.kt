package info.kfgodel.processink.api.original

/**
 * This type represents the style options that processing offers for drawing in the canvas
 *
 * Created by kfgodel on 04/11/15.
 */
interface ProcessingStyle {
    /**
     * Defines the inner fill color to use for newly drawn shapes
     * @param rgb The color definition
     * @see [https://processing.org/reference/fill_.html](https://processing.org/reference/fill_.html)
     */
    fun fill(rgb: Int)
}