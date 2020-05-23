package hello.tests.info.kfgodel.mathe.impl

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.impl.V1
import info.kfgodel.mathe.impl.V3
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * This class verifies the expected behavior for a 3d float vector
 * Date: 5/5/20 - 00:00
 */
@RunWith(JavaSpecRunner::class)
class V3Test : KotlinSpec() {
  override fun define() {
    describe("a 3D float vector") {
      val vector by let { V3(0.1f, 0.2f, 0.3f) }

      describe("dimensions") {
        it("takes 3 float values as its dimensions") {
          assertThat(vector().component1()).isEqualTo(V1(0.1f))
          assertThat(vector().component2()).isEqualTo(V1(0.2f))
          assertThat(vector().component3()).isEqualTo(V1(0.3f))
        }
        it("is 0 on other dimensions") {
          assertThat(vector().component4()).isEqualTo(V1.ZERO)
        }
        it("contains 3 components") {
          expectValues(vector(), Triple(0.1f, 0.2f, 0.3f))
        }
      }

      describe("alternate creation") {
        it("can be done with double values") {
          expectValues(V3(0.01, 0.02, 0.03), Triple(0.01f, 0.02f, 0.03f))
        }
        it("can be done with integer values") {
          expectValues(V3(1, 2, 3), Triple(1.0f, 2.0f, 3.0f))
        }
        it("can mix numbers and vectors") {
          expectValues(V3(1, 2, 3), Triple(1.0f, 2.0f, 3.0f))
          expectValues(V3(1, 2, V1(3)), Triple(1.0f, 2.0f, 3.0f))
          expectValues(V3(1, V1(2), 3), Triple(1.0f, 2.0f, 3.0f))
          expectValues(V3(1, V1(2),V1(3)), Triple(1.0f, 2.0f, 3.0f))
          expectValues(V3(V1(1), 2, 3), Triple(1.0f, 2.0f, 3.0f))
          expectValues(V3(V1(1), 2, V1(3)), Triple(1.0f, 2.0f, 3.0f))
          expectValues(V3(V1(1), V1(2), 3), Triple(1.0f, 2.0f, 3.0f))
          expectValues(V3(V1(1), V1(2), V1(3)), Triple(1.0f, 2.0f, 3.0f))
        }
      }

      describe("with other 3d vector") {
        val other by let { V3(2, 3, 4) }

        it("can be added") {
          val result = vector() + other()
          assertThat(result).isEqualTo(V3(2.1f, 3.2f, 4.3f))
        }
        it("can be subtracted") {
          val result = vector() - other()
          assertThat(result).isEqualTo(V3(-1.9f, -2.8f, -3.7f))
        }
        it("is multiplied using hadamard product") {
          val result = vector() * other()
          assertThat(result).isEqualTo(V3(0.2f, 0.6f, 1.2f))
        }
        it("is multiplied using hadamard division") {
          val result = vector() / other()
          assertThat(result).isEqualTo(V3(0.05f, 0.2f / 3, 0.3f / 4))
        }
      }

      it("can be scaled by a 1d vector") {
        val result = vector().scaledBy(V1(2))
        assertThat(result).isEqualTo(V3(0.2f, 0.4f, 0.6f))
      }
    }
  }

  private fun expectValues(vector: V3, expected: Triple<Float, Float, Float>) {
    assertThat(vector.components()).containsExactly(V1(expected.first), V1(expected.second), V1(expected.third))
  }

}