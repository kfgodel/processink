package info.kfgodel.processink.demos.conway.camera

import info.kfgodel.mathe.api.Vector2D

/**
 * This type implements the snapshot of a conways world
 * Created by kfgodel on 14/11/15.
 */
class DefaultSnapshot(
  private val dimension: Vector2D,
  private val survivingCells: List<Vector2D>,
  private val dyingCells: List<Vector2D>,
  private val emergingCells: List<Vector2D>
) : Snapshot {

  override fun survivingCells(): List<Vector2D> {
    return survivingCells
  }

  override fun dyingCells(): List<Vector2D> {
    return dyingCells
  }

  override fun emergingCells(): List<Vector2D> {
    return emergingCells
  }

  override fun dimension(): Vector2D {
    return dimension
  }
}