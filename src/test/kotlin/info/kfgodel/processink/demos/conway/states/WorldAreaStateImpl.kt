package info.kfgodel.processink.demos.conway.states

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.demos.conway.world.FieldOfView
import java.util.function.Consumer
import java.util.function.Predicate

/**
 * Created by tenpines on 14/11/15.
 */
class WorldAreaStateImpl : WorldAreaState {
    private var fieldOfView: FieldOfView? = null
    private var previousLivingCells: Set<Vector2D>? = null
    private var currentLivingCells: Set<Vector2D>? = null
    override fun dimension(): Vector2D? {
        return fieldOfView!!.dimension()
    }

    override fun activeCellStates(): Map<Vector2D, CellState> {
        val statePerPosition: MutableMap<Vector2D, CellState> = HashMap<Vector2D, CellState>()
        previousLivingCells!!.stream()
                .filter(Predicate<Vector2D> { position: Vector2D -> fieldOfView!!.includes(position) })
                .filter(Predicate<Vector2D> { o: Vector2D -> currentLivingCells!!.contains(o) })
                .forEach(Consumer<Vector2D> { survivingPosition: Vector2D -> statePerPosition[survivingPosition] = CellState.Companion.surviving() })
        previousLivingCells!!.stream()
                .filter(Predicate<Vector2D> { position: Vector2D -> fieldOfView!!.includes(position) })
                .filter(Predicate<Vector2D> { dyingPosition: Vector2D -> !currentLivingCells!!.contains(dyingPosition) })
                .forEach(Consumer<Vector2D> { dyingPosition: Vector2D -> statePerPosition[dyingPosition] = CellState.Companion.dying() })
        currentLivingCells!!.stream()
                .filter(Predicate<Vector2D> { position: Vector2D -> fieldOfView!!.includes(position) })
                .filter(Predicate<Vector2D> { emergingPosition: Vector2D -> !previousLivingCells!!.contains(emergingPosition) })
                .forEach(Consumer<Vector2D> { emergingPosition: Vector2D -> statePerPosition[emergingPosition] = CellState.Companion.emerging() })
        return statePerPosition
    }

    override fun makeRelative(absolute: Vector2D): Vector2D? {
        return fieldOfView!!.makeRelative(absolute)
    }

    companion object {
        fun create(fieldOfView: FieldOfView?, previousLivingCells: Set<Vector2D>?, currentLivingCells: Set<Vector2D>?): WorldAreaStateImpl {
            val state = WorldAreaStateImpl()
            state.fieldOfView = fieldOfView
            state.previousLivingCells = previousLivingCells
            state.currentLivingCells = currentLivingCells
            return state
        }
    }
}