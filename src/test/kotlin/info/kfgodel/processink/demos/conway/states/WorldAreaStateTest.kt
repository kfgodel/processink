package info.kfgodel.processink.demos.conway.states

import com.google.common.collect.Sets
import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.api.ext.x
import info.kfgodel.processink.demos.conway.world.FieldOfView
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * Date: 24/5/20 - 00:35
 */
@RunWith(JavaSpecRunner::class)
class WorldAreaStateTest : KotlinSpec() {
  override fun define() {
    describe("an area state") {
      val fieldOfView by let { mockk<FieldOfView>(relaxed = true) }
      val currentCells by let { HashSet<Vector2D>() }
      val previousCells by let { HashSet<Vector2D>() }
      val areaState by let { DefaultWorldAreaState(fieldOfView(), previousCells(), currentCells()) }

      describe("cellState") {
        val cellStates by let { areaState().activeCellStates() }
        beforeEach {
          every { fieldOfView().includes(any()) } returns true
        }
        it("becomes emerging if the cell is present in current living set but not on previous") {
          currentCells { Sets.newHashSet(1.0 x 2.0) }
          val cellState: CellState? = cellStates().get(1.0 x 2.0)
          assertThat(cellState).isEqualTo(CellState.EMERGING)
        }
        it("is dying if it's absent in current, and present in previous") {
          previousCells { Sets.newHashSet(1.0 x 2.0) }
          val cellState: CellState? = cellStates().get(1.0 x 2.0)
          assertThat(cellState).isEqualTo(CellState.DYING)
        }
        it("is surviving if it's present in current and previous") {
          currentCells { Sets.newHashSet(1.0 x 2.0) }
          previousCells { Sets.newHashSet(1.0 x 2.0) }
          val cellState: CellState? = cellStates().get(1.0 x 2.0)
          assertThat(cellState).isEqualTo(CellState.SURVIVING)
        }
        it("excludes cells outside the fieldOfView") {
          currentCells { Sets.newHashSet(1.0 x 2.0) }
          previousCells { Sets.newHashSet(1.0 x 2.0) }
          every { fieldOfView().includes(any()) } returns false
          assertThat(cellStates()).isEmpty()
        }
      }
    }
  }
}