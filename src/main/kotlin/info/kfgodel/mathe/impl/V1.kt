package info.kfgodel.mathe.impl

import info.kfgodel.mathe.api.Vector1D


/**
 * This class implements the single dimension vector with a single precision floating point
 * Used on graphics calculations
 *
 * Date: 4/5/20 - 23:12
 */
inline class V1(override val float: Float) : Vector1D {
  /**
   * Alternate constructors to reduce conversion typing
   */
  constructor(c1: Number) : this(c1.toFloat())

  companion object {
    @JvmStatic
    val ONE = V1(1.0f)
    @JvmStatic
    val ZERO = V1(0.0f)
  }

}