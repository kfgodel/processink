package info.kfgodel.processink.demos.conway.camera

import info.kfgodel.mathe.api.Vector2D

/**
 * This type represents a piece of the conway space in a certain moment
 *
 * Created by kfgodel on 14/11/15.
 */
interface Snapshot {
    /**
     * @return The positions relative to this snapshot that contains living cells from previous generation
     */
    fun survivingCells(): List<Vector2D>

    /**
     * @return The positions relative to this snapshot that contains cells dying in this generation
     */
    fun dyingCells(): List<Vector2D>

    /**
     * @return The positions relative to this snapshot that contains cells appearing in this generation
     */
    fun emergingCells(): List<Vector2D>

    /**
     * @return The cell size of this snapshot
     */
    fun dimension(): Vector2D

}