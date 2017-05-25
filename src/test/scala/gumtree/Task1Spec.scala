package gumtree

import org.scalatest.Matchers
import org.scalatest.WordSpec

class Task1Spec extends WordSpec with Matchers with TestValues {

  "countByGender" should {

    "return the count of different genders from the address book" in {
      Task1.countByGender("male", addressBook) shouldBe 3
      Task1.countByGender("female", addressBook) shouldBe 2
    }
  }
}
