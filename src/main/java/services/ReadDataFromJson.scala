package services

import com.fasterxml.jackson.core.`type`.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import extensions.CSVHandlers.StringExt
import models.{Person, Request}

import java.io.File
import scala.collection.JavaConverters.{asJavaIterableConverter, iterableAsScalaIterableConverter}
import scala.io.Source

object ReadDataFromJson {

  var mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)

  def readData(personsFileName: String): List[Person] = {
    val jsonFile = new File(personsFileName)

    val personsList = mapper.readValue(jsonFile, new TypeReference[List[Person]]() {}).asJava.asScala.toList

    // JUST FOR NOW: READ Persons data from csv file and return persons list
    //val personsCSV = Source.fromFile(personsFileName).getLines().toList
    //val personsList = personsCSV.map(person => person.getPerson(","))

    personsList
  }

  def readRequestData(requestFileName: String): Request = {
    val requestJsonFile = new File(requestFileName)
    val request = mapper.readValue(requestJsonFile, new TypeReference[List[Request]]() {}).asJava.asScala.toList.head

    request
  }
}
