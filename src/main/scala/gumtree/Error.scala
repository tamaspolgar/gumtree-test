package gumtree

sealed trait Error

case class FileCanNotBeOpened(path: String) extends Error

sealed trait ParseError extends Error
case class InvalidLineFormat(line: String) extends ParseError
case class InvalidDateFormat(dateString: String) extends ParseError

case class NotFoundAddress(name: String) extends Error
