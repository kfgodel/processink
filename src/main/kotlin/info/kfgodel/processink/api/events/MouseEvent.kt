package info.kfgodel.processink.api.events

import info.kfgodel.mathe.api.Vector2D

/**
 * This interface represents a processink mouse event
 * Date: 6/6/20 - 17:06
 */
interface MouseEvent {
  /**
   * The 2d position relative to the sketch where this event happened
   */
  val position: Vector2D
}