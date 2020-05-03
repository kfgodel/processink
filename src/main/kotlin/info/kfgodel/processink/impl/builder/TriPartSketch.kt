package info.kfgodel.processink.impl.builder

import info.kfgodel.processink.api.ProcessingSketch
import info.kfgodel.processink.api.original.ProcessingApi
import info.kfgodel.processink.api.original.ProcessingSettings
import info.kfgodel.processink.api.original.ProcessingSetup

/**
 * This class implements the sketch interface by delegating each responsibility to a different
 * code block. It allows configuring the behavior of each part separately
 *
 * Date: 3/5/20 - 12:54
 */
class TriPartSketch(
  private val settingsBehavior: (ProcessingSettings) -> Unit,
  private val setupBehavior: (ProcessingSetup) -> Unit,
  private val drawBehavior: (ProcessingApi) -> Unit
) : ProcessingSketch {

  override fun onSettings(settings: ProcessingSettings) {
    settingsBehavior.invoke(settings)
  }

  override fun onSetup(setup: ProcessingSetup) {
    setupBehavior.invoke(setup)
  }

  override fun onDraw(api: ProcessingApi) {
    drawBehavior.invoke(api)
  }
}