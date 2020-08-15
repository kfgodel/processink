package info.kfgodel.processink.tests

import info.kfgodel.processink.impl.ProcessingApplet
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk

/**
 * Date: 15/8/20 - 17:47
 */


/**
 * Returns a fake applet that won't have an actual rendering context.
 * Each method call will be ignored
 */
fun mockApplet() = mockk<ProcessingApplet>(relaxed = true)

/**
 * Creates a mock object that delegates its applet calls to the given processing applet.
 * This helps on testing other types that are AppletWrappers
 */
fun <T> delegating(to: ProcessingApplet): T {
  val canvas = spyk<ProcessingApplet>()
  every { canvas.applet() } returns to
  return canvas as T
}
