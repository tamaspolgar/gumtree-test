package gumtree

import org.scalatest.Matchers
import org.scalatest.WordSpec

class Task3Spec extends WordSpec with Matchers with TestValues {

  "getAgeDifference" should {

    "return the difference between two people's birth date" in {
      Task3.getAgeDifference("Bill McKnight", "Paul Robinson", addressBook) shouldBe Right(
        2862
      )
    }

    "return NoAddressFound if any of the given people's is not found" in {
      Task3.getAgeDifference("Unknown Person", "Paul Robinson", addressBook) shouldBe Left(
        NotFoundAddress("Unknown Person")
      )
      Task3.getAgeDifference("Bill McKnight", "Unknown Person", addressBook) shouldBe Left(
        NotFoundAddress("Unknown Person")
      )
    }
  }
}
