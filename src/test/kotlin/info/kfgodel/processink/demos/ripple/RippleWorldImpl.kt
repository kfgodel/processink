package info.kfgodel.processink.demos.ripple

import info.kfgodel.mathe.api.Vector2D
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.TimeUnit

/**
 * This implements the demo world for mouse click ripples
 * Created by tenpines on 03/11/15.
 */
class RippleWorldImpl(private val clock: WorldClock) : RippleWorld {
  private val waves = CopyOnWriteArrayList<RippleWave>()

  override fun ripples(): List<RippleWave> {
    return waves
  }

  override fun createRippleOn(mousePosition: Vector2D) {
    waves.add(RippleWave.create(mousePosition, rippleLifespan(), clock))
  }

  override fun rippleLifespan(): TimeQuantity {
    return TimeQuantity.of(2, TimeUnit.SECONDS)
  }

  override fun removeDeadRipples() {
    waves.removeIf { ripple -> ripple.isDead }
  }

}