package info.kfgodel.processink.impl.events

import info.kfgodel.processink.api.events.MouseEvent

/**
 * This class wraps the processing mouse event into an object to extend its functionality
 * and remove nullable types
 *
 * Date: 6/6/20 - 17:22
 */
inline class DefaultMouseEvent(private val originalEvent: processing.event.MouseEvent) : MouseEvent {
}