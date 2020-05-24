package info.kfgodel.processink.demos.ball

import info.kfgodel.mathe.api.Vector1D
import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.impl.V1
import info.kfgodel.mathe.impl.V2

/**
 * This type represents a bouncing ball that moves between a square space of [0,1],[0,1]
 * with a given velocity, bouncing back from each wall
 * Created by kfgodel on 30/10/15.
 */
interface BouncingBall {
  /**
   * Velocity of this ball
   */
  fun velocity(): Vector2D

  /**
   * Current position of the ball
   */
  fun position(): Vector2D

  /**
   * Size of the ball indicated as radius
   */
  fun radius(): Vector1D

  /**
   * Moves this ball one position according to velocity
   */
  fun move()

  /**
   * Changes the position of the ball to the given position
   */
  fun positionOn(newPosition: Vector2D)
  fun rightSide(): Vector1D
  fun leftSide(): Vector1D
  fun bottomSide(): Vector1D
  fun topSide(): Vector1D

  /**
   * @return The ball diameter (double of the radius)
   */
  fun diameter(): Vector1D

  companion object {
    /**
     * Creates a default bouncing ball centered in the space, with a default velocity
     * @return The created ball
     */
    fun createDefault(): BouncingBall {
      return BouncingBallImpl(defaultPosition(), V2(0.02, 0.01), defaultRadius())
    }

    fun withVelocity(velocity: Vector2D): BouncingBall {
      return BouncingBallImpl(defaultPosition(), velocity, defaultRadius())
    }

    fun defaultRadius(): Vector1D {
      return V1(0.03)
    }

    fun defaultPosition(): Vector2D {
      return V2(0.5, 0.5)
    }
  }
}