package info.kfgodel.processink.demos.conway.gener

import info.kfgodel.mathe.api.Vector2D

/**
 * This type represents the rule processor of the conways world
 * Created by tenpines on 15/11/15.
 */
interface NextGenerationCalculator {
    fun calculate(): Set<Vector2D>

    companion object {
        fun create(livingCells: Set<Vector2D>?): NextGenerationCalculator {
            return NextGenerationCalculatorImpl.create(livingCells)
        }
    }
}