package info.kfgodel.mathe.api.ext

import info.kfgodel.mathe.api.Vector1D
import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.api.Vector3D
import info.kfgodel.mathe.impl.V1
import info.kfgodel.mathe.impl.V2
import info.kfgodel.mathe.impl.V3

/**
 * Extension method added to number so vectors are simpler to use
 * Date: 23/5/20 - 11:42
 */

/**
 * Creates a 1D vector out of a number and uses it as its component
 */
fun Number.toV(): Vector1D = V1(this)

/**
 * Creates a 2d Vector out of two numbers and uses them as the components.
 *
 * This can be chained for 3d vectors
 */
infix fun Number.x(second: Number): Vector2D = V2(this, second)

/**
 * Creates a 3d Vector out of a 2d and a number
 *
 * This can be chained for 4d vectors
 */
infix fun Vector2D.x(third: Number): Vector3D = V3(this.component1(), this.component2(), third)

