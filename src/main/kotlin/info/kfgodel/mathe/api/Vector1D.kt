package info.kfgodel.mathe.api

import info.kfgodel.mathe.impl.V1

/**
 * This type represents a 1 dimensional vector.<br>
 * It has only 1 component to define a point in its linear space. Useful for simple magnitudes
 *
 * Date: 4/5/20 - 22:54
 */
interface Vector1D : Vector2D, Comparable<Vector1D> {

  /**
   * Returns the array containing itself as the component of the only dimension
   */
  override fun components() = arrayOf(component1())
  /**
   * Returns the zero vector as this has no second component
   */
  override fun component2() = V1.ZERO
  /**
   * Returns itself as the component of the first and only dimension
   */
  override fun component1() = this

  /**
   * Returns the float value this vector represents
   */
  fun toFloat(): Float

  /**
   * Returns the closes int value this vector represents
   */
  fun toInt(): Int = toFloat().toInt()

  operator fun plus(other: Vector1D): Vector1D {
    return V1(this.toFloat() + other.toFloat())
  }
  operator fun minus(other: Vector1D): Vector1D {
    return V1(this.toFloat() - other.toFloat())
  }
  operator fun times(other: Vector1D): Vector1D {
    return V1(this.toFloat() * other.toFloat())
  }
  operator fun div(other: Vector1D): Vector1D {
    return V1(this.toFloat() / other.toFloat())
  }
  operator fun plus(other: Number): Vector1D {
    return this + V1(other)
  }
  operator fun minus(other: Number): Vector1D {
    return this - V1(other)
  }
  operator fun times(other: Number): Vector1D {
    return this * V1(other)
  }
  operator fun div(other: Number): Vector1D {
    return this / V1(other)
  }

  override operator fun compareTo(other: Vector1D): Int {
    return this.toFloat().compareTo(other.toFloat())
  }

}