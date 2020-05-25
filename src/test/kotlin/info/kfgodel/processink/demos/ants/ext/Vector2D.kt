package info.kfgodel.processink.demos.ants.ext

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.impl.V2
import kotlin.math.cos
import kotlin.math.sin

/**
 * Extensions to vector for the ants demo
 * Date: 25/5/20 - 11:03
 */

/**
 * Returns a vector with the components rounded to the smallest int value
 */
fun Vector2D.integered(): Vector2D = V2(this.component1().toInt(), this.component2().toInt())


/**
 * Rotates this vector counter-clockwise the amount of given degrees
 * @param degrees The amount of degrees to rotate
 * @return The resulting vector
 */
fun Vector2D.rotate(degrees: Double): Vector2D {
  val angleInRadians: Double = Math.toRadians(degrees)
  val cos: Double = cos(angleInRadians)
  val sin: Double = sin(angleInRadians)
  val x = this.component1().float
  val y = this.component2().float
  return V2(x * cos - y * sin, x * sin + y * cos)
}
