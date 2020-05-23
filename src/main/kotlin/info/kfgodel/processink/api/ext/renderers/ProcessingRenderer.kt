package info.kfgodel.processink.api.ext.renderers

import processing.core.PConstants

/**
 * This enum captures the possible renderers that are available on Processing.<br>
 * An enum is used to limit the options and give a type name different than String (used
 * on PConstants).
 *
 * [Reference on renderers](https://processing.org/reference/size_.html)
 *
 * Created by kfgodel on 27/10/15.
 */
enum class ProcessingRenderer(val id: String) {
  /**
   * (default?) 2D renderer that uses java native 2d API
   */
  JAVA2D(PConstants.JAVA2D),
  /**
   * A 2D renderer that uses JavaFX, which may be faster for some applications, but has some compatibility quirks
   */
  FX2D(PConstants.FX2D),
  /**
   * 2D graphics renderer that makes use of OpenGL-compatible graphics hardware
   */
  P2D(PConstants.P2D),
  /**
   * 3D graphics renderer that makes use of OpenGL-compatible graphics hardware
   */
  P3D(PConstants.P3D),
  /**
   * Requires a dependency on PDF library
   * The PDF renderer draws 2D graphics directly to an Acrobat PDF file. This produces excellent results when you need
   * vector shapes for high-resolution output or printing
   */
  PDF(PConstants.PDF),
  /**
   * Requires a dependency on SVG library.
   * The SVG renderer draws 2D graphics directly to an SVG file. This is great for importing into other vector
   * programs or using for digital fabrication
   */
  SVG(PConstants.SVG),
  /**
   * Requires a dependency on DXF library.
   * The DXF library writes all triangle-based graphics (polygons, boxes, spheres, etc.) to a DXF file.
   * It works with the beginRaw() and endRaw() functions
   */
  DXF(PConstants.DXF);

}