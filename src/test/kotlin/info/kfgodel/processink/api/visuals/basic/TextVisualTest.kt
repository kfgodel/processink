package info.kfgodel.processink.api.visuals.basic

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.ext.x
import info.kfgodel.processink.api.extended.ProcessinkCanvas
import info.kfgodel.processink.tests.delegating
import info.kfgodel.processink.tests.mockApplet
import io.mockk.verify
import org.junit.runner.RunWith

/**
 * This class verifies the correct implementation of a text visual
 * Date: 23/5/20 - 15:20
 */
@RunWith(JavaSpecRunner::class)
class TextVisualTest : KotlinSpec() {
  override fun define() {
    describe("a text visual") {
      val visual by let { TextVisual("a text", 1 x 2) }

      it("draws text on a canvas in the given position") {
        val applet = mockApplet()
        val canvas = delegating<ProcessinkCanvas>(to = applet)

        visual().invoke(canvas)

        verify { applet.text("a text", 1f, 2f) }
      }
    }
  }
}