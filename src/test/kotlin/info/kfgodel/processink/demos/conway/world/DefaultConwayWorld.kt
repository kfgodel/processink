package info.kfgodel.processink.demos.conway.world

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.demos.conway.gener.NextGenerationCalculator
import info.kfgodel.processink.demos.conway.states.DefaultWorldAreaState
import info.kfgodel.processink.demos.conway.states.WorldAreaState
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

/**
 * Implementation of the conway game
 * Created by kfgodel on 14/11/15.
 */
class DefaultConwayWorld(survivingCells: Set<Vector2D>) : ConwayWorld {
  private var currentLivingCells = survivingCells
  private var previousLivingCells = survivingCells
  private var stateLock = ReentrantLock()

  override fun advanceOneGeneration() {
    val nextLivingCells = calculateNextGeneration()
    stateLock.withLock {
      previousLivingCells = currentLivingCells
      currentLivingCells = nextLivingCells
    }
  }

  private fun calculateNextGeneration(): Set<Vector2D> {
    // This is a read operation, so no mutation is made to the living cell set
    return NextGenerationCalculator(currentLivingCells).calculate()
  }

  override fun getStateInside(view: FieldOfView): WorldAreaState {
    return stateLock.withLock {
      // read only, doesn't change set contents
      DefaultWorldAreaState(view, previousLivingCells, currentLivingCells)
    }
  }

}