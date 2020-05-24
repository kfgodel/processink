package info.kfgodel.processink.demos.conway.states

/**
 * This type represents the state of a cell
 * Created by tenpines on 14/11/15.
 */
interface CellState {
    fun whenSurviving(action: Runnable)
    fun whenDying(action: Runnable)
    fun whenEmerging(action: Runnable)

    companion object {
        fun surviving(): CellState {
            return SurvivingState.Companion.INSTANCE
        }

        fun dying(): CellState {
            return DyingState.Companion.INSTANCE
        }

        fun emerging(): CellState {
            return EmergingState.Companion.INSTANCE
        }
    }
}