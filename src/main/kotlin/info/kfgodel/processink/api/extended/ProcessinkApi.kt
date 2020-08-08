package info.kfgodel.processink.api.extended

/**
 * This type represents the API processink extends from the Processing original API adding new ways of doing things
 * and adapting them to Kotlin.
 * <br>
 * Because this doesn't replace the original API, an applet() method is available to access it. You will probably
 * need it when trying to skip abstraction layers added by Processink
 *
 * Date: 2/5/20 - 19:34
 */
interface ProcessinkApi :
  AppletWrapper,
  ProcessinkSettings,
  ProcessinkSetup,
  ProcessinkCanvas