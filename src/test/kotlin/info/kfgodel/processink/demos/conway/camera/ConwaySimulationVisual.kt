package info.kfgodel.processink.demos.conway.camera

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.api.original.ProcessingCanvas
import info.kfgodel.processink.api.visuals.VisualDescription

/**
 * This type represents the description of the game visual representation
 * Created by tenpines on 14/11/15.
 */
class ConwaySimulationVisual : VisualDescription {
    private var camera: ConwayCamera? = null
    private var viewSize: Vector2D? = null

    companion object {
        fun create(camera: ConwayCamera?, viewportSize: Vector2D?): ConwaySimulationVisual {
            val visual = ConwaySimulationVisual()
            visual.camera = camera
            visual.viewSize = viewportSize
            return visual
        }
    }

  override fun invoke(canvas: ProcessingCanvas) {
    canvas.background(-0x55555556)
    val snapshot = camera!!.takeSnapshot()
    SnapshotVisual.create(snapshot, viewSize).invoke(canvas)
  }
}