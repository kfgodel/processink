package info.kfgodel.mathe.impl

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.impl.V1
import info.kfgodel.mathe.impl.V2
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * This class verifies the expected behavior for a 2d float vector
 * Date: 5/5/20 - 00:00
 */
@RunWith(JavaSpecRunner::class)
class V2Test : KotlinSpec() {
  override fun define() {
    describe("a 2D float vector") {
      val vector by let { V2(0.1f, 0.2f) }

      describe("dimensions") {
        it("takes two float values as the first and second dimensions") {
          assertThat(vector().component1()).isEqualTo(V1(0.1f))
          assertThat(vector().component2()).isEqualTo(V1(0.2f))
        }
        it("is 0 on other dimensions") {
          assertThat(vector().component3()).isEqualTo(V1.ZERO)
          assertThat(vector().component4()).isEqualTo(V1.ZERO)
        }
        it("contains only 2 components"){
          expectValues(vector(), Pair(0.1f, 0.2f))
        }
      }

      describe("alternate creation") {
        it("can be done with double values") {
          expectValues(V2(0.01, 0.05), Pair(0.01f, 0.05f))
        }
        it("can be done with integer values") {
          expectValues(V2(3, 4), Pair(3f, 4f))
        }
        it("can mix numbers and vectors") {
          expectValues(V2(V1(1), 2), Pair(1f, 2f))
          expectValues(V2(3.4, V1(5.6)), Pair(3.4f, 5.6f))
        }
      }

      describe("with other 2d vector") {
        val other by let { V2(2, 3) }

        it("can be added") {
          val result = vector() + other()
          assertThat(result).isEqualTo(V2(2.1f, 3.2f))
        }
        it("can be subtracted") {
          val result = vector() - other()
          assertThat(result).isEqualTo(V2(-1.9f, -2.8f))
        }
        it("is multiplied using hadamard product") {
          val result = vector() * other()
          assertThat(result).isEqualTo(V2(0.2f, 0.6f))
        }
        it("is divided using hadamard division") {
          val result = vector() / other()
          assertThat(result).isEqualTo(V2(0.05f, 0.2f / 3))
        }
      }

      it("can be scaled by a 1d vector") {
        val result = vector().scaledBy(V1(0.5))
        assertThat(result).isEqualTo(V2(0.05f, 0.1f))
      }

      it("can be inverted") {
        expectValues(vector().invert(), Pair(-0.1f, -0.2f))
      }

    }
  }

  private fun expectValues(vector: Vector2D, expected: Pair<Float, Float>) {
    assertThat(vector.components()).isEqualTo(arrayOf(V1(expected.first), V1(expected.second)))
  }

}