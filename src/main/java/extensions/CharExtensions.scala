package extensions

class CharExtensions(c: Char) {

  def isValidCharForPhoneNumber(): Boolean = {
    var charIsValidAtPhoneNumber: Boolean = false

    if (c.equals(' ') || c.equals('+') || c.equals('-') || c.equals('(') || c.equals(')')) {
      charIsValidAtPhoneNumber = true
    }

    charIsValidAtPhoneNumber
  }

}
