package gumtree

object Task2 extends App with Support {

  def getAnOldestPerson(addresses: List[Address]): String = {
    addresses.minBy(_.birthDate.toEpochDay).name
  }

  def getAllOldestPeople(addresses: List[Address]): List[String] = {
    val oldestBirthDate = addresses.minBy(_.birthDate.toEpochDay).birthDate
    addresses.filter(_.birthDate.equals(oldestBirthDate)).map(_.name)
  }

  def runTask = {
    for {
      addresses <- loadInputData(DefaultFileName)
    } yield {

      println(s"Task 2: Who is the oldest person in the address book?")
      println(getAnOldestPerson(addresses))

      println(s"Task 2b: Who are the oldest people in the address book?")
      println(getAllOldestPeople(addresses).mkString(", "))
    }
  }.leftMap(println)

  runTask
}