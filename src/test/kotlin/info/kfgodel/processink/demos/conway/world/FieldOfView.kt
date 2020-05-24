package info.kfgodel.processink.demos.conway.world

import info.kfgodel.mathe.api.Vector2D

/**
 * This type represents a segment of the conways world that is observable by a camera
 * Created by tenpines on 14/11/15.
 */
interface FieldOfView {
    fun dimension(): Vector2D?
    fun includes(position: Vector2D): Boolean
    fun makeRelative(absolute: Vector2D): Vector2D?

    companion object {
        fun create(topLeft: Vector2D?, bottomRight: Vector2D?): FieldOfView {
            return FieldOfViewImpl.create(topLeft, bottomRight)
        }
    }
}