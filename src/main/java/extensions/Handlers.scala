package extensions

import models.{Person, Request}

object Handlers {

  implicit class StringExt(str:String){
    def getPerson(delimiter: String): Person = {
      val personArr = str.split(delimiter)
      val person = Person(personArr(0).toInt,
          personArr(1),
          personArr(2),
          personArr(3),
          personArr(4),
          personArr(5),
          personArr(6))
      person
    }

    def getRequest(delimiter: String): Request = {
      val requestArr = str.split(delimiter)
      val request = Request(requestArr(0).toInt,
        requestArr(1).toInt,
        requestArr(2),
        requestArr(3),
        requestArr(4),
        requestArr(5).toInt)
      request
    }
  }
}
