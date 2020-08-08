package info.kfgodel.processink.api.extended

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.impl.V2

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

}

