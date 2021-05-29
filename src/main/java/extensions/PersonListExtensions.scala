package extensions

import extensions.Registry.{getNewIntExtensions, getNewStringExtensions}
import models.Person

class PersonListExtensions(personsList: List[Person]) {

  def validate(): List[Person] = {
    personsList.filter(_.age.isValidAge())
      .filter(_.phone.isValidPhoneNumber())
      .filter(_.email.isValidEmail())
  }

}
