package info.kfgodel.processink.demos.conway.camera

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.demos.conway.world.ConwayWorld

/**
 * This type represents a limited size view of a conway game of life infinite space
 *
 * Created by tenpines on 14/11/15.
 */
interface ConwayCamera {
    /**
     * Takes the portion of space looked by this camera and captures it in a non changing snapshot, that
     * won't be affected by the passing of time on the game
     * @return The captured partial state from the game
     */
    fun takeSnapshot(): Snapshot

    /**
     * @return The cell this camera is targeting at
     */
    fun target(): Vector2D?

    /**
     * @return The 2d dimensions of this camera view in terms of cells
     */
    fun size(): Vector2D?

    companion object {
        fun create(target: Vector2D?, size: Vector2D?, world: ConwayWorld?): ConwayCamera {
            return ConwayCameraImpl.create(target, size, world)
        }
    }
}