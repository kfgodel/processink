package info.kfgodel.processink.api.original

import processing.core.PApplet

/**
 * This type applies to all the api type that are wrappers around the Processing PApplet class
 * Date: 2/5/20 - 20:23
 */
interface AppletWrapper {
  /**
   * Allows access to the original processing applet where all the methos are available
   */
  fun applet(): PApplet
}