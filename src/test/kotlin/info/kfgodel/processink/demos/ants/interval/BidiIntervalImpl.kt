package info.kfgodel.processink.demos.ants.interval

import info.kfgodel.mathe.api.Vector2D
import java.util.Objects

/**
 * Implements a bi interval
 * Created by ikari on 16/01/2016.
 */
class BidiIntervalImpl(private val firstInterval: Interval, private val secondInterval: Interval) : BidiInterval {

  override operator fun contains(vector: Vector2D): Boolean {
    return firstInterval.contains(vector.component1()) && secondInterval.contains(vector.component2())
  }

  override fun firstInterval(): Interval {
    return firstInterval
  }

  override fun secondInterval(): Interval {
    return secondInterval
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) {
      return true
    }
    if (other is BidiInterval) {
      return firstInterval.equals(other.firstInterval()) && secondInterval.equals(other.secondInterval())
    }
    return false
  }

  override fun hashCode(): Int {
    return Objects.hash(firstInterval, secondInterval)
  }

  override fun toString(): String {
    val builder = StringBuilder()
    builder.append(firstInterval)
    builder.append("; ")
    builder.append(secondInterval)
    return builder.toString()
  }

}