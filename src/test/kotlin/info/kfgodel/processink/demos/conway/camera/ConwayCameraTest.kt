package info.kfgodel.processink.demos.conway.camera

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.ext.x
import info.kfgodel.processink.demos.conway.world.ConwayWorld
import info.kfgodel.processink.demos.conway.world.FieldOfView
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * Date: 23/5/20 - 23:29
 */
@RunWith(JavaSpecRunner::class)
class ConwayCameraTest : KotlinSpec() {
  override fun define() {
    describe("a cell state") {
      val conwayWorld by let { ConwayWorld.create(1.0 x 1.0) }
      val camera by let { ConwayCamera.create(0.0 x 0.0, 100.0 x 80.0, conwayWorld()) }

      it("targets a cell position of the conways world") { 
        assertThat(camera().target()).isEqualTo(0.0 x 0.0)
      }

      it("has a limited size") {
        assertThat(camera().size()).isEqualTo(100.0 x 80.0)
      }

      describe("when capturing a snapshot") {
        val snapshot by let { camera().takeSnapshot() }

        it("limits snapshot dimension to its size") {
          assertThat(snapshot().dimension()).isEqualTo(camera().size())
        }

        it("captures the state of the cells at its observable area") {
          conwayWorld { mockk<ConwayWorld>(relaxed = true) }
          camera().takeSnapshot()

          verify { conwayWorld().getStateInside(FieldOfView.create(-50.0 x -40.0, 50.0 x 40.0)) }
        }

        describe("when a cell is in the frame") {
          it("makes its position relative to the snapshot") {
            val positionRelativeToSnapshot = snapshot().survivingCells().get(0)
            assertThat(positionRelativeToSnapshot).isEqualTo(51.0 x 41.0)
          }
        }
      }

    }
  }
}