package extensions

import scala.language.implicitConversions

object Registry {

  implicit def getNewStringExtensions(str: String): StringExtensions = {
    new StringExtensions(str)
  }

  implicit def getNewCharExtensions(c: Char): CharExtensions = {
    new CharExtensions(c)
  }

}
