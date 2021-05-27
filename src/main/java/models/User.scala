package models

import scala.collection.mutable.ListBuffer

trait User {
  val firstName: String
  val lastName: String
  val gender: String
  val age: Int
  val email: String
  val phoneNumber: String

  //def filterByRequest(request: Request)

  def filterByRequest(request: Request): Boolean = {
    //val filteredListByRequest = new ListBuffer[User]()
    //filteredListByRequest += this
    request match {
      case Request(minAge,maxAge,gender,prefixName,maritalStatus,numberOfChildren) =>
        (checkAgeBetween(minAge, maxAge)
          && checkGender(gender)
          && checkPrefixFirstName(prefixName)
          && checkClientMaritalStatus(maritalStatus)
          && checkClientNumOfChildren(numberOfChildren))
      case Request(_,maxAge,gender,prefixName,maritalStatus,numberOfChildren) =>
        (checkAgeBelow(maxAge)
          && checkGender(gender)
          && checkPrefixFirstName(prefixName)
          && checkClientMaritalStatus(maritalStatus)
          && checkClientNumOfChildren(numberOfChildren))
      case Request(_,_,gender,prefixName,maritalStatus,numberOfChildren) =>
        (checkGender(gender)
          && checkPrefixFirstName(prefixName)
          && checkClientMaritalStatus(maritalStatus)
          && checkClientNumOfChildren(numberOfChildren))
      case Request(_,_,_,prefixName,maritalStatus,numberOfChildren) =>
        (checkPrefixFirstName(prefixName)
          && checkClientMaritalStatus(maritalStatus)
          && checkClientNumOfChildren(numberOfChildren))
      case Request(_,_,_,_,maritalStatus,numberOfChildren) =>
        (checkClientMaritalStatus(maritalStatus)
          && checkClientNumOfChildren(numberOfChildren))
      case Request(_,_,_,_,_,numberOfChildren) =>
        checkClientNumOfChildren(numberOfChildren)

      case Request(minAge,_,gender,prefixName,maritalStatus,numberOfChildren) =>
        (checkAgeAbove(minAge)
          && checkGender(gender)
          && checkPrefixFirstName(prefixName)
          && checkClientMaritalStatus(maritalStatus)
          && checkClientNumOfChildren(numberOfChildren))
      case Request(minAge,_,_,prefixName,maritalStatus,numberOfChildren) =>
        (checkAgeAbove(minAge)
          && checkPrefixFirstName(prefixName)
          && checkClientMaritalStatus(maritalStatus)
          && checkClientNumOfChildren(numberOfChildren))
      case Request(minAge,_,_,_,maritalStatus,numberOfChildren) =>
        (checkAgeAbove(minAge)
          && checkClientMaritalStatus(maritalStatus)
          && checkClientNumOfChildren(numberOfChildren))
      case Request(minAge,_,_,_,_,numberOfChildren) =>
        (checkAgeAbove(minAge)
          && checkClientNumOfChildren(numberOfChildren))
      case Request(minAge,_,_,_,_,_) =>
        checkAgeAbove(minAge)

      case Request(minAge,maxAge,_,prefixName,maritalStatus,numberOfChildren) =>
        (checkAgeBetween(minAge, maxAge)
          && checkPrefixFirstName(prefixName)
          && checkClientMaritalStatus(maritalStatus)
          && checkClientNumOfChildren(numberOfChildren))
      case Request(minAge,maxAge,_,_,maritalStatus,numberOfChildren) =>
        (checkAgeBetween(minAge, maxAge)
          && checkClientMaritalStatus(maritalStatus)
          && checkClientNumOfChildren(numberOfChildren))
      case Request(minAge,maxAge,_,_,_,numberOfChildren) =>
        (checkAgeBetween(minAge, maxAge)
          && checkClientNumOfChildren(numberOfChildren))
      case Request(minAge,maxAge,_,_,_,_) =>
        checkAgeBetween(minAge, maxAge)

      case Request(minAge,maxAge,gender,_,maritalStatus,numberOfChildren) =>
        (checkAgeBetween(minAge, maxAge)
          && checkGender(gender)
          && checkClientMaritalStatus(maritalStatus)
          && checkClientNumOfChildren(numberOfChildren))

      case Request(minAge,maxAge,gender,_,_,numberOfChildren) =>
        (checkAgeBetween(minAge, maxAge)
          && checkGender(gender)
          && checkClientNumOfChildren(numberOfChildren))
      case Request(minAge,maxAge,gender,_,_,_) =>
        (checkAgeBetween(minAge, maxAge)
          && checkGender(gender))

      case Request(minAge,maxAge,gender,prefixName,_,numberOfChildren) =>
        (checkAgeBetween(minAge, maxAge)
          && checkGender(gender)
          && checkPrefixFirstName(prefixName)
          && checkClientNumOfChildren(numberOfChildren))
      case Request(minAge,maxAge,gender,prefixName,_,_) =>
        (checkAgeBetween(minAge, maxAge)
          && checkGender(gender)
          && checkPrefixFirstName(prefixName))

      case Request(minAge,maxAge,gender,prefixName,maritalStatus,_) =>
        (checkAgeBetween(minAge, maxAge)
          && checkGender(gender)
          && checkPrefixFirstName(prefixName)
          && checkClientMaritalStatus(maritalStatus))

      case Request(_,_,_,_,_,_) => true

    }

    //filteredListByRequest.toList
  }

  private def checkClientNumOfChildren(numberOfChildren: Int): Boolean = {
    checkIfClientInstance() && this.asInstanceOf[Client].numberOfChildren == numberOfChildren
  }

  private def checkClientMaritalStatus(maritalStatus: String): Boolean = {
    checkIfClientInstance() && this.asInstanceOf[Client].maritalStatus == maritalStatus
  }

  private def checkIfClientInstance(): Boolean = {
    this.isInstanceOf[Client]
  }

  private def checkPrefixFirstName(prefixName: String): Boolean = {
    this.firstName.startsWith(prefixName)
  }

  private def checkGender(gender: String): Boolean = {
    this.gender == gender
  }

  private def checkAgeBetween(minAge: Int, maxAge: Int): Boolean = {
    checkAgeAbove(minAge) && checkAgeBelow(maxAge)
  }

  private def checkAgeBelow(maxAge: Int): Boolean = {
    this.age <= maxAge
  }

  private def checkAgeAbove(minAge: Int): Boolean = {
    this.age >= minAge
  }
}