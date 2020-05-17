package info.kfgodel.processink.api.ext.vector

import info.kfgodel.mathe.api.Vector4D

/**
 * This file defines extension methods for vectors so they are to use from processink
 * Date: 6/5/20 - 00:44
 */

/**
 * Declares X as an alias for the first component of a vector
 */
fun Vector4D.x() = this.component1()
/**
 * Declares X as an alias for the first component of a vector
 */
fun Vector4D.y() = this.component2()
/**
 * Declares X as an alias for the first component of a vector
 */
fun Vector4D.z() = this.component3()
/**
 * Declares X as an alias for the first component of a vector
 */
fun Vector4D.a() = this.component4()
