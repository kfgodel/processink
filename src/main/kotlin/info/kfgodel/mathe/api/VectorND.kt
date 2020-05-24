package info.kfgodel.mathe.api

import info.kfgodel.mathe.impl.V1

/**
 * This type represents a vector with an arbitrary amount of dimensions.<br>
 * Here are the methods common to all vectors
 *
 * Date: 4/5/20 - 22:54
 */
interface VectorND {

  /**
   * Returns all component vectors for each dimension of this vector separated in an Array
   */
  fun components(): Array<Vector1D>

  /**
   * Creates a new vector where each component is multiplied by the given vector
   */
  fun scaledBy(other: Vector1D): VectorND
  fun scaledBy(other: Number) = this.scaledBy(V1(other))

  /**
   * Returns a new vector with the same direction but inverted sense
   */
  fun invert(): VectorND
}