package info.kfgodel.processink.api

import info.kfgodel.processink.api.events.LifecycleEventHandler
import info.kfgodel.processink.api.events.MouseEventHandler

/**
 * This type represents a user defined processing "sketch" visualization.<br>
 * The sketch represents what the user wants Processing to do when it's run.<br>
 * It not only includes visualizations but any of the Processing features (music, sound, camera, etc)
 *
 * Created by kfgodel on 26/10/15.
 */
interface ProcessingSketch :
  LifecycleEventHandler,
  MouseEventHandler