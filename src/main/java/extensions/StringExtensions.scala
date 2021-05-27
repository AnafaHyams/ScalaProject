package extensions

class StringExtensions(str: String) {

  def isValidPhoneNumber(): Boolean = {
    val validPhoneFormat = """^(\d{3}[-])(\d{4}[-])\d{2}$|^(\+\d{1,3}( )?)?((\(\d{3}\))|\d{3})[- .]?\d{3}[- .]?\d{4}$"""
    str.matches(validPhoneFormat)
  }

  def isValidEmail(): Boolean = {
    val validEmailFormat = """^[a-zA-Z0-9\.!#$%&'+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)$"""
    str.matches(validEmailFormat)
  }

}
