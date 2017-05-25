package gumtree

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import cats.instances.either._
import cats.instances.list._
import cats.syntax.EitherSyntax
import cats.syntax.traverse._

import scala.io.Source
import scala.util.Try

trait Support extends EitherSyntax {

  val DefaultFileName = "AddressBook"

  def loadInputData(fileName: String) = for {
    lines <- readLinesFromFile(fileName)
    addresses <- parseLines(lines)
  } yield addresses

  private def readLinesFromFile(fileName: String): Either[FileCanNotBeOpened, List[String]] = {
    Try(Source.fromFile(fileName).getLines().toList)
      .toEither
      .leftMap(_ => FileCanNotBeOpened(fileName))
  }

  private def parseLines(rawLines: List[String]): Either[Error, List[Address]] = {
    rawLines
      .map(parseSingleLine)
      .sequenceU
  }

  private def parseSingleLine(rawLine: String): Either[ParseError, Address] = {
    for {
      rawParts <- parseLineParts(rawLine)
      birthDate <- parseBirthDate(rawParts.birthDate)
    } yield {
      Address(rawParts.name, rawParts.gender, birthDate)
    }
  }

  private def parseLineParts(rawLine: String): Either[InvalidLineFormat, RawLineParts] = {
    val addressRecord = "(.+), (.+), (.*)".r
    rawLine match {
      case addressRecord(name, gender, birthDate) => Right(RawLineParts(name, gender, birthDate))
      case invalidLine => Left(InvalidLineFormat(invalidLine))
    }
  }

  private def parseBirthDate(birthDateString: String): Either[InvalidDateFormat, LocalDate] = {
    val localDateFormat = DateTimeFormatter.ofPattern("dd/MM/yy")
    Try(LocalDate.parse(birthDateString, localDateFormat))
      .toEither
      .map(adjustBirthDate)
      .leftMap(_ => InvalidDateFormat(birthDateString))
  }

  private def adjustBirthDate(birthDate: LocalDate): LocalDate = {
    if (birthDate.isAfter(LocalDate.now())) {
      birthDate.minusYears(100)
    } else {
      birthDate
    }
  }

  private case class RawLineParts(name: String, gender: String, birthDate: String)
}