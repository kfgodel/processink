package info.kfgodel.mathe.api

import info.kfgodel.mathe.impl.V4

/**
 * This type represents a 4 dimensional vector.<br>
 * It has 4 components to define a point in its space. Useful to represents colors with alpha levels
 *
 * Date: 4/5/20 - 22:54
 */
interface Vector4D : VectorND {


  /**
   * Returns the component vector for the first dimension of this vector.<br>
   * Named to match data class generated names
   */
  operator fun component1(): Vector1D
  /**
   * Returns the component vector for the second dimension of this vector.<br>
   * Named to match data class generated names
   */
  operator fun component2(): Vector1D
  /**
   * Returns the component vector for the third dimension of this vector.<br>
   * Named to match data class generated names
   */
  operator fun component3(): Vector1D
  /**
   * Returns the component vector for the fourth dimension of this vector.<br>
   * Named to match data class generated names
   */
  operator fun component4(): Vector1D

  /**
   * Returns the array of the 4 component vectors for each dimension of this vector
   */
  override fun components() = arrayOf(component1(), component2(), component3(), component4())

  operator fun plus(other: Vector4D): Vector4D {
    return V4(
      this.component1() + other.component1(),
      this.component2() + other.component2(),
      this.component3() + other.component3(),
      this.component4() + other.component4()
    )
  }
  operator fun minus(other: Vector4D): Vector4D {
    return V4(
      this.component1() - other.component1(),
      this.component2() - other.component2(),
      this.component3() - other.component3(),
      this.component4() - other.component4()
    )
  }
  operator fun times(other: Vector4D) = hadamardProduct(other)
  operator fun div(other: Vector4D) = hadamardDivision(other)

  fun scaledBy(other: Vector1D): Vector4D {
    return V4(
      this.component1() * other,
      this.component2() * other,
      this.component3() * other,
      this.component4() * other
    )
  }

  fun hadamardProduct(other: Vector4D): Vector4D {
    return V4(
      this.component1() * other.component1(),
      this.component2() * other.component2(),
      this.component3() * other.component3(),
      this.component4() * other.component4()
    )
  }
  fun hadamardDivision(other: Vector4D): Vector4D {
    return V4(
      this.component1() / other.component1(),
      this.component2() / other.component2(),
      this.component3() / other.component3(),
      this.component4() / other.component4()
    )
  }
}