package info.kfgodel.processink.demos.conway.world

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.api.ext.vector.x
import info.kfgodel.processink.api.ext.vector.y

/**
 * Implementation of the field of view
 * Created by kfgodel on 14/11/15.
 */
class DefaultFieldOfView(private val topLeft: Vector2D, private val bottomRight: Vector2D) : FieldOfView {
  override fun topLeft() = topLeft
  override fun bottomRight() = bottomRight

  override fun size(): Vector2D {
    return bottomRight.minus(topLeft)
  }

  override fun includes(position: Vector2D): Boolean {
    return (
      topLeft.x() <= position.x() && bottomRight.x() >= position.x() &&
      topLeft.y() <= position.y() && bottomRight.y() >= position.y()
    )
  }

  override fun makeRelative(absolute: Vector2D): Vector2D {
    return absolute - topLeft
  }

}