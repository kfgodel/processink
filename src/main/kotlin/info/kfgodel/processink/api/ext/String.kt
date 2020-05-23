package info.kfgodel.processink.api.ext

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.api.visuals.basic.TextVisual

/**
 * This file adds extension to String in order to improve the integration with processink
 * Date: 23/5/20 - 15:24
 */

fun String.at(position: Vector2D) = TextVisual(this, position)