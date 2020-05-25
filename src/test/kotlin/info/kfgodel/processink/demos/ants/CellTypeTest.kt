package info.kfgodel.processink.demos.ants

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.ext.x
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * Date: 23/5/20 - 23:29
 */
@RunWith(JavaSpecRunner::class)
class CellTypeTest : KotlinSpec() {
  override fun define() {
    describe("a cell type") {

      describe("values") {
        it("can be black or white") {
          assertThat(CellType.values()).containsExactly(CellType.WHITE, CellType.BLACK)
        }
      }

      describe("turnAnt") {
        val ant by let { AntImpl(0 x 0, 0 x 1) }
        it("turns the ant left if black") {
          CellType.BLACK.turnAnt(ant())
          assertThat(ant().direction()).isEqualTo(1 x 0)
        }
        it("turns the ant right if white") {
          CellType.WHITE.turnAnt(ant())
          assertThat(ant().direction()).isEqualTo(-1 x 0)
        }
      }

    }
  }
}