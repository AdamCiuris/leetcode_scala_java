import org.scalatest.matchers.should.Matchers
import org.scalatest.flatspec.AnyFlatSpec

class AddTwoNumbers extends AnyFlatSpec with Matchers {
  behavior of "test"
  it should "run" in {
    println("TEST TEST TEST TEST TEST TEST TEST TEST TEST " +
      "TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST ")
    true shouldBe true
  }
}
