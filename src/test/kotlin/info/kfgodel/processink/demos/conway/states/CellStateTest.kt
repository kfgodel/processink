package info.kfgodel.processink.demos.conway.states

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * Date: 23/5/20 - 23:29
 */
@RunWith(JavaSpecRunner::class)
class CellStateTest : KotlinSpec() {
  override fun define() {
    describe("a cell state") {
      
      it("can be one of 3 different states") {
        assertThat(CellState.surviving()).isNotEqualTo(CellState.dying())
        assertThat(CellState.surviving()).isNotEqualTo(CellState.emerging())
        assertThat(CellState.emerging()).isNotEqualTo(CellState.dying())
      }

      it("runs only the surviving action for the surviving state") {
        var emergingExecuted = false
        var dyingExecuted = false
        var survivingExecuted = false
        CellState.surviving().whenSurviving(Runnable { survivingExecuted = true })
        CellState.surviving().whenDying(Runnable { dyingExecuted = true })
        CellState.surviving().whenEmerging(Runnable { emergingExecuted = true })
        assertThat(survivingExecuted).isTrue()
        assertThat(dyingExecuted).isFalse()
        assertThat(emergingExecuted).isFalse()
      }

      it("runs only the dying action for the dying state") {
        var emergingExecuted = false
        var dyingExecuted = false
        var survivingExecuted = false
        CellState.dying().whenSurviving(Runnable { survivingExecuted = true })
        CellState.dying().whenDying(Runnable { dyingExecuted = true })
        CellState.dying().whenEmerging(Runnable { emergingExecuted = true })
        assertThat(survivingExecuted).isFalse()
        assertThat(dyingExecuted).isTrue()
        assertThat(emergingExecuted).isFalse()
      }

      it("runs only the emerging action for the emerging state") {
        var emergingExecuted = false
        var dyingExecuted = false
        var survivingExecuted = false
        CellState.emerging().whenSurviving(Runnable { survivingExecuted = true })
        CellState.emerging().whenDying(Runnable { dyingExecuted = true })
        CellState.emerging().whenEmerging(Runnable { emergingExecuted = true })
        assertThat(survivingExecuted).isFalse()
        assertThat(dyingExecuted).isFalse()
        assertThat(emergingExecuted).isTrue()
      }
    }
  }
}