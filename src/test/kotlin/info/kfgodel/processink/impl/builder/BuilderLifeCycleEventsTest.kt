package info.kfgodel.processink.impl.builder

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.processink.api.original.ProcessingApi
import info.kfgodel.processink.api.original.ProcessingSettings
import info.kfgodel.processink.api.original.ProcessingSetup
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.runner.RunWith

/**
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
          val settings = mockk<ProcessingSettings>()
          every { settings.defaultSettings() } just Runs

          sketch().onSettings(settings)

          verify { settings.defaultSettings() }
        }
        it("uses default setup behavior") {
          val setup = mockk<ProcessingSetup>()
          every { setup.defaultSetup() } just Runs

          sketch().onSetup(setup)

          verify { setup.defaultSetup() }
        }
        it("uses default draw behavior") {
          val api = mockk<ProcessingApi>()
          every { api.defaultDraw() } just Runs

          sketch().onDraw(api)

          verify { api.defaultDraw() }
        }
      }

      describe("when customizing sketch settings"){
        beforeEach {
          builder().withSettings { settings ->
            settings.fullScreen("a renderer")
          }
        }

        it("uses custom settings on the sketch"){
          val sketch = builder().build()

          val settings = mockk<ProcessingSettings>(relaxed = true)
          sketch.onSettings(settings)

          verify { settings.fullScreen("a renderer") }
          verify(exactly = 0) { settings.defaultSettings() }
        }
      }

      describe("when customizing sketch setup"){
        beforeEach {
          builder().withSetup { setup ->
            setup.fullScreen("other renderer")
          }
        }

        it("uses custom setup on the sketch"){
          val sketch = builder().build()

          val setup = mockk<ProcessingSetup>(relaxed = true)
          sketch.onSetup(setup)

          verify { setup.fullScreen("other renderer") }
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

          val api = mockk<ProcessingApi>(relaxed = true)
          sketch.onDraw(api)

          verify { api.background(3) }
          verify(exactly = 0) { api.defaultDraw() }
        }
      }

    }
  }

}