package hello.tests.info.kfgodel.processink.demos.ball

import info.kfgodel.jspek.api.JavaSpecRunner
import info.kfgodel.jspek.api.KotlinSpec
import info.kfgodel.mathe.impl.V1
import info.kfgodel.mathe.impl.V2
import info.kfgodel.processink.api.ext.vector.x
import info.kfgodel.processink.api.ext.vector.y
import info.kfgodel.processink.demos.ball.BouncingBall
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith

/**
 * This class verifies the expected behavior for a 1d float vector
 * Date: 5/5/20 - 00:00
 */
@RunWith(JavaSpecRunner::class)
class BouncingBallTest : KotlinSpec() {
  override fun define() {
    describe("a bouncing ball") {
      val ball by let { BouncingBall.createDefault() }
      
      it("has a default radius") {
        assertThat(ball().radius()).isEqualTo(V1(0.03))
      }
      it("has an default position") {
        assertThat(ball().position()).isEqualTo(V2(0.5, 0.5))
      }
      it("has a default velocity") {
        assertThat(ball().velocity()).isEqualTo(V2(0.02, 0.01))
      }
      it("changes the position when moved, according to velocity") {
        ball().move()
        val expectedPosition = V2(0.5 /* x position */ + 0.02 /* x velocity */, 0.5 + 0.01)
        assertThat(ball().position()).isEqualTo(expectedPosition)
      }

      it("has a diameter") {
        assertThat(ball().diameter()).isEqualTo(V1(0.06))
      }
      it("has a right x point") {
        assertThat(ball().rightSide()).isEqualTo(V1(0.5 /* x position */ + 0.03 /* radius */))
      }
      it("has a left x point") {
        assertThat(ball().leftSide()).isEqualTo(V1(0.5 /* x position */ - 0.03 /* radius */))
      }
      it("has a bottom y point") {
        assertThat(ball().bottomSide()).isEqualTo(V1(0.5 /* y position */ + 0.03 /* radius */))
      }
      it("has a top y point") {
        assertThat(ball().topSide()).isEqualTo(V1(0.5 /* y position */ - 0.03 /* radius */))
      }

      describe("when velocity is positive") {
        ball { BouncingBall.withVelocity(V2(0.1, 0.2)) }

        describe("when positioned on the farther left") {
          beforeEach {
            ball().positionOn(V2(V1.ONE - ball().radius(), 0.5))
          }
          it("x velocity becomes negative if moved") {
            ball().move()
            assertThat(ball().velocity().x()).isEqualTo(V1(-0.1f))
          }
          it("left side becomes 1.0 if moved") {
            ball().move()
            assertThat(ball().rightSide()).isEqualTo(V1.ONE)
          }
        }
        describe("when positioned on the farther bottom") {
          beforeEach {
            ball().positionOn(V2(0.5, V1.ONE - ball().radius()))
          }

          it("y velocity becomes negative if moved") {
            ball().move()
            assertThat(ball().velocity().y()).isEqualTo(V1(-0.2f))
          }
          it("bottom side becomes 1.0 if moved") {
            ball().move()
            assertThat(ball().bottomSide()).isEqualTo(V1.ONE)
          }
        }
      }
      describe("when velocity is negative") {
        ball  { BouncingBall.withVelocity(V2(-0.1, -0.2)) }

        describe("when positioned on the farther right") {
          beforeEach {
            ball().positionOn(V2(ball().radius(), 0.5))
          }
          it("x velocity becomes positive if moved") {
            ball().move()
            assertThat(ball().velocity().x()).isEqualTo(V1(0.1f))
          }
          it("top side becomes 0.0 if moved") {
            ball().move()
            assertThat(ball().leftSide()).isEqualTo(V1.ZERO)
          }
        }
        describe("when positioned on the farther top") {
          beforeEach {
            ball().positionOn(V2(0.5, ball().radius()))
          }
          it("y velocity becomes positive if moved") {
            ball().move()
            assertThat(ball().velocity().y()).isEqualTo(V1(0.2f))
          }
          it("top side becomes 0.0 if moved") {
            ball().move()
            assertThat(ball().topSide()).isEqualTo(V1.ZERO)
          }
        }
      }
    }
  }

}