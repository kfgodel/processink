package info.kfgodel.processink.api.extended

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.impl.V2
import info.kfgodel.processink.api.ext.vector.height
import info.kfgodel.processink.api.ext.vector.width
import info.kfgodel.processink.api.ext.vector.x
import info.kfgodel.processink.api.ext.vector.y

/**
 * This type represents the visual space that can be drawn on.<br></br>
 * It has all the methods that are used to draw or modify the canvas
 *
 * Created by kfgodel on 26/10/15.
 */
interface ProcessinkCanvas : AppletWrapper {
  /**
   * Default behavior implemented by Processing to draw a single frame
   */
  fun defaultDraw()

  /**
   * Gets the canvas size as a 2d vector using the width and height as coordinates
   */
  fun size(): Vector2D = V2(this.applet().width(), this.applet().height())


  /**
   * Draws a rectangle in the canvas using the given points, interpreted according to the current rectangle drawing mode
   * By default the first point is used as the absolute top-left corner, and the second as the width and height
   */
  fun rectangle(first: Vector2D, second: Vector2D) {
    this.applet().rect(first.x().float, first.y().float, second.x().float, second.y().float)
  }

  /**
   * Draws an ellipse in the canvas using the given points.
   * Origin is the center of the ellipse, and size indicates width and height
   */
  fun ellipse(origin: Vector2D, size: Vector2D) {
    this.applet().ellipse(origin.x().float, origin.y().float, size.width().float, size.height().float)
  }

}

