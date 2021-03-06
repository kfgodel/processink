package info.kfgodel.processink.api.visuals.basic

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.processink.api.extended.ProcessinkCanvas
import info.kfgodel.processink.tests.delegating
import info.kfgodel.processink.tests.mockApplet
import io.mockk.verify
import org.junit.runner.RunWith

/**
 * This test verifies that the background visual correctly draws itself
 * Date: 6/6/20 - 23:34
 */
@RunWith(JavaSpecRunner::class)
class BackgroundVisualTest : KotlinSpec() {
  override fun define() {
    describe("a background visual") {
      val visual by let { BackgroundVisual(4) }

      it("fills the sketch with its color") {
        val applet = mockApplet()
        val canvas = delegating<ProcessinkCanvas>(to = applet)

        visual().invoke(canvas)

        verify { applet.background(4) }
      }
    }
  }
}