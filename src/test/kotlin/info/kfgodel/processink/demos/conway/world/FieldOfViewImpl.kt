package info.kfgodel.processink.demos.conway.world

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.api.ext.vector.x
import info.kfgodel.processink.api.ext.vector.y

/**
 * Implementation of the field of view
 * Created by tenpines on 14/11/15.
 */
class FieldOfViewImpl : FieldOfView {
    private var topLeft: Vector2D? = null
    private var bottomRight: Vector2D? = null
    override fun dimension(): Vector2D? {
        return bottomRight!!.minus(topLeft!!)
    }

    override fun includes(position: Vector2D): Boolean {
        return (topLeft!!.x() <= position.x() && bottomRight!!.x() >= position.x()
                && topLeft!!.y() <= position.y() && bottomRight!!.y() >= position.y())
    }

    override fun makeRelative(absolute: Vector2D): Vector2D? {
        return absolute.plus(topLeft!!.invert())
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o !is FieldOfViewImpl) return false
        val that = o
        return if (if (topLeft != null) {
            !topLeft!!.equals(that.topLeft)
        } else {
            that.topLeft != null
        }) {
          false
        } else {
          !if (bottomRight != null) {
            !bottomRight!!.equals(that.bottomRight)
          } else {
            that.bottomRight != null
          }
        }
    }

    override fun hashCode(): Int {
        var result = if (topLeft != null) topLeft.hashCode() else 0
        result = 31 * result + if (bottomRight != null) bottomRight.hashCode() else 0
        return result
    }

    override fun toString(): String {
        return javaClass.simpleName + "[" + topLeft + ", " + bottomRight + "]"
    }

    companion object {
        fun create(topLeft: Vector2D?, bottomRight: Vector2D?): FieldOfViewImpl {
            val fieldOfView = FieldOfViewImpl()
            fieldOfView.topLeft = topLeft
            fieldOfView.bottomRight = bottomRight
            return fieldOfView
        }
    }
}