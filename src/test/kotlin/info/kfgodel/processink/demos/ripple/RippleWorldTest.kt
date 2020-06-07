package info.kfgodel.processink.demos.ripple

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.ext.x
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

/**
 * Date: 6/5/20 - 00:49
 */
@RunWith(JavaSpecRunner::class)
class RippleWorldTest : KotlinSpec() {
  override fun define() {
    describe("a ripple world") {
      val clock by let { mockk<WorldClock>(relaxed = true) }
      val rippleWorld by let { RippleWorld.create(clock()) }

      it("has a default lifespan for ripples") {
        assertThat(rippleWorld().rippleLifespan()).isEqualTo(TimeQuantity.of(2, TimeUnit.SECONDS))
      }

      it("starts with no ripples") {
        assertThat(rippleWorld().ripples()).isEmpty()
      }

      describe("when the mouse is clicked") {
        beforeEach {
          rippleWorld().mouseClickedOn(1 x 2)
        }
        it("creates a new ripple") {
          assertThat(rippleWorld().ripples()).hasSize(1)
        }
        it("centers the ripple on the clicked position") {
          assertThat(rippleWorld().ripples().first().position()).isEqualTo(1 x 2)
        }
        it("keeps the ripple during its lifespan") {
          rippleWorld().removeDeadRipples()
          assertThat(rippleWorld().ripples()).hasSize(1)
        }
        describe("when the ripple lifespan has ended") {
          beforeEach {
            val momentAfterLifespanEnd: Long = rippleWorld().rippleLifespan().toMillis() + 1
            every { clock().currentMillis() } returns momentAfterLifespanEnd
          }

          it("removes the dead ripple") {
            rippleWorld().removeDeadRipples()
            assertThat(rippleWorld().ripples()).hasSize(0)
          }
        }
      }
    }
  }
}