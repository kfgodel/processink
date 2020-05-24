package info.kfgodel.processink.demos.conway.camera

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.demos.conway.states.CellState
import info.kfgodel.processink.demos.conway.states.WorldAreaState
import java.util.*

/**
 * This type implements the snapshot of a conways world
 * Created by tenpines on 14/11/15.
 */
class SnapshotImpl : Snapshot {
    private var worldAreaState: WorldAreaState? = null
    private var survivingCells: MutableList<Vector2D?>? = null
    private var dyingCells: MutableList<Vector2D?>? = null
    private var emergingCells: MutableList<Vector2D?>? = null
    override fun survivingCells(): List<Vector2D?> {
        if (survivingCells == null) {
            classifyCellsbyState()
        }
        return survivingCells!!
    }

    override fun dyingCells(): List<Vector2D?> {
        if (dyingCells == null) {
            classifyCellsbyState()
        }
        return dyingCells!!
    }

    override fun emergingCells(): List<Vector2D?> {
        if (emergingCells == null) {
            classifyCellsbyState()
        }
        return emergingCells!!
    }

    override fun dimension(): Vector2D? {
        return worldAreaState!!.dimension()
    }

    private fun classifyCellsbyState() {
        survivingCells = ArrayList<Vector2D?>()
        dyingCells = ArrayList<Vector2D?>()
        emergingCells = ArrayList<Vector2D?>()
        val entries: Set<Map.Entry<Vector2D, CellState>> = worldAreaState!!.activeCellStates().entries
        for ((key, cellState) in entries) {
            val cellPosition: Vector2D? = worldAreaState!!.makeRelative(key)
            cellState.whenSurviving(Runnable { survivingCells!!.add(cellPosition) })
            cellState.whenDying(Runnable { dyingCells!!.add(cellPosition) })
            cellState.whenEmerging(Runnable{ emergingCells!!.add(cellPosition) })
        }
    }

    companion object {
        fun create(worldAreaState: WorldAreaState?): SnapshotImpl {
            val snapshot = SnapshotImpl()
            snapshot.worldAreaState = worldAreaState
            return snapshot
        }
    }
}