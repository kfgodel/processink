package info.kfgodel.processink.demos.conway.camera

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.ext.x
import info.kfgodel.processink.demos.conway.world.ConwayWorld
import info.kfgodel.processink.demos.conway.world.FieldOfView
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * Date: 23/5/20 - 23:29
 */
@RunWith(JavaSpecRunner::class)
class ConwayCameraTest : KotlinSpec() {
  override fun define() {
    describe("a conway camera") {
      val camera by let { ConwayCamera.create(0.0 x 0.0, 100.0 x 80.0) }

      describe("when capturing a snapshot") {
        val conwayWorld by let { ConwayWorld.create() }
        val snapshot by let { camera().takeSnapshot(conwayWorld()) }

        it("limits snapshot dimension to its size") {
          assertThat(snapshot().dimension()).isEqualTo(100 x 80)
        }

        it("projects a field of view around the target position limited to its size") {
          conwayWorld { mockk<ConwayWorld>(relaxed = true) }
          val fieldOfView = slot<FieldOfView>()
          every {
            conwayWorld().getStateInside(capture(fieldOfView))
          } returns mockk(relaxed = true)

          camera().takeSnapshot(conwayWorld())

          assertThat(fieldOfView.captured.topLeft()).isEqualTo(-50 x -40)
          assertThat(fieldOfView.captured.bottomRight()).isEqualTo(50 x 40)
        }

        describe("when there are no active cells in the frame") {
          it("has no surviving cells") {
            assertThat(snapshot().survivingCells()).isEmpty()
          }
          it("has no dying cells") {
            assertThat(snapshot().dyingCells()).isEmpty()
          }
          it("has no emerging cells") {
            assertThat(snapshot().emergingCells()).isEmpty()
          }
        }

        describe("when cells are in the frame") {
          conwayWorld { ConwayWorld.create(
            0 x 0, 0 x 1, 0 x 2
          ) }

          it("makes their position relative to the camera") {
            assertThat(snapshot().survivingCells()).containsExactlyInAnyOrder(50 x 40, 50 x 41, 50 x 42)
          }

          describe("and they change their state") {
            beforeEach {
              conwayWorld().advanceOneGeneration()
            }

            it("captures surviving cells") {
              assertThat(snapshot().survivingCells()).containsExactlyInAnyOrder(50 x 41)
            }
            it("captures dying cells") {
              assertThat(snapshot().dyingCells()).containsExactlyInAnyOrder(50 x 40, 50 x 42)
            }
            it("captures emerging cells") {
              assertThat(snapshot().emergingCells()).containsExactlyInAnyOrder(49 x 41, 51 x 41)
            }

          }
        }
      }

    }
  }
}