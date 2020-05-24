package info.kfgodel.processink.demos.conway.world

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.demos.conway.states.WorldAreaState
import java.util.*
import kotlin.collections.HashSet

/**
 * This type represents the infinite space of cells for conway's game of life
 * Created by tenpines on 14/11/15.
 */
interface ConwayWorld {
    /**
     * Changes the state of the conway world advancing one generation
     */
    fun advanceOneGeneration()

    /**
     * Returns the state of every active cell contained in the given segment.<br></br>
     * The dead cells are omitted
     * @param segment The 2d space segment to look for
     * @return The position and state of every cell
     */
    fun getStateInside(segment: FieldOfView?): WorldAreaState

    companion object {
        fun create(vararg survivingCells: Vector2D): ConwayWorld {
            return ConwayWorldImpl.create(HashSet(Arrays.asList(*survivingCells)))
        }
    }
}