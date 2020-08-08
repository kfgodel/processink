package info.kfgodel.processink.api.extended

import info.kfgodel.processink.impl.ProcessingApplet

/**
 * This type applies to all the api type that are wrappers around the Processing PApplet class
 * Date: 2/5/20 - 20:23
 */
interface AppletWrapper {
  /**
   * Allows access to the original processing applet where all the methods are available.<br>
   * <br>
   * Dev note: By returning a concrete applet class we ensure that whatever method added by Processing will be available
   * even if Processink didn't included it yet
   */
  fun applet(): ProcessingApplet
}