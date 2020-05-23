package info.kfgodel.mathe.impl

import info.kfgodel.mathe.api.Vector1D
import info.kfgodel.mathe.api.Vector4D

/**
 * This class implements the 4 dimensional vector with single precision floating points
 * Used on graphics calculations
 *
 * Date: 4/5/20 - 23:12
 */
data class V4(
  val v1: Vector1D,
  val v2: Vector1D,
  val v3: Vector1D,
  val v4: Vector1D
) : Vector4D {
  /**
   * Alternate constructors to reduce conversion typing
   */
  constructor(c1: Number, c2: Number, c3: Number, c4: Number) : this(V1(c1), V1(c2), V1(c3), V1(c4))

}