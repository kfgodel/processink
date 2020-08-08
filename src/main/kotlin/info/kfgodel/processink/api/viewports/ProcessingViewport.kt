package info.kfgodel.processink.api.viewports

import info.kfgodel.processink.api.extended.ProcessinkSettings

/**
 * This interface represents a configuration for the display area in which the sketch will be rendered.
 * By using instances of this type a sketch size and renderer settings can be defined.
 *
 * Date: 22/5/20 - 00:16
 */
interface ProcessingViewport : (ProcessinkSettings) -> Unit {
}