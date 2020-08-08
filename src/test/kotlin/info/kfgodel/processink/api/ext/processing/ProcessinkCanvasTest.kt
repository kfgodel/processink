package info.kfgodel.processink.api.ext.processing

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.ext.x
import info.kfgodel.processink.impl.ProcessingApplet
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * This class tests extended canvas methods
 * Date: 23/5/20 - 15:55
 */
@RunWith(JavaSpecRunner::class)
class ProcessinkCanvasTest : KotlinSpec() {
  override fun define() {
    describe("a canvas") {
      val canvas by let { ProcessingApplet() }

      it("allows access to its size as a vector"){
        assertThat(canvas().size()).isEqualTo(100 x 100) // It's that size by default in processing
      }
    }
  }
}