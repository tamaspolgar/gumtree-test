package gumtree

import org.scalatest.Matchers
import org.scalatest.WordSpec

class Task2Spec extends WordSpec with Matchers with TestValues {

  "getAnOldestPerson" should {

    "return the first oldest person" in {
      Task2.getAnOldestPerson(addressBook) shouldBe Some("Wes Jackson")
    }

    "return None if the no addresses in the list" in {
      Task2.getAnOldestPerson(Nil) shouldBe None
    }
  }

  "getAllOldestPersons" should {

    "return all the oldest people" in {
      Task2.getAllOldestPeople(addressBook) shouldBe List("Wes Jackson", "Same Age As Wes")
    }
  }
}
