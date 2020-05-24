package info.kfgodel.processink.demos.conway.camera

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.demos.conway.world.ConwayWorld
import info.kfgodel.processink.demos.conway.world.FieldOfView

/**
 * Implementation of the camera
 * Created by kfgodel on 14/11/15.
 */
class DefaultConwayCamera(
  private val target: Vector2D,
  private val size: Vector2D
) : ConwayCamera {

  override fun takeSnapshot(world: ConwayWorld): Snapshot {
    val fieldOfView = calculateFieldOfView()
    val areaState = world.getStateInside(fieldOfView)
    return DefaultSnapshot(areaState)
  }

  private fun calculateFieldOfView(): FieldOfView {
    val quadrant: Vector2D = size.scaledBy(0.5)
    val topLeft: Vector2D = target.minus(quadrant)
    val bottomRight: Vector2D = target.plus(quadrant)
    return FieldOfView.create(topLeft, bottomRight)
  }

}