package info.kfgodel.mathe.api

import info.kfgodel.mathe.impl.V1

/**
 * This type represents a 3 dimensional vector.<br>
 * It has 3 components to define a point in its space. Useful for 3d graphics
 * Date: 4/5/20 - 22:54
 */
interface Vector3D : Vector4D {

  override fun coordinate4() = V1.ZERO
  override fun coordinates() = arrayOf(coordinate1(), coordinate2(), coordinate3())
}