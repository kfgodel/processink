package info.kfgodel.processink.api.visuals.basic

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.ext.x
import info.kfgodel.processink.api.extended.ProcessinkCanvas
import info.kfgodel.processink.impl.ProcessingApplet
import io.mockk.every
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
        val canvas = mockk<ProcessinkCanvas>(relaxed = true)
        val applet = mockk<ProcessingApplet>(relaxed = true)
        every { canvas.applet() } returns applet

        visual().invoke(canvas)

        verify { applet.ellipse(1f, 2f, 100f, 200f) }
      }
    }
  }
}