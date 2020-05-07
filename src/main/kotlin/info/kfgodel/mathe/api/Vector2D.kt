package info.kfgodel.mathe.api

import info.kfgodel.mathe.impl.V1
import info.kfgodel.mathe.impl.V2

/**
 * This type represents a 2 dimensional vector.<br>
 * It has 2 components to define a point in its plane space. Useful for 2d graphics
 * Date: 4/5/20 - 22:54
 */
interface Vector2D : Vector3D {

  override fun coordinate3() = V1.ZERO
  override fun coordinates() = arrayOf(coordinate1(), coordinate2())

  operator fun plus(other: Vector2D): Vector2D {
    return V2(this.coordinate1() + other.coordinate1(), this.coordinate2() + other.coordinate2())
  }
  operator fun minus(other: Vector2D): Vector2D {
    return V2(this.coordinate1() - other.coordinate1(), this.coordinate2() - other.coordinate2())
  }
  operator fun times(other: Vector2D) = hadamardProduct(other)
  operator fun div(other: Vector2D) = hadamardDivision(other)

  fun scaledBy(other: Vector1D): Vector2D {
    return V2(this.coordinate1() * other, this.coordinate2() * other)
  }

  fun hadamardProduct(other: Vector2D): Vector2D {
    return V2(this.coordinate1() * other.coordinate1(), this.coordinate2() * other.coordinate2())
  }
  fun hadamardDivision(other: Vector2D): Vector2D {
    return V2(this.coordinate1() / other.coordinate1(), this.coordinate2() / other.coordinate2())
  }

}