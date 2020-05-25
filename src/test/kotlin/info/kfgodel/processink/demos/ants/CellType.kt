package info.kfgodel.processink.demos.ants

import info.kfgodel.mathe.api.Vector2D
import java.util.function.BiConsumer

/**
 * This type represents the type of cell an ant can be on
 * Created by ikari on 11/01/2016.
 */
enum class CellType {
  WHITE {
    override fun turnAnt(ant: Ant) {
      ant.turnRight()
    }

    override fun getFlipOperation(): BiConsumer<MutableSet<Vector2D>, Vector2D> {
      return BiConsumer<MutableSet<Vector2D>, Vector2D> { obj: MutableSet<Vector2D>, e: Vector2D -> obj.add(e) }
    }
  },
  BLACK {
    override fun turnAnt(ant: Ant) {
      ant.turnLeft()
    }

    override fun getFlipOperation(): BiConsumer<MutableSet<Vector2D>, Vector2D> {
      return BiConsumer<MutableSet<Vector2D>, Vector2D> { obj: MutableSet<Vector2D>, o: Vector2D -> obj.remove(o) }
    }
  };

  /**
   * Changes the given ant direction according to this cell type
   */
  abstract fun turnAnt(ant: Ant)
  abstract fun getFlipOperation(): BiConsumer<MutableSet<Vector2D>, Vector2D>
}