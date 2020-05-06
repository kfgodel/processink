package info.kfgodel.mathe.impl

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * This class verifies the expected behavior for a 1d float vector
 * Date: 5/5/20 - 00:00
 */
@RunWith(JavaSpecRunner::class)
class V1Test : KotlinSpec() {
  override fun define() {
    describe("a 1D vector") {
      val vector by let { V1(0.3f) }

      describe("dimensions"){
        it("takes a float value as it only dimension") {
          assertThat(vector().toFloat()).isEqualTo(0.3f)
          assertThat(vector().coordinate1()).isEqualTo(V1(0.3f))
        }
        it("contains only 1 value in the array of values"){
          assertThat(vector().coordinates()).isEqualTo(arrayOf(V1(0.3f)))
        }
        it("is 0 is asked for other dimensions"){
          assertThat(vector().coordinate2()).isEqualTo(V1.ZERO)
          assertThat(vector().coordinate3()).isEqualTo(V1.ZERO)
          assertThat(vector().coordinate4()).isEqualTo(V1.ZERO)
        }
      }

      describe("alternate creation") {
        it("can be done with a double value") {
          assertThat(V1(0.01)).isEqualTo(V1(0.01f))
        }
        it("can be done with an integer value") {
          assertThat(V1(3)).isEqualTo(V1(3.0f))
        }
      }

      describe("with other 1d vector") {
        val other by let { V1(2) }

        it("can be added") {
          val result = vector() + other()
          assertThat(result).isEqualTo(V1(2.3f))
        }
        it("can be subtracted") {
          val result = vector() - other()
          assertThat(result).isEqualTo(V1(-1.7f))
        }
        it("can be multiplied") {
          val result = vector() * other()
          assertThat(result).isEqualTo(V1(0.6f))
        }
        it("can be divided") {
          val result = vector() / other()
          assertThat(result).isEqualTo(V1(0.15f))
        }

        it("can be compared") {
          assertThat(V1.ZERO == V1(0)).isTrue()
          assertThat(V1.ONE != V1(1)).isFalse()

          assertThat(V1(0) < V1(1)).isTrue()
          assertThat(V1(0) > V1(1)).isFalse()

          assertThat(V1(0.5) <= V1(0.5)).isTrue()
          assertThat(V1(0.5) >= V1(0.6)).isFalse()
        }
      }
      describe("with other number") {
        val number by let { 2.0 }

        it("can be added") {
          val result = vector() + number()
          assertThat(result).isEqualTo(V1(2.3f))
        }
        it("can be subtracted") {
          val result = vector() - number()
          assertThat(result).isEqualTo(V1(-1.7f))
        }
        it("can be multiplied") {
          val result = vector() * number()
          assertThat(result).isEqualTo(V1(0.6f))
        }
        it("can be divided") {
          val result = vector() / number()
          assertThat(result).isEqualTo(V1(0.15f))
        }
      }
    }
  }

}