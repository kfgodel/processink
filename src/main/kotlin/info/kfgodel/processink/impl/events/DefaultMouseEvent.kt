package info.kfgodel.processink.impl.events

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.api.ext.x
import info.kfgodel.processink.api.events.MouseEvent

/**
 * This class wraps the processing mouse event into an object to extend its functionality
 * and remove nullable types
 *
 * Date: 6/6/20 - 17:22
 */
inline class DefaultMouseEvent(private val originalEvent: processing.event.MouseEvent) : MouseEvent {
  override val position: Vector2D
    get() = originalEvent.x x originalEvent.y
}