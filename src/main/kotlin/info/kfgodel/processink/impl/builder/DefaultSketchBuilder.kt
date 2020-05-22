package info.kfgodel.processink.impl.builder

import info.kfgodel.processink.api.ProcessingSketch
import info.kfgodel.processink.api.builder.SketchBuilder
import info.kfgodel.processink.api.original.ProcessingApi
import info.kfgodel.processink.api.original.ProcessingSettings
import info.kfgodel.processink.api.original.ProcessingSetup

/**
 * This class is the default implementation of the sketch builder
 * Date: 3/5/20 - 12:33
 */
class DefaultSketchBuilder : SketchBuilder {

  private var settingsBehavior: (ProcessingSettings)-> Unit = ProcessingSettings::defaultSettings
  private var setupBehavior: (ProcessingSetup)-> Unit = ProcessingSetup::defaultSetup
  private var drawBehavior: (ProcessingApi)-> Unit = ProcessingApi::defaultDraw


  override fun build(): ProcessingSketch {
    return TriPartSketch(settingsBehavior, setupBehavior, drawBehavior)
  }

  override fun withSettings(customSettings: (ProcessingSettings) -> Unit) : SketchBuilder {
    this.settingsBehavior = customSettings
    return this
  }

  override fun withSetup(customSetup: (ProcessingSetup) -> Unit) : SketchBuilder {
    this.setupBehavior = customSetup
    return this
  }

  override fun drawing(customDraw: (ProcessingApi) -> Unit) : SketchBuilder {
    this.drawBehavior = customDraw
    return this
  }

}