package info.kfgodel.processink.api.visuals.basic

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.ext.x
import info.kfgodel.processink.api.original.ProcessingCanvas
import io.mockk.mockk
import io.mockk.verify
import org.junit.runner.RunWith

/**
 * This test verifies that an ellipse visual correctly represents itself
 * Date: 6/6/20 - 23:14
 */
@RunWith(JavaSpecRunner::class)
class EllipseVisualTest : KotlinSpec() {
  override fun define() {
    describe("an ellipse visual") {
      val visual by let { EllipseVisual(1 x 2, 100 x 200) }

      it("draws an ellipse when applied on a processing canvas") {
        val canvas = mockk<ProcessingCanvas>(relaxed = true)

        visual().invoke(canvas)

        verify { canvas.ellipse(1f, 2f, 100f, 200f) }
      }
    }
  }
}