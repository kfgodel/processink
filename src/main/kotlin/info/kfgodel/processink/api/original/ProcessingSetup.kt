package info.kfgodel.processink.api.original

/**
 * This type represents the Processing API available when defining the sketch setup.<br>
 * After settings have been defined, setup allows more actions to be done
 * Date: 2/5/20 - 21:13
 */
interface ProcessingSetup : ProcessingSettings {

  /**
   * Default behavior implemented by Processing to define the setup code
   */
  fun defaultSetup()

  // Add methods available on setup
}