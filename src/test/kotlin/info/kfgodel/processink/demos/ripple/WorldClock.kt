package info.kfgodel.processink.demos.ripple

/**
 * This type represents the clock that keeps track of time for the simulated world
 * Created by tenpines on 02/11/15.
 */
interface WorldClock {
    /**
     * Answers the current timestamp as a millisecond value
     * @return The current millisecond reference
     */
    fun currentMillis(): Long
}