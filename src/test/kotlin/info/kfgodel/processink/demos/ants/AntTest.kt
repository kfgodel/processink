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
class AntTest : KotlinSpec() {
  override fun define() {
    describe("a Langston ant") {
      val antDirection by let { 0 x 1 }
      val ant by let { Ant.create(1 x 1, antDirection()) }

      it("has a position") {
        assertThat(ant().position()).isEqualTo(1 x 1)
      }
      it("has a direction") {
        assertThat(ant().direction()).isEqualTo(0 x 1)
      }
      it("has a next position based on its current direction and position") {
        assertThat(ant().nextPosition()).isEqualTo(1 x 2)
      }

      it("moves to its next position when advanced") {
        ant().advance()
        assertThat(ant().position()).isEqualTo(1 x 2)
      }

      describe("when pointing up") {
        antDirection { 0 x -1 }
        it("points to the right if turned right") {
          ant().turnRight()
          assertThat(ant().direction()).isEqualTo(1 x 0)
        }
        it("points to the left if turned left") {
          ant().turnLeft()
          assertThat(ant().direction()).isEqualTo(-1 x 0)
        }
      }

      describe("when pointing down") {
        antDirection { 0 x 1 }
        it("points to the left if turned right") {
          ant().turnRight()
          assertThat(ant().direction()).isEqualTo(-1 x 0)
        }
        it("points to the right if turned left") {
          ant().turnLeft()
          assertThat(ant().direction()).isEqualTo(1 x 0)
        }
      }

      describe("when pointing left") {
        antDirection { 1 x 0 }
        it("points down if turned right") {
          ant().turnRight()
          assertThat(ant().direction()).isEqualTo(0 x 1)
        }
        it("points up if turned left") {
          ant().turnLeft()
          assertThat(ant().direction()).isEqualTo(0 x -1)
        }
      }

      describe("when pointing right") {
        antDirection { -1 x 0 }
        it("points up if turned right") {
          ant().turnRight()
          assertThat(ant().direction()).isEqualTo(0 x -1)
        }
        it("points down if turned left") {
          ant().turnLeft()
          assertThat(ant().direction()).isEqualTo(0 x 1)
        }
      }

    }
  }
}