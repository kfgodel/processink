package info.kfgodel.processink.demos.conway.states

/**
 * This type represents the different states a cell can have in the game.
 * Date: 24/5/20 - 18:16
 */
enum class CellState {
  /**
   * Cell is alive and survived previous generation
   */
  SURVIVING,
  /**
   * Cell has died from previous generation
   */
  DYING,
  /**
   * Cell was dead and it's now alive
   */
  EMERGING;
}