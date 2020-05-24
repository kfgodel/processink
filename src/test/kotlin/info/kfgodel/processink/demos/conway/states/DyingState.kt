package info.kfgodel.processink.demos.conway.states

/**
 * Created by tenpines on 14/11/15.
 */
class DyingState : CellState {
    override fun whenSurviving(action: Runnable) {
        // Do nothing
    }

    override fun whenDying(action: Runnable) {
        action.run()
    }

    override fun whenEmerging(action: Runnable) {
        //Do nothing
    }

    companion object {
        val INSTANCE = DyingState()
    }
}