package services
import com.fasterxml.jackson.core.`type`.TypeReference
import models.Person
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import extensions.Handlers.StringExt

import java.io.File
import scala.io.Source
import scala.jdk.CollectionConverters.CollectionHasAsScala

object ReadDataFromJson {

  val mapper: ObjectMapper = new ObjectMapper

  def readData(): scala.List[Person] = {

    val jsonFile = new File("data/persons.json")

    //val personList: List[Person] = mapper.readValue(jsonFile, new TypeReference[List[Person]]() {}).asScala.toList
    //personList

    // JUST FOR NOW: READ Persons data from csv file and return persons list
    val personsCSV = Source.fromFile("data/persons.csv").getLines().toList
    val personsList = personsCSV.map(person => person.getPerson(","))

    personsList
  }
}
