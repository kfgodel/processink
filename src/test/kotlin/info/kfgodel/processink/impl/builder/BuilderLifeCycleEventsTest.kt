package info.kfgodel.processink.impl.builder

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.processink.api.extended.ProcessinkSettings
import info.kfgodel.processink.api.extended.ProcessinkSetup
import info.kfgodel.processink.api.extended.ProcessinkApi
import info.kfgodel.processink.impl.ProcessingApplet
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.runner.RunWith

/**
 * This test verifies that the builder can configure a sketch with custom life cycle event handlers
 * Date: 3/5/20 - 12:33
 */
@RunWith(JavaSpecRunner::class)
class BuilderLifeCycleEventsTest : KotlinSpec() {
  override fun define() {
    describe("a sketch builder") {
      val builder by let { DefaultSketchBuilder() }

      describe("when creating a default sketch"){
        val sketch by let {builder().build()}

        it("uses default settings behavior") {
          val settings = mockk<ProcessinkSettings>()
          every { settings.defaultSettings() } just Runs

          sketch().onSettings(settings)

          verify { settings.defaultSettings() }
        }
        it("uses default setup behavior") {
          val setup = mockk<ProcessinkSetup>()
          every { setup.defaultSetup() } just Runs

          sketch().onSetup(setup)

          verify { setup.defaultSetup() }
        }
        it("uses default draw behavior") {
          val api = mockk<ProcessinkApi>()
          every { api.defaultDraw() } just Runs

          sketch().onDraw(api)

          verify { api.defaultDraw() }
        }
      }

      describe("when customizing sketch settings"){
        beforeEach {
          builder().withSettings { settings ->
            settings.applet().fullScreen("a renderer")
          }
        }

        it("uses custom settings on the sketch"){
          val sketch = builder().build()

          val settings = mockk<ProcessinkSettings>(relaxed = true)
          val applet = mockk<ProcessingApplet>(relaxed = true)
          every { settings.applet() } returns applet

          sketch.onSettings(settings)

          verify { applet.fullScreen("a renderer") }
          verify(exactly = 0) { settings.defaultSettings() }
        }
      }

      describe("when customizing sketch setup"){
        beforeEach {
          builder().withSetup { setup ->
            setup.applet().fullScreen("other renderer")
          }
        }

        it("uses custom setup on the sketch"){
          val sketch = builder().build()

          val setup = mockk<ProcessinkSetup>(relaxed = true)
          val applet = mockk<ProcessingApplet>(relaxed = true)
          every { setup.applet() } returns applet

          sketch.onSetup(setup)

          verify { applet.fullScreen("other renderer") }
          verify(exactly = 0) { setup.defaultSetup() }
        }
      }

      describe("when customizing sketch drawing"){
        beforeEach {
          builder().drawing { api ->
            api.background(3)
          }
        }

        it("uses custom draw on the sketch"){
          val sketch = builder().build()

          val api = mockk<ProcessinkApi>(relaxed = true)
          sketch.onDraw(api)

          verify { api.background(3) }
          verify(exactly = 0) { api.defaultDraw() }
        }
      }

    }
  }

}