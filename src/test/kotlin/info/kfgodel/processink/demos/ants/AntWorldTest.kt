package info.kfgodel.processink.demos.ants

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.ext.x
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * Date: 23/5/20 - 23:29
 */
@RunWith(JavaSpecRunner::class)
class AntWorldTest : KotlinSpec() {
  override fun define() {
    describe("an ant world") {

      val antWorld by let { AntWorld.create(10 x 10) }

      it("has a cell space") {
        assertThat(antWorld().cellSpace()).isEqualTo(10 x 10)
      }

      describe("initially") {
        it("has no black cells") {
          assertThat(antWorld().blackCells()).isEmpty()
        }

        it("has an ant in the center pointing upwards") {
          val ant: Ant = antWorld().ant()
          assertThat(ant.position()).isEqualTo(5 x 5)
          assertThat(ant.direction()).isEqualTo(0 x -1)
        }
      }

      describe("when ant is on a white cell and time advances") {
        beforeEach {
          antWorld().advanceOneTimeUnit()
        }
        it("flips its white cell to black") {
          val blackCells = antWorld().blackCells()
          assertThat(blackCells).containsOnly(5 x 5)
        }
        it("turns ant to right") {
          assertThat(antWorld().ant().direction()).isEqualTo(1 x 0)
        }
        it("advances the ant to its right cell") {
          assertThat(antWorld().ant().position()).isEqualTo(6 x 5)
        }
      }

      describe("when ant is on a black cell and time advances") {
        beforeEach {
          antWorld().setBlackCellOn(5 x 5)
          antWorld().advanceOneTimeUnit()
        }
        it("flips its black cell to white") {
          val blackCells = antWorld().blackCells()
          assertThat(blackCells).isEmpty()
        }
        it("turns ant to left") {
          assertThat(antWorld().ant().direction()).isEqualTo(-1 x 0)
        }
        it("advances the ant to its left cell") {
          assertThat(antWorld().ant().position()).isEqualTo(4 x 5)
        }
      }

      describe("when ant is on a leftmost white cell pointing upwards and time advances") {
        beforeEach {
          antWorld().replaceAntWith(Ant.create(9 x 5, 0 x -1))
          antWorld().advanceOneTimeUnit()
        }
        it("stays where it is") {
          assertThat(antWorld().ant().position()).isEqualTo(9 x 5)
        }
        it("still turns to the right") {
          assertThat(antWorld().ant().direction()).isEqualTo(1 x 0)
        }
        it("doesn't flip the cell color") {
          assertThat(antWorld().blackCells()).isEmpty()
        }
      }

      describe("when ant is on a rightmost white cell pointing downwards and time advances") {
        beforeEach {
          antWorld().replaceAntWith(Ant.create(0 x 5, 0 x 1))
          antWorld().advanceOneTimeUnit()
        }
        it("stays where it is") {
          assertThat(antWorld().ant().position()).isEqualTo(0 x 5)
        }
        it("still turns to the right") {
          assertThat(antWorld().ant().direction()).isEqualTo(-1 x 0)
        }
        it("doesn't flip the cell color") {
          assertThat(antWorld().blackCells()).isEmpty()
        }
      }

      describe("when ant is on a topmost white cell pointing leftwards and time advances") {
        beforeEach {
          antWorld().replaceAntWith(Ant.create(5 x 0, -1 x 0))
          antWorld().advanceOneTimeUnit()
        }
        it("stays where it is") {
          assertThat(antWorld().ant().position()).isEqualTo(5 x 0)
        }
        it("still turns to the right") {
          assertThat(antWorld().ant().direction()).isEqualTo(0 x -1)
        }
        it("doesn't flip the cell color") {
          assertThat(antWorld().blackCells()).isEmpty()
        }
      }

      describe("when ant is on a bottommost white cell pointing rightwards and time advances") {
        beforeEach {
          antWorld().replaceAntWith(Ant.create(5 x 9, 1 x 0))
          antWorld().advanceOneTimeUnit()
        }
        it("stays where it is") {
          assertThat(antWorld().ant().position()).isEqualTo(5 x 9)
        }
        it("still turns to the right") {
          assertThat(antWorld().ant().direction()).isEqualTo(0 x 1)
        }
        it("doesn't flip the cell color") {
          assertThat(antWorld().blackCells()).isEmpty()
        }
      }

    }
  }
}