package info.kfgodel.processink.api.ext

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.impl.V2
import info.kfgodel.processink.api.ext.renderers.ProcessingRenderer
import info.kfgodel.processink.api.ext.viewports.FullscreenViewport
import info.kfgodel.processink.api.ext.viewports.WindowViewport
import info.kfgodel.processink.api.original.ProcessingSettings
import io.mockk.mockk
import io.mockk.verify
import org.junit.runner.RunWith
import processing.core.PConstants

/**
 * Verifies extensions done to settings api
 * Date: 22/5/20 - 00:05
 */
@RunWith(JavaSpecRunner::class)
class ProcessingSettingsTest : KotlinSpec() {
  override fun define() {
    describe("a settings api") {
      val settings by let { mockk<ProcessingSettings>(relaxed = true) }

      describe("configured for fullscreen size") {
        it("can use default renderer on the default display") {
          settings().viewport(FullscreenViewport())
          verify { settings().fullScreen() }
        }
        it("can use default renderer on a custom display") {
          settings().viewport(FullscreenViewport(displayId = 2))
          verify { settings().fullScreen(2) }
        }
        it("can use a custom renderer on the default display") {
          settings().viewport(FullscreenViewport(ProcessingRenderer.P3D))
          verify { settings().fullScreen(PConstants.P3D) }
        }
        it("can use a custom renderer on custom display") {
          settings().viewport(FullscreenViewport(ProcessingRenderer.P3D, 4))
          verify { settings().fullScreen(PConstants.P3D, 4) }
        }
      }

      describe("configured for windowed size") {
        it("can use the default renderer on a custom sized window") {
          settings().viewport(WindowViewport(V2(640,480)))
          verify { settings().size(640, 480) }
        }
        it("can use a custom renderer on a custom sized window") {
          settings().viewport(WindowViewport(V2(320,240), ProcessingRenderer.P2D))
          verify { settings().size(320, 240, PConstants.P2D) }
        }
        it("can use a custom file renderer on a custom sized window") {
          settings().viewport(WindowViewport(V2(300,300), ProcessingRenderer.PDF, "a custom path"))
          verify { settings().size(300, 300, PConstants.PDF, "a custom path") }
        }
        it("ignores the path if no custom renderer is defined") {
          settings().viewport(WindowViewport(V2(640,480), outputPath = "an ignored path"))
          verify { settings().size(640, 480) }
        }
      }


    }
  }
}

