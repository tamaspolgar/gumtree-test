package gumtree

object Task3 extends App with Support {

  def getAgeDifference(name1: String, name2: String, addresses: List[Address]): Either[NotFoundAddress, Long] = {
    for {
      address1 <- findAddress(name1, addresses)
      address2 <- findAddress(name2, addresses)
    } yield {
      address2.birthDate.toEpochDay - address1.birthDate.toEpochDay
    }
  }

  private def findAddress(name: String, addresses: List[Address]): Either[NotFoundAddress, Address] = {
    addresses
      .find(_.name == name)
      .toRight(NotFoundAddress(name))
  }

  def runTask = {
    for {
      addresses <- loadInputData(DefaultFileName)
      ageDifference <- getAgeDifference("Bill McKnight", "Paul Robinson", addresses)
    } yield {
      println(s"Task 3: How many days older is Bill than Paul?")
      println(ageDifference)
    }
  }.leftMap(println)

  runTask
}