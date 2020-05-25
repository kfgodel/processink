package info.kfgodel.processink.demos.ants

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.demos.ants.ext.integered
import info.kfgodel.processink.demos.ants.ext.rotate

/**
 * Created by kfgodel on 04/11/15.
 */
class AntImpl(initialPosition: Vector2D, initialDirection: Vector2D) : Ant {
  private var position: Vector2D = initialPosition
  private var direction: Vector2D = initialDirection

  override fun position(): Vector2D {
    return position.integered()
  }

  override fun direction(): Vector2D {
    return direction.integered()
  }

  override fun turnLeft() {
    direction = direction.rotate(-90.0)
  }

  override fun turnRight() {
    direction = direction.rotate(90.0)
  }

  override fun advance() {
    position = nextPosition()
  }

  override fun nextPosition(): Vector2D {
    return position.plus(direction)
  }

}