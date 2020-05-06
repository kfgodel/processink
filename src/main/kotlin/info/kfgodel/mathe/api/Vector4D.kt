package info.kfgodel.mathe.api

/**
 * This type represents a 4 dimensional vector.<br>
 * It has 4 components to define a point in its space. Useful to represents colors with alpha levels
 *
 * Date: 4/5/20 - 22:54
 */
interface Vector4D : VectorND {
  /**
   * Returns the first component value of this vector.<br>
   */
  fun coordinate1(): Vector1D
  /**
   * Returns the second component value of this vector
   */
  fun coordinate2(): Vector1D
  /**
   * Returns the third component value of this vector
   */
  fun coordinate3(): Vector1D
  /**
   * Returns the fourth component value of this vector
   */
  fun coordinate4(): Vector1D

  override fun coordinates() = arrayOf(coordinate1(), coordinate2(), coordinate3(), coordinate4())
}