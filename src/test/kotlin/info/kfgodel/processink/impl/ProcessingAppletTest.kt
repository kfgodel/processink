package info.kfgodel.processink.impl

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.processink.api.ProcessingSketch
import io.mockk.Called
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * This test verifies that the kotlin processing applet correctly delegates to a sketch instance
 * Date: 6/6/20 - 14:49
 */
@RunWith(JavaSpecRunner::class)
class ProcessingAppletTest: KotlinSpec() {
  override fun define() {
    describe("a processing applet") {
      val sketch by let { mockk<ProcessingSketch>(relaxed = true) }
      val applet by let {
        sharedSketch.set(sketch()) //  We simulate running the sketck
        ProcessingApplet()
      }

      describe("when called on a lifecycle callback method"){
        it("delegates to sketch for settings") {
          applet().settings()

          verify { sketch().onSettings(any()) }
        }
        it("delegates to sketch for setup") {
          applet().setup()

          verify { sketch().onSetup(any()) }
        }
        it("delegates to sketch for draw") {
          applet().draw()

          verify { sketch().onDraw(any()) }
        }
      }

      describe("when called on mouse event callback methods"){
        it("ignores methods without event argument"){
          applet().mouseClicked()
          applet().mouseDragged()
          applet().mouseEntered()
          applet().mouseExited()
          applet().mouseMoved()
          applet().mousePressed()
          applet().mouseReleased()
          applet().mouseWheel()

          verify { sketch() wasNot Called }
        }

        it("delegates to sketch for mouse clicked ") {
          applet().mouseClicked(mockk())
          verify { sketch().onMouseClicked(any(), applet()) }
        }
        it("delegates to sketch for mouse being dragged around") {
          applet().mouseDragged(mockk())
          verify { sketch().onMouseDragged(any(), applet()) }
        }
        it("delegates to sketch for mouse entered the sketch window ") {
          applet().mouseEntered(mockk())
          verify { sketch().onMouseEntered(any(), applet()) }
        }
        it("delegates to sketch for mouse exited the sketch window ") {
          applet().mouseExited(mockk())
          verify { sketch().onMouseExited(any(), applet()) }
        }
        it("delegates to sketch for mouse moved ") {
          applet().mouseMoved(mockk())
          verify { sketch().onMouseMoved(any(), applet()) }
        }
        it("delegates to sketch for mouse button pressed ") {
          applet().mousePressed(mockk())
          verify { sketch().onMousePressed(any(), applet()) }
        }
        it("delegates to sketch for mouse button released ") {
          applet().mouseReleased(mockk())
          verify { sketch().onMouseReleased(any(), applet()) }
        }
        it("delegates to sketch for mouse wheel used ") {
          applet().mouseWheel(mockk())
          verify { sketch().onMouseWheel(any(), applet()) }
        }
      }



      describe("offers as method"){
        it("height"){
          assertThat(applet().height()).isEqualTo(100)
        }
        it("width"){
          assertThat(applet().height()).isEqualTo(100)
        }
      }


    }
  }
}