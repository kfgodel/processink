package info.kfgodel.processink.demos.conway.states

/**
 * Created by tenpines on 14/11/15.
 */
class SurvivingState : CellState {
    override fun whenSurviving(action: Runnable) {
        action.run()
    }

    override fun whenDying(action: Runnable) {
        // Do nothing
    }

    override fun whenEmerging(action: Runnable) {
        // Do nothing
    }

    companion object {
        val INSTANCE = SurvivingState()
    }
}