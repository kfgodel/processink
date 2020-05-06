package info.kfgodel.processink.demos.ball

import info.kfgodel.mathe.api.Vector1D
import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.impl.V1
import info.kfgodel.mathe.impl.V2
import info.kfgodel.processink.api.ext.vector.x
import info.kfgodel.processink.api.ext.vector.y

/**
 * Implementation of the bouncing ball
 * Created by tenpines on 30/10/15.
 */
class BouncingBallImpl(
  private var position: Vector2D,
  private var velocity: Vector2D,
  private var radius: Vector1D
) : BouncingBall {

  override fun velocity(): Vector2D {
    return velocity
  }

  override fun position(): Vector2D {
    return position
  }

  override fun radius(): Vector1D {
    return radius
  }

  override fun move() {
    var futurePosition: Vector2D = position + velocity
    if (futurePosition.x() + radius > V1.ONE) {
      velocity = velocity() * invertX()
      futurePosition = V2(V1.ONE - radius, futurePosition.y())
    } else if (futurePosition.x() - radius < V1.ZERO) {
      velocity = velocity() * invertX()
      futurePosition = V2(V1.ZERO + radius, futurePosition.y())
    }
    if (futurePosition.y() + radius > V1.ONE) {
      velocity = velocity() * invertY()
      futurePosition = V2(futurePosition.x(), V1.ONE - radius)
    } else if (futurePosition.y() - radius < V1.ZERO) {
      velocity = velocity() * invertY()
      futurePosition = V2(futurePosition.x(), V1.ZERO.plus(radius))
    }
    positionOn(futurePosition)
  }

  private fun invertY() = V2(1, -1)
  private fun invertX() = V2(-1, 1)

  override fun positionOn(newPosition: Vector2D) {
    this.position = newPosition
  }

  override fun rightSide(): Vector1D {
    return position.x() + radius
  }

  override fun leftSide(): Vector1D {
    return position.x() - radius
  }

  override fun bottomSide(): Vector1D {
    return position.y() + radius
  }

  override fun topSide(): Vector1D {
    return position.y() - radius
  }

  override fun diameter(): Vector1D {
    return radius() * 2
  }

}