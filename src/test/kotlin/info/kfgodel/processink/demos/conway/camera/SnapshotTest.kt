package info.kfgodel.processink.demos.conway.camera

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.api.ext.x
import info.kfgodel.processink.demos.conway.states.CellState
import info.kfgodel.processink.demos.conway.states.WorldAreaState
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * Date: 23/5/20 - 23:29
 */
@RunWith(JavaSpecRunner::class)
class SnapshotTest : KotlinSpec() {
  override fun define() {
    describe("a snapshot") {
      val areaState by let { mockk<WorldAreaState>(relaxed = true) }
      val snapshot by let { Snapshot.create(areaState()) }

      it("has the dimension of the area") {
        every { areaState().dimension() } returns (2.0 x 3.0)
        assertThat(snapshot().dimension()).isEqualTo(2.0 x 3.0)
      }

      describe("when the area has all dead cells") {
        beforeEach {
          every { areaState().activeCellStates() } returns emptyMap()
        }
        it("has no surviving cells") {
          assertThat(snapshot().survivingCells()).isEmpty()
        }
        it("has no dying cells") {
          assertThat(snapshot().dyingCells()).isEmpty()
        }
        it("has no emerging cells") {
          assertThat(snapshot().emergingCells()).isEmpty()
        }
      }

      describe("when the area has one of each type of cells") {
        beforeEach {
          val cellStates: MutableMap<Vector2D, CellState> = HashMap<Vector2D, CellState>()
          cellStates[1.0 x 1.0] = CellState.surviving()
          cellStates[2.0 x 2.0] = CellState.dying()
          cellStates[3.0 x 3.0] = CellState.emerging()
          every { areaState().activeCellStates() } returns cellStates
          every { areaState().makeRelative(any()) } returns (1.0 x 1.0) andThen (2.0 x 2.0) andThen (3.0 x 3.0)
        }
        it("has a surviving cell") {
          assertThat(snapshot().survivingCells().get(0)).isEqualTo(1.0 x 1.0)
        }
        it("has a dying cell") {
          assertThat(snapshot().dyingCells().get(0)).isEqualTo(2.0 x 2.0)
        }
        it("has a emerging cell") {
          assertThat(snapshot().emergingCells().get(0)).isEqualTo(3.0 x 3.0)
        }
      }

    }
  }
}