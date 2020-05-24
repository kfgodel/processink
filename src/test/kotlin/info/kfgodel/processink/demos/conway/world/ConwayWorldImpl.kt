package info.kfgodel.processink.demos.conway.world

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.demos.conway.gener.NextGenerationCalculator
import info.kfgodel.processink.demos.conway.states.WorldAreaState
import java.util.concurrent.locks.ReentrantLock

/**
 * Implementation of the conway game
 * Created by tenpines on 14/11/15.
 */
class ConwayWorldImpl : ConwayWorld {
    private var currentLivingCells: Set<Vector2D>? = null
    private var previousLivingCells: Set<Vector2D>? = null
    private var stateLock: ReentrantLock? = null
    override fun advanceOneGeneration() {
        val nextLivingCells: Set<Vector2D> = calculateNextGeneration()
        stateLock!!.lock()
        try {
            previousLivingCells = currentLivingCells
            currentLivingCells = nextLivingCells
        } finally {
            stateLock!!.unlock()
        }
    }

    private fun calculateNextGeneration(): Set<Vector2D> {
        return NextGenerationCalculator.create(currentLivingCells).calculate()
    }

    override fun getStateInside(segment: FieldOfView?): WorldAreaState {
        stateLock!!.lock()
        return try {
          WorldAreaState.create(segment, previousLivingCells, currentLivingCells)
        } finally {
            stateLock!!.unlock()
        }
    }

    companion object {
        fun create(survivingCells: Set<Vector2D>?): ConwayWorldImpl {
            val world = ConwayWorldImpl()
            world.currentLivingCells = survivingCells
            world.previousLivingCells = survivingCells
            world.stateLock = ReentrantLock()
            return world
        }
    }
}