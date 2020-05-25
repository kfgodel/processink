package info.kfgodel.processink.demos.ants

import info.kfgodel.mathe.api.Vector2D


/**
 * This type represents the simulation world of langston ants
 * Created by tenpines on 04/11/15.
 */
interface AntWorld {
  /**
   * Changes the state of this world advancing on time unit
   */
  fun advanceOneTimeUnit()

  /**
   * @return The cell coordinates for the black spaces
   */
  fun blackCells(): Set<Vector2D>

  /**
   * @return The cell coordinate of the ant
   */
  fun ant(): Ant

  /**
   * @return Amount of horizontal and vertical cell (x, y)
   */
  fun cellSpace(): Vector2D
  fun setBlackCellOn(cellCoordinate: Vector2D)
  fun replaceAntWith(newAnt: Ant)

  companion object {
    fun create(cellSpace: Vector2D): AntWorld {
      return AntWorldImpl(cellSpace)
    }
  }
}