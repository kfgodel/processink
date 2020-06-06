package info.kfgodel.processink.api.original

/**
 * This type represents the API that Processing offers to its users from its PApplet class.<br>
 * Processing instantiates this type to offer the user control over the expected behavior<br>
 * <br>
 * This is created to reference documentation and group related methods so it's easier to access than
 * the original PApplet protocol
 *
 * Date: 2/5/20 - 19:34
 */
interface ProcessingApi :
  AppletWrapper,
  ProcessingSettings,
  ProcessingSetup,
  ProcessingCanvas