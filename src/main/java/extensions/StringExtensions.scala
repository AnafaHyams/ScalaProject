package extensions

import extensions.Registry.getNewCharExtensions

class StringExtensions(str: String) {

  def isValidPhoneNumber(): Boolean = {
    var stringIsValidPhoneNumber: Boolean = true

    str.foreach(char => {
      val charIsValidPhoneNumber = char.isDigit || char.isValidCharForPhoneNumber()
      stringIsValidPhoneNumber = stringIsValidPhoneNumber && charIsValidPhoneNumber
    })

    stringIsValidPhoneNumber
  }

  def isValidEmail(): Boolean = {
    var stringIsValidEmail: Boolean = false

    if(str.endsWith(".com") && str.contains("@")) {
      stringIsValidEmail = true
    }

    stringIsValidEmail
  }

}
