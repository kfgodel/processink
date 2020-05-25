package info.kfgodel.processink.demos.ants.interval

import info.kfgodel.mathe.api.Vector1D
import info.kfgodel.mathe.impl.V1

/**
 * This type represents the end of an interval, defined by a number an a restriction (inclusion or exclusion)
 *
 * Created by ikari on 14/01/2016.
 */
interface Endpoint {
  /**
   * @return The scalar that defines the value to which this endpoint is constrained to
   */
  fun referenceScalar(): Vector1D

  /**
   * @return The type that defines the restriction of this endpoint
   */
  fun type(): EndpointType

  /**
   * Indicates if this endpoint as defined includes the given scalar, or considers it outside the restriction
   * @param other The scalar to compare to
   * @return True if the given scalar can be considered inside this endpoint
   */
  fun includes(other: Vector1D): Boolean

  companion object {
    /**
     * Facility method accepting primitive
     */
    fun lowestIncluding(lowestValue: Double): Endpoint {
      return lowestIncluding(V1(lowestValue))
    }

    /**
     * Creates an endpoint that represents the lowest acceptable value, including it
     * @param lowestScalar The value to accept
     * @return The new endpoint
     */
    fun lowestIncluding(lowestScalar: Vector1D): Endpoint {
      return EndpointImpl(lowestScalar, EndpointType.LOWEST_INCLUSIVE)
    }

    /**
     * Creates an endpoint that represents the lowest acceptable bound, excluding its value
     * @param lowestScalar The value to reject as limit
     * @return The new endpoint
     */
    fun lowestExcluding(lowestScalar: Vector1D): Endpoint {
      return EndpointImpl(lowestScalar, EndpointType.LOWEST_EXCLUSIVE)
    }

    /**
     * Facility method that accepts primitives
     */
    fun lowestExcluding(lowestValue: Double): Endpoint {
      return lowestExcluding(V1(lowestValue))
    }

    /**
     * Creates an endpoint that represents the highest acceptable bound, excluding its value
     * @param highestScalar The value to reject as limit
     * @return The new endpoint
     */
    fun highestExcluding(highestScalar: Vector1D): Endpoint {
      return EndpointImpl(highestScalar, EndpointType.HIGHEST_EXCLUSIVE)
    }

    /**
     * Facility method that accepts primitives
     */
    fun highestExcluding(highestValue: Double): Endpoint {
      return highestExcluding(V1(highestValue))
    }

    /**
     * Creates an endpoint that represents the highest acceptable value, including it
     * @param highestScalar The value to accept as maximum
     * @return The new endpoint
     */
    fun highestIncluding(highestScalar: Vector1D): Endpoint {
      return EndpointImpl(highestScalar, EndpointType.HIGHEST_INCLUSIVE)
    }

    /**
     * Facility method that accepts primitives
     */
    fun highestIncluding(highestValue: Double): Endpoint {
      return highestIncluding(V1(highestValue))
    }

    /**
     * Creates an endpoint with a pre-defined type
     * @param reference The number to use as reference
     * @param restrictionType The restriction to apply around the reference to define inclusion
     * @return The created endpoint
     */
    fun from(reference: Vector1D, restrictionType: EndpointType?): Endpoint {
      return EndpointImpl(reference, restrictionType!!)
    }
  }
}