package extensions

import extensions.Registry.{getNewIntExtensions, getNewStringExtensions}
import models.{Client, Person}

object ListExtensions {

  implicit class PersonListExtensions(personsList: List[Person]) {

    def validate(): List[Person] = {
      personsList.filter(_.age.isValidAge())
        .filter(_.phone.isValidPhoneNumber())
        .filter(_.email.isValidEmail())
    }

  }

  implicit class ClientListExtensions(clientsList: List[Client]) {

    def validate(): List[Client] = {
      clientsList.filter(_.age.isValidAge())
        .filter(_.phone.isValidPhoneNumber())
        .filter(_.email.isValidEmail())
    }

  }
}
