package info.kfgodel.processink.demos.conway.camera

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.demos.conway.world.ConwayWorld

/**
 * This type represents a limited size view of a conway game of life infinite space
 *
 * Created by kfgodel on 14/11/15.
 */
interface ConwayCamera {
  /**
   * Takes the portion of space looked by this camera and captures it in a non changing snapshot, that
   * won't be affected by the passing of time on the game
   * @param world The world where the snapshot will be taken
   * @return The captured partial state from the game
   */
  fun takeSnapshot(world: ConwayWorld): Snapshot

  companion object {
    fun create(target: Vector2D, size: Vector2D): ConwayCamera {
      return DefaultConwayCamera(target, size)
    }
  }
}