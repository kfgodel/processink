package info.kfgodel.processink.demos.ants

import info.kfgodel.mathe.api.Vector2D

/**
 * This type represents the ant moving in langston ant world
 * Created by tenpines on 04/11/15.
 */
interface Ant {
  fun position(): Vector2D
  fun direction(): Vector2D
  fun turnLeft()
  fun turnRight()
  fun advance()

  /**
   * The position the ant will occupy if advanced
   */
  fun nextPosition(): Vector2D

  companion object {
    fun create(initialPosition: Vector2D, initialDirection: Vector2D): Ant {
      return AntImpl(initialPosition, initialDirection)
    }
  }
}