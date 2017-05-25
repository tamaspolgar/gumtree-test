package gumtree

import org.scalatest.Matchers
import org.scalatest.WordSpec

class SupportSpec extends WordSpec with Matchers with Support with TestValues {

  "loadInputData" should {

    "return list with lines if the file is not empty" in {
      loadInputData("src/test/resources/valid-address-book.txt") shouldBe Right(addressBook)
    }

    "return FileCanNotBeOpened if the file doesn't exist" in {
      loadInputData("src/test/resources/non-existing-file.txt") shouldBe Left(
        FileCanNotBeOpened("src/test/resources/non-existing-file.txt")
      )
    }

    "return InvalidLineFormat if the file contains invalid line" in {
      loadInputData("src/test/resources/with-invalid-line-format.txt") shouldBe Left(
        InvalidLineFormat("invalid line format")
      )
    }

    "return InvalidDateFormat if the file contains invalid line" in {
      loadInputData("src/test/resources/with-invalid-date-format.txt") shouldBe Left(
        InvalidDateFormat("invalidDate")
      )
    }
  }
}
