package info.kfgodel.processink.demos.ants.interval

import info.kfgodel.mathe.api.Vector1D

/**
 * This type represents the set of numbers between two scalars
 * Created by ikari on 11/01/2016.
 */
interface Interval {
  /**
   * The lower scalar of the two that define this interval.<br></br>
   * Any of them if they are equal
   * @return The minimum scalar
   */
  fun lowestEndpoint(): Endpoint

  /**
   * The higher scalar of teh two that define this interval.<br></br>
   * Any if they are equal
   * @return The maximum scalar
   */
  fun highestEndpoint(): Endpoint

  /**
   * Indicates if this interval contains the given element
   * @param other The scalar to test
   * @return true if the endpoints of this interval include the scalar
   */
  operator fun contains(other: Vector1D): Boolean

  /**
   * Facility method
   */
  operator fun contains(value: Double): Boolean

  companion object {
    /**
     * Creates an interval with the given endpoints
     * @param lowestEndpoint The lowest value endpoint
     * @param highestEndpoint The upperbound endpoint
     * @return The created interval
     */
    fun from(lowestEndpoint: Endpoint, highestEndpoint: Endpoint): Interval {
      return IntervalImpl(lowestEndpoint, highestEndpoint)
    }

    /**
     * Creates an interval with the give parameters. Ordering the first and second scalar
     */
    fun intervalOrdering(first: Vector1D, second: Vector1D, lowestType: EndpointType, highestType: EndpointType): Interval {
      val lowest: Vector1D
      val highest: Vector1D
      if (first > second) {
        highest = first
        lowest = second
      } else {
        lowest = first
        highest = second
      }
      val lowestEndpoint: Endpoint = Endpoint.from(lowest, lowestType)
      val highestEndpoint: Endpoint = Endpoint.from(highest, highestType)
      return from(lowestEndpoint, highestEndpoint)
    }

    fun intervalInclusiveExclusive(first: Vector1D, second: Vector1D): Interval {
      return intervalOrdering(first, second, EndpointType.LOWEST_INCLUSIVE, EndpointType.HIGHEST_EXCLUSIVE)
    }

  }
}