package info.kfgodel.processink.api.visuals.basic

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.ext.x
import info.kfgodel.processink.api.original.ProcessingCanvas
import io.mockk.mockk
import io.mockk.verify
import org.junit.runner.RunWith

/**
 * This class verifies the correct implementation of a text visual
 * Date: 23/5/20 - 15:20
 */
@RunWith(JavaSpecRunner::class)
class RectangleVisualTest : KotlinSpec() {
  override fun define() {
    describe("a rectangle visual") {
      val visual by let { RectangleVisual(3 x 4, 50 x 60) }

      it("draws a rectangle when applied on a processing canvas") {
        val canvas = mockk<ProcessingCanvas>(relaxed = true)
        visual().invoke(canvas)

        verify { canvas.rect(3f, 4f, 50f, 60f) }
      }
    }
  }
}