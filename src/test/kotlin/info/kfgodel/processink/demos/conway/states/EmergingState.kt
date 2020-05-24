package info.kfgodel.processink.demos.conway.states

/**
 * Created by tenpines on 14/11/15.
 */
class EmergingState : CellState {
    override fun whenSurviving(action: Runnable) {
        // Do nothing
    }

    override fun whenDying(action: Runnable) {
        // Do nothing
    }

    override fun whenEmerging(action: Runnable) {
        action.run()
    }

    companion object {
        val INSTANCE = EmergingState()
    }
}