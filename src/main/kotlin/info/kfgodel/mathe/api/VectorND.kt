package info.kfgodel.mathe.api

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
}