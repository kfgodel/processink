package info.kfgodel.processink.api.ext.vector

import info.kfgodel.mathe.api.Vector4D

/**
 * This file defines extension methods for vectors so they are to use from processink
 * Date: 6/5/20 - 00:44
 */

/**
 * Declares X as an alias for the first component of a vector
 */
fun Vector4D.x() = this.coordinate1()
/**
 * Declares X as an alias for the first component of a vector
 */
fun Vector4D.y() = this.coordinate2()
/**
 * Declares X as an alias for the first component of a vector
 */
fun Vector4D.z() = this.coordinate3()
/**
 * Declares X as an alias for the first component of a vector
 */
fun Vector4D.a() = this.coordinate4()
