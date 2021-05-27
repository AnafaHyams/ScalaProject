package services
import com.fasterxml.jackson.core.`type`.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import extensions.CSVHandlers.StringExt
import models.{Person, Request}

import scala.jdk.CollectionConverters.CollectionHasAsScala
import scala.jdk.CollectionConverters._
import java.io.File
import scala.io.Source

object ReadDataFromJson {

  val mapper: ObjectMapper = new ObjectMapper

  def readData(personsFileName: String): List[Person] = {
    //val jsonFile = new File("data/persons.json")

    //val personsList: List[Person] = mapper.readValue(jsonFile, new TypeReference[List[Person]]() {})
    //val personsList: List[Person] = mapper.readValue(jsonFile, new TypeReference[List[Person]]() {}).asJavaCollection.asScala.toList

    // JUST FOR NOW: READ Persons data from csv file and return persons list
    val personsCSV = Source.fromFile(personsFileName).getLines().toList
    val personsList = personsCSV.map(person => person.getPerson(","))

    personsList
  }

  def readRequestData(requestFileName: String): Request = {
    val requestCSV = Source.fromFile(requestFileName).getLines().toList
    val requestList = requestCSV.map(request => request.getRequest(","))
    val request = requestList.head

    request
  }
}
