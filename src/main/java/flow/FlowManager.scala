package flow

import extensions.ObjectTypeChangingExtensions.{SwitchFromClientToUserObject, SwitchFromPersonToUserObject}
import extensions.Registry.{getNewClientListExtensions, getNewPersonListExtensions}
import models.{Client, Person, Request, User}
import services.{DataLocationReader, ReadDataFromExcel, ReadDataFromJson}


object FlowManager {

  def usersFlowManager(): Unit = {
    val clientsFileName = DataLocationReader.clientFileName
    val personsFileName = DataLocationReader.personFileName
    val requestFileName = DataLocationReader.requestFileName

    // valid persons and clients list
    val validClientsList: List[Client] = ReadDataFromExcel.readData(clientsFileName).validate()
    val validPersonsList: List[Person] = ReadDataFromJson.readData(personsFileName).validate()

    // Request
    val request: Request = ReadDataFromJson.readRequestData(requestFileName)

    // creating users list from persons and clients list
    val personsUsersList: List[User] = validPersonsList.map(person => SwitchFromPersonToUserObject(person))
    val clientsUsersList: List[User] = validClientsList.map(client => SwitchFromClientToUserObject(client))
    val userList: List[User] = personsUsersList ::: clientsUsersList

    // Task 3: Filter by age minimum value, maximum value in two tables
    val listOfUsersWithAgeBetween: List[User] = userList.filter(user => user.age > request.minAge)
      .filter(user => user.age < request.maxAge)
    println("Task 3:")
    println("Filter by age minimum value, maximum value in two tables")
    println(s"There are ${listOfUsersWithAgeBetween.length} users with age between ${request.minAge} to ${request.maxAge}")
    printFilteredUserList(listOfUsersWithAgeBetween)

    println("---------------------------------------------------------------------------------------")

    println("Task 4:")
    val listOfUsersStartsWithePrefix: List[User] = userList.filter(user => user.firstName.startsWith(request.prefixName))
    println("Get all people whose names start with a certain prefix. As like in request.json")
    println(s"There are ${listOfUsersStartsWithePrefix.length} users with Prefix name ${request.prefixName}")
    printFilteredUserList(listOfUsersStartsWithePrefix)

    println("---------------------------------------------------------------------------------------")

    println("Task 5:")
    println("From the client table, get all married men who have more than 2 children. Search by fields: marital status, gender and number of Children")
    val clientMarriedMenWith2ChildrenList: List[Client] = validClientsList.filter(client => client.maritalStatus.toLowerCase == request.maritalStatus)
      .filter(client => client.gender.toLowerCase == request.gender)
      .filter(client => client.numberOfChildren == request.numberOfChildren)
    println(s"There are ${clientMarriedMenWith2ChildrenList.length} ${request.maritalStatus} ${request.gender} clients with ${request.numberOfChildren} children")
    clientMarriedMenWith2ChildrenList.foreach(client => println(client))

    println("---------------------------------------------------------------------------------------")

    //println("Filter By Request:")
    //val filteredUsersListByRequest: List[User] = userList.filter(user => user.filterByRequest(request))
    //println(s"There are ${filteredUsersListByRequest.length} ${request.maritalStatus} ${request.gender} clients between age ${request.minAge} to ${request.maxAge} with ${request.numberOfChildren} children that there name start with ${request.prefixName}")

  }

  def printFilteredUserList(filteredList: List[User]): Unit = {
    filteredList.foreach(user => {
      user match {
        case client: SwitchFromClientToUserObject => //Client
          print(s"Client(${client.firstName},${client.lastName},")
        case person: SwitchFromPersonToUserObject => // Person
          print(s"Person(${person.firstName} ${person.lastName}")
      }

      println(s"${user.gender},${user.age},${user.email},${user.phoneNumber})")
    })
  }
}
