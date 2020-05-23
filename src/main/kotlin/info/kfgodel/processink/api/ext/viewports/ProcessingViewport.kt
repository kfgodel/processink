package info.kfgodel.processink.api.ext.viewports

import info.kfgodel.processink.api.original.ProcessingSettings

/**
 * This interface represents a configuration for the display area in which the sketch will be rendered.
 * By using instances of this type a sketch size and renderer settings can be defined.
 *
 * Date: 22/5/20 - 00:16
 */
interface ProcessingViewport : (ProcessingSettings) -> Unit {
}