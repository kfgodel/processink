package info.kfgodel.mathe.api

import info.kfgodel.mathe.impl.V1

/**
 * This type represents a 3 dimensional vector.<br>
 * It has 3 components to define a point in its space. Useful for 3d graphics
 * Date: 4/5/20 - 22:54
 */
interface Vector3D : Vector4D {

  /**
   * Returns the array of the 3 component vectors for each dimension of this vector
   */
  override fun components() = arrayOf(component1(), component2(), component3())
  /**
   * Returns the zero vector as this has no fourth component
   */
  override operator fun component4() = V1.ZERO
}