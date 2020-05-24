package info.kfgodel.processink.demos.conway.camera

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.impl.V1
import info.kfgodel.processink.demos.conway.world.ConwayWorld
import info.kfgodel.processink.demos.conway.world.FieldOfView

/**
 * Implementation of the camera
 * Created by tenpines on 14/11/15.
 */
class ConwayCameraImpl : ConwayCamera {
    private var world: ConwayWorld? = null
    private var target: Vector2D? = null
    private var size: Vector2D? = null
    override fun takeSnapshot(): Snapshot {
        val fieldOfview = calculateFieldOfView()
        val areaState = world!!.getStateInside(fieldOfview)
        return Snapshot.create(areaState)
    }

    private fun calculateFieldOfView(): FieldOfView {
        val margin: Vector2D = size!!.scaledBy(V1(0.5))
        val topLeft: Vector2D = target!!.minus(margin)
        val bottomRight: Vector2D = target!!.plus(margin)
        return FieldOfView.create(topLeft, bottomRight)
    }

    override fun target(): Vector2D? {
        return target
    }

    override fun size(): Vector2D? {
        return size
    }

    companion object {
        fun create(target: Vector2D?, size: Vector2D?, world: ConwayWorld?): ConwayCameraImpl {
            val camera = ConwayCameraImpl()
            camera.world = world
            camera.target = target
            camera.size = size
            return camera
        }
    }
}