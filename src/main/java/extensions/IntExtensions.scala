package extensions

class IntExtensions(age: Int) {

  def isValidAge(): Boolean = {

    val ageIsNotNegativeNumber: Boolean = age >= 0

    ageIsNotNegativeNumber
  }

}
