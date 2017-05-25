package gumtree

import org.scalatest.Matchers
import org.scalatest.WordSpec

class Task2Spec extends WordSpec with Matchers with TestValues {

  "getAnOldestPerson" should {

    "return the first oldest person" in {
      Task2.getAnOldestPerson(addressBook) shouldBe "Wes Jackson"
    }
  }

  "getAllOldestPersons" should {

    "return all the oldest people" in {
      Task2.getAllOldestPeople(addressBook) shouldBe List("Wes Jackson", "Same Age As Wes")
    }
  }
}
