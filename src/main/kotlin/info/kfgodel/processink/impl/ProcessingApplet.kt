package info.kfgodel.processink.impl

import info.kfgodel.processink.api.ProcessingSketch
import info.kfgodel.processink.api.SketchRunner
import info.kfgodel.processink.api.extended.ProcessinkApi
import info.kfgodel.processink.api.original.ProcessingOriginalApi
import info.kfgodel.processink.impl.builder.DefaultSketchBuilder
import info.kfgodel.processink.impl.events.DefaultMouseEvent
import processing.core.PApplet
import processing.event.MouseEvent


/**
 * This thread local is used to pass a sketch to the adapter before Processing instantiates it
 */
val sharedSketch = ThreadLocal<ProcessingSketch>()

/**
 * This class extends Processing PApplet class to delegate processing calls to a ProcessingSketch instance
 * Date: 2/5/20 - 17:49
 */
class ProcessingApplet : PApplet(), ProcessinkApi, ProcessingOriginalApi {

  companion object : SketchRunner {
    override fun run(sketch: ProcessingSketch) {
      sharedSketch.set(sketch)
      try {
        // Processing will instantiate us, and we will take the sketch from the thread
        main(ProcessingApplet::class.java)
      } finally {
        sharedSketch.remove()
      }
    }
  }



  /**
   * Take the shared sketch from the thread local after processing has instantiated us.<br>
   * It uses an empty sketch if none is found on the threadlocal and uses default settings
   */
  private val delegateSketch: ProcessingSketch = sharedSketch.get() ?: DefaultSketchBuilder().build()

  override fun applet() = this

  override fun defaultSettings() {
    super.settings()
  }
  override fun settings() {
    delegateSketch.onSettings(this)
  }

  override fun defaultSetup() {
    super.setup()
  }
  override fun setup() {
    delegateSketch.onSetup(this)
  }

  override fun defaultDraw() {
    super.draw()
  }

  override fun width() = this.width
  override fun height() = this.height

  override fun draw() {
    delegateSketch.onDraw(this)
  }

  override fun mouseClicked(event: MouseEvent?) {
    wrapEventAndCall(delegateSketch::onMouseClicked, event)
  }
  override fun mouseDragged(event: MouseEvent?) {
    wrapEventAndCall(delegateSketch::onMouseDragged, event)
  }
  override fun mouseEntered(event: MouseEvent?) {
    wrapEventAndCall(delegateSketch::onMouseEntered, event)
  }
  override fun mouseExited(event: MouseEvent?) {
    wrapEventAndCall(delegateSketch::onMouseExited, event)
  }
  override fun mouseMoved(event: MouseEvent?) {
    wrapEventAndCall(delegateSketch::onMouseMoved, event)
  }
  override fun mousePressed(event: MouseEvent?) {
    wrapEventAndCall(delegateSketch::onMousePressed, event)
  }
  override fun mouseReleased(event: MouseEvent?) {
    wrapEventAndCall(delegateSketch::onMouseReleased, event)
  }
  override fun mouseWheel(event: MouseEvent?) {
    wrapEventAndCall(delegateSketch::onMouseWheel, event)
  }

  private inline fun wrapEventAndCall(functionToCall: (info.kfgodel.processink.api.events.MouseEvent, ProcessinkApi)-> Unit, event: MouseEvent?) {
    functionToCall.invoke(DefaultMouseEvent(event!!), this)
  }

}