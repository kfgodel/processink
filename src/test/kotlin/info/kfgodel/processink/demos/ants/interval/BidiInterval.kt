package info.kfgodel.processink.demos.ants.interval

import info.kfgodel.mathe.api.Vector2D

/**
 * This type represents a bi dimensional interval
 * Created by ikari on 16/01/2016.
 */
interface BidiInterval {
  /**
   * Indicates if the given vector is inside the area delimited by this interval
   * @param vector The vector to test
   * @return True if the vector components fulfill this interval restrictions
   */
  operator fun contains(vector: Vector2D): Boolean

  /**
   * @return The interval that restricts the first component
   */
  fun firstInterval(): Interval

  /**
   * @return The interval that restricts the second component
   */
  fun secondInterval(): Interval

  companion object {
    /**
     * Creates a bi-dimensional interval from 2 simple intervals
     * @param firstComponentInterval The interval that restricts first component values
     * @param secondComponentInterval The interval that restricts second component values
     * @return The created bi-interval
     */
    fun from(firstComponentInterval: Interval, secondComponentInterval: Interval): BidiInterval {
      return BidiIntervalImpl(firstComponentInterval, secondComponentInterval)
    }
  }
}