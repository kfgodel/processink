package info.kfgodel.processink.demos.ripple

import java.util.concurrent.TimeUnit

/**
 * Implementation of time quantity
 * Created by tenpines on 31/10/15.
 */
class TimeQuantityImpl(private val amount: Int, private val unit: TimeUnit) : TimeQuantity {
    override fun amount(): Int {
        return amount
    }
    override fun unit(): TimeUnit {
        return unit
    }
    override fun toMillis(): Long {
        return unit.toMillis(amount.toLong())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TimeQuantity) return false
        return if (amount != other.amount()) false else unit === other.unit()
    }

    override fun hashCode(): Int {
        var result = amount
        result = 31 * result + unit.hashCode()
        return result
    }

}