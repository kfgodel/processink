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
class RippleWaveTest : KotlinSpec() {
  override fun define() {
    describe("a ripple wave") {
      val clock by let { mockk<WorldClock>(relaxed = true) }
      val ripple by let { RippleWave.create(1 x 2, TimeQuantity.of(2, TimeUnit.SECONDS), clock()) }

      it("has a position") {
        assertThat(ripple().position()).isEqualTo(1 x 2)
      }

      it("starts with a 0 radius") {
        every { clock().currentMillis() } returns 0L andThen 0L // On creation and on radius invocation
        assertThat(ripple().radius()).isEqualTo(0.0f)
      }

      it("ends with a 200 radius at the end of its lifespan") {
        every { clock().currentMillis() } returns 0L andThen TimeUnit.SECONDS.toMillis(2) // On creation and on radius invocation
        assertThat(ripple().radius()).isEqualTo(200.0f)
      }

      it("is dead after its lifespan") {
        every { clock().currentMillis() } returns 0L andThen TimeUnit.SECONDS.toMillis(2)+1 // On creation and on radius invocation
        assertThat(ripple().isDead).isTrue()
      }

    }
  }
}