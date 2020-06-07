package info.kfgodel.processink.demos.ripple

import info.kfgodel.mathe.api.Vector2D

/**
 * Created by tenpines on 02/11/15.
 */
class RippleWaveImpl(
  private val position: Vector2D,
  private val lifeSpan: TimeQuantity,
  private val clock: WorldClock
) : RippleWave {

  private val startTime: Long = clock.currentMillis()

  override fun position(): Vector2D {
    return position
  }

  override fun radius(): Float {
    val maxRadius = 200.0f
    val lifeRatio = elapsedMillis() / lifeSpan.toMillis().toFloat()
    return maxRadius * lifeRatio
  }

  override val isDead: Boolean
    get() = elapsedMillis() > lifeSpan.toMillis()

  /**
   * Amount of milliseconds elapsed since this ripple creation
   * @return The amount of milliseconds since start
   */
  private fun elapsedMillis(): Long {
    return clock.currentMillis() - startTime
  }

}