package info.kfgodel.processink.api.ext.processing

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.mathe.impl.V2
import info.kfgodel.processink.api.original.ProcessingCanvas

/**
 * This file adds extension methods to the original processing API for handling the canvas
 * Date: 23/5/20 - 15:40
 */

/**
 * Gets the canvas size as a 2d vector using the width and height as coordinates
 */
val ProcessingCanvas.size: Vector2D
  get() = V2(this.width(), this.height())