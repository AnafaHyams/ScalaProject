package extensions

import models.{Client, Person}

import scala.language.implicitConversions

object Registry {

  implicit def getNewStringExtensions(str: String): StringExtensions = {
    new StringExtensions(str)
  }

  implicit def getNewCharExtensions(c: Char): CharExtensions = {
    new CharExtensions(c)
  }

  implicit def getNewIntExtensions(num: Int): IntExtensions = {
    new IntExtensions(num)
  }

  implicit def getNewPersonListExtensions(personsList: List[Person]): PersonListExtensions = {
    new PersonListExtensions(personsList)
  }

  implicit def getNewClientListExtensions(clientList: List[Client]): ClientListExtensions = {
    new ClientListExtensions(clientList)
  }

}
