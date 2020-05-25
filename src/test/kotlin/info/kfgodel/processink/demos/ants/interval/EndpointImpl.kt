package info.kfgodel.processink.demos.ants.interval

import info.kfgodel.mathe.api.Vector1D
import java.util.Objects
import java.util.function.Predicate

/**
 * Implements the endpoint behavior
 * Created by ikari on 14/01/2016.
 */
class EndpointImpl(private val referenceScalar: Vector1D, private val type: EndpointType) : Endpoint {
  private var inclusionOperator: Predicate<Vector1D> = type.getOperatorFor(referenceScalar)

  override fun referenceScalar(): Vector1D {
    return referenceScalar
  }

  override fun type(): EndpointType {
    return type
  }

  override fun includes(other: Vector1D): Boolean {
    return inclusionOperator.test(other)
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) {
      return true
    }
    if (other is Endpoint) {
      return type == other.type() && referenceScalar == other.referenceScalar()
    }
    return false
  }

  override fun hashCode(): Int {
    return Objects.hash(referenceScalar, type)
  }

  override fun toString(): String {
    return type.represent(referenceScalar)
  }

}