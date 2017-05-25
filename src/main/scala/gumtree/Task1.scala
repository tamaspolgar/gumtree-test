package gumtree

object Task1 extends App with Support {

  def countByGender(gender: String, addresses: List[Address]): Int = {
    addresses.count(_.gender.equalsIgnoreCase(gender))
  }

  def runTask = {
    for {
      addresses <- loadInputData(DefaultFileName)
    } yield {
      println(s"Task 1: How many males are in the address book?")
      println(countByGender("male", addresses))
    }
  }.leftMap(println)

  runTask
}