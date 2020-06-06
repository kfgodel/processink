package info.kfgodel.processink.impl.builder

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.processink.api.events.MouseEvent
import info.kfgodel.processink.api.original.ProcessingApi
import io.mockk.Called
import io.mockk.mockk
import io.mockk.verify
import org.junit.runner.RunWith

/**
 * This test verifies that the builder can configure a sketch with custom mouse event handlers
 * Date: 3/5/20 - 12:33
 */
@RunWith(JavaSpecRunner::class)
class BuilderMouseEventsTest : KotlinSpec() {
  override fun define() {
    describe("a sketch builder") {
      val builder by let { DefaultSketchBuilder() }

      describe("when creating a default sketch"){
        val sketch by let {builder().build()}

        it("ignores all mouse events"){
          val event = mockk<MouseEvent>()
          val api = mockk<ProcessingApi>()
          sketch().onMouseClicked(event, api)
          sketch().onMouseDragged(event, api)
          sketch().onMouseEntered(event, api)
          sketch().onMouseExited(event, api)
          sketch().onMousePressed(event, api)
          sketch().onMouseReleased(event, api)
          sketch().onMouseMoved(event, api)
          sketch().onMouseWheel(event, api)

          verify { event wasNot Called }
          verify { api wasNot Called }
        }
      }

      describe("when customizing mouse event handlers") {
        val eventHandler by let { mockk<(MouseEvent, ProcessingApi) -> Unit>(relaxed = true) }
        val sketch by let { builder().build() }

        val event = mockk<MouseEvent>()
        val api = mockk<ProcessingApi>()

        it("call the given handler for mouse clicks") {
          builder().whenMouseClicked(eventHandler())

          sketch().onMouseClicked(event, api)

          verify { eventHandler().invoke(event, api) }
        }
        it("call the given handler for mouse drag") {
          builder().whenMouseDragged(eventHandler())

          sketch().onMouseDragged(event, api)

          verify { eventHandler().invoke(event, api) }
        }
        it("call the given handler for mouse entered events") {
          builder().whenMouseEntered(eventHandler())

          sketch().onMouseEntered(event, api)

          verify { eventHandler().invoke(event, api) }
        }
        it("call the given handler for mouse exited events") {
          builder().whenMouseExited(eventHandler())

          sketch().onMouseExited(event, api)

          verify { eventHandler().invoke(event, api) }
        }
        it("call the given handler for mouse button press") {
          builder().whenMousePressed(eventHandler())

          sketch().onMousePressed(event, api)

          verify { eventHandler().invoke(event, api) }
        }
        it("call the given handler for mouse button release") {
          builder().whenMouseReleased(eventHandler())

          sketch().onMouseReleased(event, api)

          verify { eventHandler().invoke(event, api) }
        }
        it("call the given handler for mouse move events") {
          builder().whenMouseMoved(eventHandler())

          sketch().onMouseMoved(event, api)

          verify { eventHandler().invoke(event, api) }
        }
        it("call the given handler for mouse wheel events") {
          builder().whenMouseWheel(eventHandler())

          sketch().onMouseWheel(event, api)

          verify { eventHandler().invoke(event, api) }
        }
      }
    }
  }

}