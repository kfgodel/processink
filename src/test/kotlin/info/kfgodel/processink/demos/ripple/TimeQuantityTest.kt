package info.kfgodel.processink.demos.ripple

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

/**
 * Date: 6/5/20 - 00:49
 */
@RunWith(JavaSpecRunner::class)
class TimeQuantityTest : KotlinSpec() {
  override fun define() {
    describe("a time quantity") {
      val quantity by let { TimeQuantity.of(3, TimeUnit.DAYS) }

      it("has an amount") {
        assertThat(quantity().amount()).isEqualTo(3)
      }
      it("has a unit") {
        assertThat(quantity().unit()).isEqualTo(TimeUnit.DAYS)
      }
      it("can be converted to milliseconds") {
        assertThat(quantity().toMillis()).isEqualTo(3 /*dias*/ * 24 /*horas*/ * 60 /*minutos*/ * 60 /*seg*/ * 1000 /*millis*/.toLong())
      }
    }
  }
}