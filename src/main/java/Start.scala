import extensions.Handlers.StringExt
import extensions.Registry.{getNewIntExtensions, getNewStringExtensions}
import models.{Client, Person}
import services.{ReadDataFromExcel, ReadDataFromJson}

import scala.io.Source

object Start {

  def main(args: Array[String]): Unit = {

    //val path = "examples/src/main/resources/people.json"
    //val peopleDF = spark.read.json(path)


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

    println("Read data from excel")
    val clientsListFromExcel: List[Client] = ReadDataFromExcel.readData()
    println("end reading data from excel")

    println("Read data from json")
    val personsListFromJson: List[Person] = ReadDataFromJson.readData()
    println("end reading data from json")


    //PersonsList
    val personsCSV = Source.fromFile("data/persons.csv").getLines().toList
    val personsList = personsCSV.map(person => person.getPerson(","))
    personsList.foreach(person => println(person))

    // Request
    val requestCSV = Source.fromFile("data/request.csv").getLines().toList
    val requestList = requestCSV.map(request => request.getRequest(","))
    //requestList.foreach(person => println(person))
    val request = requestList.head


  }

}
