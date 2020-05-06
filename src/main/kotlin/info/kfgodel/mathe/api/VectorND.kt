package info.kfgodel.mathe.api

/**
 * This type represents a vector with an arbitrary amount of dimensions.<br>
 * Here are the methods common to all vectors
 *
 * Date: 4/5/20 - 22:54
 */
interface VectorND {

  /**
   * Returns all the values for the components of this vector as an Array
   */
  fun coordinates(): Array<Vector1D>
}