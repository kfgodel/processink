package info.kfgodel.mathe.impl

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.Vector4D
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * This class verifies the expected behavior for a 4d float vector
 * Date: 23/5/20 - 00:00
 */
@RunWith(JavaSpecRunner::class)
class V4Test : KotlinSpec() {
  override fun define() {
    describe("a 4D float vector") {
      val vector by let { V4(0.1f, 0.2f, 0.3f, 0.4f) }

      describe("dimensions") {
        it("takes 3 float values as its dimensions") {
          assertThat(vector().component1()).isEqualTo(V1(0.1f))
          assertThat(vector().component2()).isEqualTo(V1(0.2f))
          assertThat(vector().component3()).isEqualTo(V1(0.3f))
          assertThat(vector().component4()).isEqualTo(V1(0.4f))
        }
        it("contains 4 components") {
          expectValues(vector(), arrayOf(0.1f, 0.2f, 0.3f, 0.4f))
        }
      }

      describe("alternate creation") {
        it("can be done with double values") {
          expectValues(V4(0.01, 0.02, 0.03, 0.04), arrayOf(0.01f, 0.02f, 0.03f, 0.04f))
        }
        it("can be done with integer values") {
          expectValues(V4(1, 2, 3, 4), arrayOf(1.0f, 2.0f, 3.0f, 4.0f))
        }
      }

      describe("with other 4d vector") {
        val other by let { V4(2, 3, 4, 5) }

        it("can be added") {
          val result = vector() + other()
          assertThat(result).isEqualTo(V4(2.1f, 3.2f, 4.3f, 5.4f))
        }
        it("can be subtracted") {
          val result = vector() - other()
          assertThat(result).isEqualTo(V4(-1.9f, -2.8f, -3.7f, -4.6f))
        }
        it("is multiplied using hadamard product") {
          val result = vector() * other()
          assertThat(result).isEqualTo(V4(0.2f, 0.6f, 1.2f, 2.0f))
        }
        it("is divided using hadamard division") {
          val result = vector() / other()
          assertThat(result).isEqualTo(V4(0.05f, 0.2f / 3, 0.3f / 4, 0.4f / 5))
        }
      }

      it("can be scaled by a 1d vector") {
        val result = vector().scaledBy(V1(2))
        assertThat(result).isEqualTo(V4(0.2f, 0.4f, 0.6f, 0.8f))
      }

      it("can be inverted") {
        expectValues(vector().invert(), arrayOf(-0.1f, -0.2f, -0.3f, -0.4f))
      }

    }
  }

  private fun expectValues(vector: Vector4D, expected: Array<Float>) {
    assertThat(vector.components()).containsExactly(V1(expected[0]), V1(expected[1]), V1(expected[2]), V1(expected[3]))
  }

}