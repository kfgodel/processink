package info.kfgodel.processink.impl.builder

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.processink.api.original.ProcessingApi
import info.kfgodel.processink.api.original.ProcessingSettings
import info.kfgodel.processink.api.original.ProcessingSetup
import io.mockk.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * Date: 3/5/20 - 12:33
 */
@RunWith(JavaSpecRunner::class)
class DefaultBuilderTest : KotlinSpec() {
  override fun define() {
    describe("a sketch builder") {
      val builder by let { DefaultBuilder() }

      it("allows creating a default sketch") {
        assertThat(builder().build()).isNotNull()
      }

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

          val settings = mockCustomSettings()
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

          val setup = mockCustomSetup()
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

          val api = mockCustomDraw()
          sketch.onDraw(api)

          verify { api.background(3) }
          verify(exactly = 0) { api.defaultDraw() }
        }
      }

    }
  }

  private fun mockCustomSettings(): ProcessingSettings {
    val settings = mockk<ProcessingSettings>()
    every { settings.fullScreen(any()) } just Runs
    return settings
  }
  private fun mockCustomSetup(): ProcessingSetup {
    val setup = mockk<ProcessingSetup>()
    every { setup.fullScreen(any()) } just Runs
    return setup
  }
  private fun mockCustomDraw(): ProcessingApi {
    val api = mockk<ProcessingApi>()
    every { api.background(any()) } just Runs
    return api
  }
}