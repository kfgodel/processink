package info.kfgodel.processink.demos.conway.states

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.demos.conway.world.FieldOfView

/**
 * This type represents a portion of the conway space
 * Created by tenpines on 14/11/15.
 */
interface WorldAreaState {
    /**
     * @return The width and height of this area
     */
    fun dimension(): Vector2D?

    /**
     * @return Each of the associated states for non dead cells
     */
    fun activeCellStates(): Map<Vector2D, CellState>

    /**
     * Makes the given world position relative to this area (taking the top lef corner as 0,0)
     * and the bottom right the positive infinities
     * @param absolute The absolute position
     * @return The relative to this area position
     */
    fun makeRelative(absolute: Vector2D): Vector2D?

    companion object {
        fun create(fieldOfView: FieldOfView?, previousLivingCells: Set<Vector2D>?, currentLivingCells: Set<Vector2D>?): WorldAreaState {
            return WorldAreaStateImpl.create(fieldOfView, previousLivingCells, currentLivingCells)
        }
    }
}