import extensions.CSVHandlers.StringExt
import extensions.Registry.{getNewIntExtensions, getNewStringExtensions}
import extensions.ListExtensions.{ClientListExtensions, PersonListExtensions}
import extensions.ObjectTypeChangingExtensions.{SwitchFromClientToUserObject, SwitchFromPersonToUserObject}
import models.{Client, Person, User}
import services.{DataLocationReader, ReadDataFromExcel, ReadDataFromJson}

import scala.io.Source

object Start {

  def main(args: Array[String]): Unit = {
    /*
    println("anafa.hyams@gmail.com".isValidEmail())
    println("anafa.hyams@gmail.com3".isValidEmail())
    println("anafa.hyamsgmail.com".isValidEmail())
    println("anafa.hyams@gmail".isValidEmail())

    println("---------------------------------")

    println("anafa.hyams@gmail".isValidPhoneNumber())
    println("+1 (997) 411-3097".isValidPhoneNumber())
    println("+1 ?997) 411-3097".isValidPhoneNumber())
    println("+1 (?)997) 411-309a".isValidPhoneNumber())

    println("---------------------------------")

    val negativeAge: Int = -1
    println(1.isValidAge())
    println(negativeAge.isValidAge())

    println("*********************************************************")
*/

  val clientsFileName = DataLocationReader.clientFileName
  val personsFileName = DataLocationReader.personFileName
  val requestFileName = DataLocationReader.requestFileName

    val clientsListFromExcel: List[Client] = ReadDataFromExcel.readData(clientsFileName)
    val personsListFromJson: List[Person] = ReadDataFromJson.readData(personsFileName)

/*
    //PersonsList
    val personsCSV = Source.fromFile("data/persons.csv").getLines().toList
    val personsList = personsCSV.map(person => person.getPerson(","))
    personsList.foreach(person => println(person))
*/

      // Request
    val requestCSV = Source.fromFile(requestFileName).getLines().toList
    val requestList = requestCSV.map(request => request.getRequest(","))
    //requestList.foreach(person => println(person))
    val request = requestList.head

    // valid persons and clients list
    val validClientsList: List[Client] = clientsListFromExcel.validate()
    val validPersonsList: List[Person] = personsListFromJson.validate()

    // creating users list from persons and clients list
    val personsUsersList: List[User] = validPersonsList.map(person => SwitchFromPersonToUserObject(person))
    val clientsUsersList: List[User] = validClientsList.map(client => SwitchFromClientToUserObject(client))

    //var userList: List[User] = Nil
    val userList: List[User] = personsUsersList ::: clientsUsersList

    // Task 3: Filter by age minimum value, maximum value in two tables
    val listOfUsersWithAgeBetween: List[User] = userList.filter(user => user.age > request.minAge)
      .filter(user => user.age < request.maxAge)
    println("Task 3:")
    println("Filter by age minimum value, maximum value in two tables")
    println(s"There are ${listOfUsersWithAgeBetween.length} users with age between ${request.minAge} to ${request.maxAge}")

    println("Task 4:")
    val listOfUsersStartsWithePrefix: List[User] = userList.filter(user => user.firstName.startsWith(request.prefixName))
    println("Get all people whose names start with a certain prefix. As like in request.json")
    println(s"There are ${listOfUsersStartsWithePrefix.length} users with Prefix name ${request.prefixName}")


    println("Task 5:")
    println("From the client table, get all married men who have more than 2 children. Search by fields: marital status, gender and number of Children")
    val clientMarriedMenWith2ChildrenList: List[Client] = validClientsList.filter(client => client.maritalStatus.toLowerCase == request.maritalStatus)
      .filter(client => client.gender.toLowerCase == request.gender)
      .filter(client => client.numberOfChildren == request.numberOfChildren)
    println(s"There are ${clientMarriedMenWith2ChildrenList.length} ${request.maritalStatus} ${request.gender} clients with ${request.numberOfChildren} children")

    //val filteredUsersListByRequest: List[User] = userList.filter(user => user.filterByRequest(request))
    //val clientsListBy_MS_G_NOC: List[Client] = validClientsList.filter(client => client.filterByRequest(request)) // last task
    val personFirst = validPersonsList.head
  }

}
