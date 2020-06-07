package info.kfgodel.processink.demos.ripple

import java.util.concurrent.TimeUnit

/**
 * This type represents a time measure (number and unit)
 * Created by tenpines on 31/10/15.
 */
interface TimeQuantity {
    fun amount(): Int
    fun unit(): TimeUnit

    /**
     * This quantity measured in milliseconds
     */
    fun toMillis(): Long

    companion object {
        fun of(value: Int, unit: TimeUnit): TimeQuantity {
            return TimeQuantityImpl(value, unit)
        }
    }
}