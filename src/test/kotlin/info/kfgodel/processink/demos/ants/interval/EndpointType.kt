package info.kfgodel.processink.demos.ants.interval

import info.kfgodel.mathe.api.Vector1D
import java.util.function.Predicate

/**
 * This type represents the different options for the restrictions of an endpoint
 * Created by ikari on 14/01/2016.
 */
enum class EndpointType {
  LOWEST_INCLUSIVE {
    override fun getOperatorFor(referenceScalar: Vector1D): Predicate<Vector1D> {
      return Predicate<Vector1D> { other -> referenceScalar <= other }
    }

    override fun represent(scalar: Vector1D): String {
      return "[$scalar"
    }
  },
  LOWEST_EXCLUSIVE {
    override fun getOperatorFor(referenceScalar: Vector1D): Predicate<Vector1D> {
      return Predicate<Vector1D> { other -> referenceScalar < other }
    }

    override fun represent(scalar: Vector1D): String {
      return "($scalar"
    }
  },
  HIGHEST_INCLUSIVE {
    override fun getOperatorFor(referenceScalar: Vector1D): Predicate<Vector1D> {
      return Predicate<Vector1D> { other -> referenceScalar >= other }
    }

    override fun represent(scalar: Vector1D): String {
      return "$scalar]"
    }
  },
  HIGHEST_EXCLUSIVE {
    override fun getOperatorFor(referenceScalar: Vector1D): Predicate<Vector1D> {
      return Predicate<Vector1D> { other -> referenceScalar > other }
    }

    override fun represent(scalar: Vector1D): String {
      return "$scalar)"
    }
  };

  /**
   * Gets the correct operator to use when comparin the reference scalar to others
   */
  abstract fun getOperatorFor(referenceScalar: Vector1D): Predicate<Vector1D>

  /**
   * Generates a string representation of this restriction around the given scalar
   */
  abstract fun represent(scalar: Vector1D): String
}