package info.kfgodel.processink.demos.conway.world

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.ext.x
import info.kfgodel.processink.demos.conway.states.CellState
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * Date: 23/5/20 - 23:29
 */
@RunWith(JavaSpecRunner::class)
class ConwayWorldTest : KotlinSpec() {
  override fun define() {
    describe("a conway world") {
      val initialCells by let { arrayOf(
        2.0 x -1.0,
        -1.0 x 0.0, 0.0 x 0.0, 1.0 x 0.0, 2.0 x 0.0,
        2.0 x 1.0
      )}
      val conwayWorld by let { ConwayWorld.create(*initialCells()) }

      val cellStates by let {
        conwayWorld()
          .getStateInside(DefaultFieldOfView(-10.0 x -10.0, 10.0 x 10.0))
          .activeCellStates()
      }

      it("starts with the given surviving cells") {
        assertThat(cellStates().get(2.0 x -1.0)).isEqualTo(CellState.SURVIVING)
        assertThat(cellStates().get(-1.0 x 0.0)).isEqualTo(CellState.SURVIVING)
        assertThat(cellStates().get(0.0 x 0.0)).isEqualTo(CellState.SURVIVING)
        assertThat(cellStates().get(1.0 x 0.0)).isEqualTo(CellState.SURVIVING)
        assertThat(cellStates().get(2.0 x 0.0)).isEqualTo(CellState.SURVIVING)
        assertThat(cellStates().get(2.0 x 1.0)).isEqualTo(CellState.SURVIVING)
      }

      describe("when the generation changes") {
        beforeEach {
          conwayWorld().advanceOneGeneration()
        }

        it("kills the cells with less than 2 live neighbors") {
          assertThat(cellStates().get(-1.0 x 0.0)).isEqualTo(CellState.DYING)
        }
        it("keeps cells alive with 2 or 3 live neighbors") {
          assertThat(cellStates().get(2.0 x -1.0)).isEqualTo(CellState.SURVIVING)
          assertThat(cellStates().get(0.0 x 0.0)).isEqualTo(CellState.SURVIVING)
          assertThat(cellStates().get(2.0 x 0.0)).isEqualTo(CellState.SURVIVING)
          assertThat(cellStates().get(2.0 x 1.0)).isEqualTo(CellState.SURVIVING)
        }
        it("kills cells with more than 3 live neighbors") {
          assertThat(cellStates().get(1.0 x 0.0)).isEqualTo(CellState.DYING)
        }
        it("revives cells with exactly 3 live neighbors") {
          assertThat(cellStates().get(0.0 x -1.0)).isEqualTo(CellState.EMERGING)
          assertThat(cellStates().get(3.0 x 0.0)).isEqualTo(CellState.EMERGING)
          assertThat(cellStates().get(0.0 x 1.0)).isEqualTo(CellState.EMERGING)
        }
      }

    }
  }
}