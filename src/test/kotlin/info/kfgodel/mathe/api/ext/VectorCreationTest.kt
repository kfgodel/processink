package info.kfgodel.mathe.api.ext

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.impl.V1
import info.kfgodel.mathe.impl.V2
import info.kfgodel.mathe.impl.V3
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * This test verifies the different options to create vectors
 * Date: 6/5/20 - 00:49
 */
@RunWith(JavaSpecRunner::class)
class VectorCreationTest : KotlinSpec() {
  override fun define() {
    describe("a vector creation") {
      it("can be done out of a number"){
        assertThat(2.toV()).isEqualTo(V1(2f))
      }
      it("can be done out of 2 numbers"){
        assertThat(1 x 5).isEqualTo(V2(1f, 5f))
      }
      it("can be done out of 3 numbers"){
        assertThat(1 x 5 x 10).isEqualTo(V3(1f, 5f, 10f))
      }
    }
  }
}