package info.kfgodel.mathe.impl

import info.kfgodel.mathe.api.Vector1D
import info.kfgodel.mathe.api.Vector3D

/**
 * This class implements the 3 dimensional vector with single precision floating points
 * Used on graphics calculations
 *
 * Date: 4/5/20 - 23:12
 */
data class V3(
  val v1: Vector1D,
  val v2: Vector1D,
  val v3: Vector1D
) : Vector3D {
  /**
   * Alternate constructors to reduce conversion typing
   */
  constructor(c1: Number, c2: Number, c3: Number) : this(V1(c1), V1(c2), V1(c3))
  constructor(v1: Vector1D, c2: Number, c3: Number) : this(v1, V1(c2), V1(c3))
  constructor(v1: Vector1D, v2: Vector1D, c3: Number) : this(v1, v2, V1(c3))
  constructor(c1: Number, v2: Vector1D, c3: Number) : this(V1(c1), v2, V1(c3))
  constructor(c1: Number, v2: Vector1D, v3: Vector1D) : this(V1(c1), v2, v3)
  constructor(c1: Number, c2: Number, v3: Vector1D) : this(V1(c1), V1(c2), v3)
  constructor(v1: Vector1D, c2: Number, v3: Vector1D) : this(v1, V1(c2), v3)

}