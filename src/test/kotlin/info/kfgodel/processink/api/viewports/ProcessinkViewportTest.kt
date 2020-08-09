package info.kfgodel.processink.api.viewports

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.impl.V2
import info.kfgodel.processink.api.renderers.ProcessingRenderer
import info.kfgodel.processink.impl.ProcessingApplet
import io.mockk.mockk
import io.mockk.verify
import org.junit.runner.RunWith
import processing.core.PConstants

/**
 * Verifies that viewports correctly configure the applet
 * Date: 22/5/20 - 00:05
 */
@RunWith(JavaSpecRunner::class)
class ProcessinkViewportTest : KotlinSpec() {
  override fun define() {
    describe("given a processing applet") {
      val applet by let { mockk<ProcessingApplet>(relaxed = true) }

      describe("a fullscreen viewport") {
        it("can use default renderer on the default display") {
          FullscreenViewport().configure(applet())
          verify { applet().fullScreen() }
        }
        it("can use default renderer on a custom display") {
          FullscreenViewport(displayId = 2).configure(applet())
          verify { applet().fullScreen(2) }
        }
        it("can use a custom renderer on the default display") {
          FullscreenViewport(ProcessingRenderer.P3D).configure(applet())
          verify { applet().fullScreen(PConstants.P3D) }
        }
        it("can use a custom renderer on custom display") {
          FullscreenViewport(ProcessingRenderer.P3D, 4).configure(applet())
          verify { applet().fullScreen(PConstants.P3D, 4) }
        }
      }

      describe("a windowed viewport") {
        it("can use the default renderer on a custom sized window") {
          WindowViewport(V2(640,480)).configure(applet())
          verify { applet().size(640, 480) }
        }
        it("can use a custom renderer on a custom sized window") {
          WindowViewport(V2(320,240), ProcessingRenderer.P2D).configure(applet())
          verify { applet().size(320, 240, PConstants.P2D) }
        }
        it("can use a custom file renderer on a custom sized window") {
          WindowViewport(V2(300,300), ProcessingRenderer.PDF, "a custom path").configure(applet())
          verify { applet().size(300, 300, PConstants.PDF, "a custom path") }
        }
        it("ignores the path if no custom renderer is defined") {
          WindowViewport(V2(640,480), outputPath = "an ignored path").configure(applet())
          verify { applet().size(640, 480) }
        }
      }

    }
  }
}

