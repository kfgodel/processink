package info.kfgodel.processink.demos.conway.world

import info.kfgodel.mathe.api.Vector2D
import info.kfgodel.processink.demos.conway.states.WorldAreaState
import java.util.*
import kotlin.collections.HashSet

/**
 * This type represents the infinite space of cells for conway's game of life
 * Created by kfgodel on 14/11/15.
 */
interface ConwayWorld {
  /**
   * Changes the state of the conway world advancing one generation
   */
  fun advanceOneGeneration()

  /**
   * Returns the state of every cell contained in the given field of view.<br></br>
   * Dead cells are omitted from the area state returned
   * @param view A portion of the world we are interested in
   * @return The state and position for every cell in the area inside the field of view
   */
  fun getStateInside(view: FieldOfView): WorldAreaState

  companion object {
    fun create(vararg survivingCells: Vector2D): ConwayWorld {
      return DefaultConwayWorld(HashSet(Arrays.asList(*survivingCells)))
    }
  }
}