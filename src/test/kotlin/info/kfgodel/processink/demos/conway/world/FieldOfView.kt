package info.kfgodel.processink.demos.conway.world

import info.kfgodel.mathe.api.Vector2D

/**
 * This type represents a segment of the conways world that is observable by a camera
 * Created by kfgodel on 14/11/15.
 */
interface FieldOfView {

  /**
   * Returns the size of the area contained in this view
   */
  fun size(): Vector2D

  /**
   * Indicates if this view includes the given position
   */
  fun includes(position: Vector2D): Boolean

  /**
   * Makes an absolute world position relative to this view
   */
  fun makeRelative(absolute: Vector2D): Vector2D

  fun topLeft(): Vector2D
  fun bottomRight(): Vector2D

}