package info.kfgodel.processink.demos.ripple

import info.kfgodel.mathe.api.Vector2D

/**
 * This type represents a ripple wave created after clicking in a point of the screen
 *
 * Created by tenpines on 02/11/15.
 */
interface RippleWave {
    fun position(): Vector2D
    fun size(): Vector2D

    /**
     * Indicates if this ripple has no more activity
     */
    val isDead: Boolean

    companion object {
        fun create(position: Vector2D, lifeSpan: TimeQuantity, worldClock: WorldClock): RippleWave {
            return RippleWaveImpl(position, lifeSpan, worldClock)
        }
    }
}