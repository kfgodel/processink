package info.kfgodel.processink.demos.ripple

import info.kfgodel.mathe.api.Vector2D

/**
 * This type represents the model of the world represented for ripple wave clicks
 *
 * Created by tenpines on 03/11/15.
 */
interface RippleWorld {
    /**
     * The current active ripple waves
     */
    fun ripples(): List<RippleWave>

    /**
     * It indicates to this world that a new click has been done
     * @param mousePosition The position where the click happened
     */
    fun mouseClickedOn(mousePosition: Vector2D)

    /**
     * @return How much time do ripples last
     */
    fun rippleLifespan(): TimeQuantity

    /**
     * Cleans the dead ripples from the list
     */
    fun removeDeadRipples()

    companion object {
        fun create(clock: WorldClock): RippleWorld {
            return RippleWorldImpl(clock)
        }
    }
}