package info.kfgodel.mathe.api

/**
 * This type represents a 4 dimensional vector.<br>
 * It has 4 components to define a point in its space. Useful to represents colors with alpha levels
 *
 * Date: 4/5/20 - 22:54
 */
interface Vector4D : VectorND {


  /**
   * Returns the component vector for the first dimension of this vector.<br>
   * Named to match data class generated names
   */
  operator fun component1(): Vector1D
  /**
   * Returns the component vector for the second dimension of this vector.<br>
   * Named to match data class generated names
   */
  operator fun component2(): Vector1D
  /**
   * Returns the component vector for the third dimension of this vector.<br>
   * Named to match data class generated names
   */
  operator fun component3(): Vector1D
  /**
   * Returns the component vector for the fourth dimension of this vector.<br>
   * Named to match data class generated names
   */
  operator fun component4(): Vector1D

  /**
   * Returns the array of the 4 component vectors for each dimension of this vector
   */
  override fun components() = arrayOf(component1(), component2(), component3(), component4())
}