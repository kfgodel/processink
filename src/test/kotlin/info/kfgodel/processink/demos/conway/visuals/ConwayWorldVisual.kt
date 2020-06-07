package info.kfgodel.processink.demos.conway.visuals

import info.kfgodel.processink.api.original.ProcessingCanvas
import info.kfgodel.processink.api.visuals.VisualDescription
import info.kfgodel.processink.api.visuals.basic.BackgroundVisual
import info.kfgodel.processink.demos.conway.camera.ConwayCamera
import info.kfgodel.processink.demos.conway.world.ConwayWorld

/**
 * This type represents the description of the game visual representation
 * Created by kfgodel on 14/11/15.
 */
class ConwayWorldVisual(private val camera: ConwayCamera, private val world: ConwayWorld) : VisualDescription {

  override fun invoke(canvas: ProcessingCanvas) {
    BackgroundVisual(-0x55555556).invoke(canvas)
    SnapshotVisual(camera.takeSnapshot(world))
      .invoke(canvas)
  }
}