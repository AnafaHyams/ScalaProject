package services

import com.fasterxml.jackson.core.`type`.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import models.{Person, Request}

import java.io.File
import scala.collection.JavaConverters.{asJavaIterableConverter, iterableAsScalaIterableConverter}

object ReadDataFromJson {

  var mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)

  def readData(personsFileName: String): List[Person] = {
    val jsonFile = new File(personsFileName)
    val personsList = mapper.readValue(jsonFile, new TypeReference[List[Person]]() {}).asJava.asScala.toList

    personsList
  }

  def readRequestData(requestFileName: String): Request = {
    val requestJsonFile = new File(requestFileName)
    val request = mapper.readValue(requestJsonFile, new TypeReference[List[Request]]() {}).asJava.asScala.toList.head

    request
  }
}
