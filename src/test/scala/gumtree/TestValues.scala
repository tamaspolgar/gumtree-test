package gumtree

import java.time.LocalDate

trait TestValues {
  val addressBook = List(
    Address("Bill McKnight", "Male", LocalDate.of(1977, 3, 16)),
    Address("Paul Robinson", "Male", LocalDate.of(1985, 1, 15)),
    Address("Gemma Lane", "Female", LocalDate.of(1991, 11, 20)),
    Address("Sarah Stone", "Female", LocalDate.of(1980, 9, 20)),
    Address("Wes Jackson", "Male", LocalDate.of(1974, 8, 14)),
    Address("Young Person", "NA", LocalDate.of(2017, 1, 1)),
    Address("Same Age As Wes", "NA", LocalDate.of(1974, 8, 14))
  )
}
