package info.kfgodel.mathe.api

import info.kfgodel.mathe.impl.V1
import info.kfgodel.mathe.impl.V2

/**
 * This type represents a 2 dimensional vector.<br>
 * It has 2 components to define a point in its plane space. Useful for 2d graphics
 * Date: 4/5/20 - 22:54
 */
interface Vector2D : Vector3D {

  /**
   * Returns the array of the 2 component vectors for each dimension of this vector
   */
  override fun components() = arrayOf(component1(), component2())
  /**
   * Returns the zero vector as this has no third component
   */
  override fun component3() = V1.ZERO

  operator fun plus(other: Vector2D): Vector2D {
    return V2(this.component1() + other.component1(), this.component2() + other.component2())
  }
  operator fun minus(other: Vector2D): Vector2D {
    return V2(this.component1() - other.component1(), this.component2() - other.component2())
  }
  operator fun times(other: Vector2D) = hadamardProduct(other)
  operator fun div(other: Vector2D) = hadamardDivision(other)

  fun scaledBy(other: Vector1D): Vector2D {
    return V2(this.component1() * other, this.component2() * other)
  }

  fun hadamardProduct(other: Vector2D): Vector2D {
    return V2(this.component1() * other.component1(), this.component2() * other.component2())
  }
  fun hadamardDivision(other: Vector2D): Vector2D {
    return V2(this.component1() / other.component1(), this.component2() / other.component2())
  }

}