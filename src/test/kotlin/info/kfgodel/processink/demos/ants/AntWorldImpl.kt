package info.kfgodel.processink.demos.ants

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.api.ext.x
import info.kfgodel.mathe.impl.V1
import info.kfgodel.processink.api.ext.vector.x
import info.kfgodel.processink.api.ext.vector.y
import info.kfgodel.processink.demos.ants.ext.integered
import info.kfgodel.processink.demos.ants.interval.BidiInterval
import info.kfgodel.processink.demos.ants.interval.Interval.Companion.intervalInclusiveExclusive
import java.util.concurrent.CopyOnWriteArraySet
import java.util.function.BiConsumer

/**
 * This type implements the ant world
 * Created by tenpines on 04/11/15.
 */
class AntWorldImpl(private val cellSpace: Vector2D) : AntWorld {
  private val cellInterval = BidiInterval.from(
    intervalInclusiveExclusive(V1.ZERO, cellSpace.x()),
    intervalInclusiveExclusive(V1.ZERO, cellSpace.y())
  )
  private var ant = Ant.create(cellSpace.scaledBy(0.5).integered(), 0 x -1)
  private val blackCells = CopyOnWriteArraySet<Vector2D>()

  override fun advanceOneTimeUnit() {
    val steppedType = cellTypeUnderAnt()
    steppedType.turnAnt(ant)
    if (antCanMove()) {
      flipCellType()
      ant.advance()
    }
  }

  private fun cellTypeUnderAnt(): CellType {
    return if (ant.position() in blackCells) CellType.BLACK else CellType.WHITE
  }

  private fun flipCellType() {
    val steppedType = cellTypeUnderAnt()
    val flipOperation: BiConsumer<MutableSet<Vector2D>, Vector2D> = steppedType.getFlipOperation()
    flipOperation.accept(blackCells, ant.position())
  }

  private fun antCanMove(): Boolean {
    val nextPosition: Vector2D = ant().nextPosition()
    return cellInterval.contains(nextPosition)
  }

  override fun blackCells(): Set<Vector2D> {
    return blackCells
  }

  override fun ant(): Ant {
    return ant
  }

  override fun cellSpace(): Vector2D {
    return cellSpace
  }

  override fun setBlackCellOn(cellCoordinate: Vector2D) {
    blackCells.add(cellCoordinate)
  }

  override fun replaceAntWith(newAnt: Ant) {
    this.ant = newAnt
  }

}