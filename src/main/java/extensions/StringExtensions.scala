package extensions

import extensions.Registry.getNewCharExtensions

class StringExtensions(str: String) {

  def isValidPhoneNumber(): Boolean = {
    var stringIsValidPhoneNumber: Boolean = true

    val validPhoneFormat = """^(\d{3}[-])(\d{4}[-])\d{2}$|^(\+\d{1,3}( )?)?((\(\d{3}\))|\d{3})[- .]?\d{3}[- .]?\d{4}$"""
    str.matches(validPhoneFormat)

    /*str.foreach(char => {
      val charIsValidPhoneNumber = char.isDigit || char.isValidCharForPhoneNumber()
      stringIsValidPhoneNumber = stringIsValidPhoneNumber && charIsValidPhoneNumber
    })*/

    //stringIsValidPhoneNumber
  }

  def isValidEmail(): Boolean = {
    var stringIsValidEmail: Boolean = false

    val validEmailFormat = """^[a-zA-Z0-9\.!#$%&'+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)$"""
    str.matches(validEmailFormat)

    /*if(str.endsWith(".com") && str.contains("@")) {
      stringIsValidEmail = true
    }

    stringIsValidEmail*/
  }

}
