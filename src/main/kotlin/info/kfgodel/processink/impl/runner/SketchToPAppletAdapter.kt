package info.kfgodel.processink.impl.runner

import info.kfgodel.processink.api.ProcessingSketch
import info.kfgodel.processink.api.SketchRunner
import processing.core.PApplet
import processing.event.MouseEvent


/**
 * This thread local is used to pass a sketch to the adapter before Processing instantiates it
 */
private val sharedSketch = ThreadLocal<ProcessingSketch>()

/**
 * This class extends Processing PApplet class to delegate processing calls to a ProcessingSketch instance
 * Date: 2/5/20 - 17:49
 */
class SketchToPAppletAdapter : PApplet() {

  private var delegateSketch: ProcessingSketch = sharedSketch.get()

  companion object : SketchRunner {
    override fun run(sketch: ProcessingSketch) {
      sharedSketch.set(sketch)
      try {
        // Procesing will instantiate us, and we will take the sketch from the thread
        main(SketchToPAppletAdapter::class.java)
      } finally {
        sharedSketch.remove()
      }
    }
  }

  override fun settings() {
    super.settings()
    delegateSketch.onSettings()
  }

  override fun setup() {
    super.setup()
    delegateSketch.onSetup()
  }

  override fun draw() {
    super.draw()
    delegateSketch.onDraw()
  }

  override fun mouseClicked(event: MouseEvent?) {
    super.mouseClicked(event)
    delegateSketch.onMouseClicked()
  }

}