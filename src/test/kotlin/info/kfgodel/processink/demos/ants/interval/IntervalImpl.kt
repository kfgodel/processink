package info.kfgodel.processink.demos.ants.interval

import info.kfgodel.mathe.api.Vector1D
import info.kfgodel.mathe.impl.V1
import java.util.Objects

/**
 * Implementation of an interval using scalars
 * Created by ikari on 11/01/2016.
 */
class IntervalImpl(private val lowest: Endpoint, private val highest: Endpoint) : Interval {

  override fun lowestEndpoint(): Endpoint {
    return lowest
  }

  override fun highestEndpoint(): Endpoint {
    return highest
  }

  override operator fun contains(other: Vector1D): Boolean {
    return lowest.includes(other) && highest.includes(other)
  }

  override operator fun contains(value: Double): Boolean {
    return contains(V1(value))
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) {
      return true
    }
    if (other is Interval) {
      return lowest.equals(other.lowestEndpoint()) && highest.equals(other.highestEndpoint())
    }
    return false
  }

  override fun hashCode(): Int {
    return Objects.hash(lowest, highest)
  }

  override fun toString(): String {
    val builder = StringBuilder()
    builder.append(lowest)
    builder.append("; ")
    builder.append(highest)
    return builder.toString()
  }

}