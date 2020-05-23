package info.kfgodel.processink.api.visuals

import info.kfgodel.processink.api.original.ProcessingCanvas

/**
 * This type represents a visual element (or a composition of them) that can be drawn on a ProcessingCanvas.<br>
 * When applied on a canvas a visual description generates a pixel representation perceivable by humans
 *
 * Created by kfgodel on 28/10/15.
 */
interface VisualDescription : (ProcessingCanvas) -> Unit {

  /**
   * Modifies the pixel area of the canvas according to this instance representation
   * @param canvas The pixel space to affect
   */
  override fun invoke(canvas: ProcessingCanvas)
}