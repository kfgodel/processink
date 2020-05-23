package info.kfgodel.processink.impl

import info.kfgodel.processink.api.ProcessingSketch
import info.kfgodel.processink.api.SketchRunner
import info.kfgodel.processink.api.original.ProcessingApi
import info.kfgodel.processink.impl.builder.DefaultSketchBuilder
import processing.core.PApplet


/**
 * This thread local is used to pass a sketch to the adapter before Processing instantiates it
 */
private val sharedSketch = ThreadLocal<ProcessingSketch>()

/**
 * This class extends Processing PApplet class to delegate processing calls to a ProcessingSketch instance
 * Date: 2/5/20 - 17:49
 */
class ProcessingApplet : PApplet(), ProcessingApi {

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
   * It uses an empty sketch if none is found on the threadlocal to avoid NPE
   */
  private var delegateSketch: ProcessingSketch = sharedSketch.get() ?: DefaultSketchBuilder().build()

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

}