package info.kfgodel.processink.demos.conway.world

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.ext.x
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * Date: 24/5/20 - 19:53
 */
@RunWith(JavaSpecRunner::class)
class FieldOfViewTest : KotlinSpec() {
  override fun define() {
    describe("a field of view") {
      val view by let { DefaultFieldOfView(-10 x -10, 10 x 10) }

      it("size is calculated from its corners") {
        assertThat(view().size()).isEqualTo(20 x 20)
      }

      it("makes absolute positions relative to its top left corner") {
        assertThat(view().makeRelative(0 x 0)).isEqualTo(10 x 10)
      }

      it("can indicate if a position is inside its view area") {
        assertThat(view().includes(-11 x -11)).isFalse()
        assertThat(view().includes(-10 x -11)).isFalse()
        assertThat(view().includes(10 x -11)).isFalse()
        assertThat(view().includes(11 x -11)).isFalse()

        assertThat(view().includes(-11 x -10)).isFalse()
        assertThat(view().includes(-10 x -10)).isTrue()
        assertThat(view().includes(10 x -10)).isTrue()
        assertThat(view().includes(11 x -10)).isFalse()

        assertThat(view().includes(-11 x 10)).isFalse()
        assertThat(view().includes(-10 x 10)).isTrue()
        assertThat(view().includes(10 x 10)).isTrue()
        assertThat(view().includes(11 x 10)).isFalse()

        assertThat(view().includes(-11 x 11)).isFalse()
        assertThat(view().includes(-10 x 11)).isFalse()
        assertThat(view().includes(10 x 11)).isFalse()
        assertThat(view().includes(11 x 11)).isFalse()
      }

    }
  }
}