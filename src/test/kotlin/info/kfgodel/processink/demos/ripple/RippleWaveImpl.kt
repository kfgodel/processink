package info.kfgodel.processink.demos.ripple

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.api.ext.x

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

  override fun size(): Vector2D {
    val maxRadius = 200.0f
    val lifeRatio = elapsedMillis() / lifeSpan.toMillis().toFloat()
    val currentRadius = maxRadius * lifeRatio
    return currentRadius x currentRadius
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