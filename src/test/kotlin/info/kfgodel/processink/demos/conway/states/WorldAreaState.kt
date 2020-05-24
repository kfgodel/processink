package info.kfgodel.processink.demos.conway.states

import info.kfgodel.mathe.api.Vector2D

/**
 * This type represents a portion of the conway space
 * Created by kfgodel on 14/11/15.
 */
interface WorldAreaState {
    /**
     * @return Each of the associated states for non dead cells
     */
    fun activeCellStates(): Map<Vector2D, CellState>
}