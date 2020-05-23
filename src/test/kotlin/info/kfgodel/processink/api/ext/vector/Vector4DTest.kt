package info.kfgodel.processink.api.ext.vector

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.impl.V1
import info.kfgodel.mathe.impl.V2
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * Date: 6/5/20 - 00:49
 */
@RunWith(JavaSpecRunner::class)
class Vector4DTest : KotlinSpec() {
  override fun define() {
    describe("a vector") {
      val vector by let { V2(1,2) }

      it("has an alias for the 1 component"){
        assertThat(vector().x()).isEqualTo(V1(1f))
      }
      it("has an alias for the 2 component"){
        assertThat(vector().y()).isEqualTo(V1(2f))
      }
      it("has an alias for the 3 component"){
        assertThat(vector().z()).isEqualTo(V1(0f))
      }
      it("has an alias for the 4 component"){
        assertThat(vector().a()).isEqualTo(V1(0f))
      }
    }
  }
}