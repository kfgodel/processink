package info.kfgodel.mathe.impl

import info.kfgodel.mathe.api.Vector1D
import info.kfgodel.mathe.api.Vector2D

/**
 * This class implements the 2 dimensional vector with single precision floating points
 * Used on graphics calculations
 *
 * Date: 4/5/20 - 23:12
 */
data class V2(val v1: Vector1D, val v2: Vector1D) : Vector2D {
  /**
   * Alternate constructors to reduce conversion typing
   */
  constructor(c1: Number, c2: Number) : this(V1(c1),V1(c2))
  constructor(v1: Vector1D, c2: Number) : this(v1,V1(c2))
  constructor(c1: Number, v2: Vector1D) : this(V1(c1),v2)

  override fun coordinate1() = v1
  override fun coordinate2() = v2


}