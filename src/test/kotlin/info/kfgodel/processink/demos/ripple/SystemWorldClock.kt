package info.kfgodel.processink.demos.ripple

/**
 * This type represents the world clock that uses the real system time
 * Created by tenpines on 02/11/15.
 */
class SystemWorldClock : WorldClock {
    override fun currentMillis() = System.currentTimeMillis()
}