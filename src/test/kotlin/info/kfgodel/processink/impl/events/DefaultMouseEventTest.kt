package info.kfgodel.processink.impl.events

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.api.ext.x
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith
import processing.event.MouseEvent

/**
 * This test verifies the api a mouse event offers on top of processing
 * Date: 6/6/20 - 23:21
 */
@RunWith(JavaSpecRunner::class)
class DefaultMouseEventTest : KotlinSpec() {
  override fun define() {
    describe("a mouse event") {
      val event by let { DefaultMouseEvent(MouseEvent(Object(),100,1,2,320,240,3,4)) }

      it("has a position"){
        assertThat(event().position).isEqualTo(320 x  240)
      }
    }
  }

}