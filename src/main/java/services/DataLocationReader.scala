package services

import java.util.Properties

object DataLocationReader {
  val properties = new Properties
  properties.load(this.getClass.getResourceAsStream("/application.properties"))

  val clientFileName: String = properties.getProperty("client_input_excel_file_location")
  val personFileName: String = properties.getProperty("persons_input_json_file_location")
  val requestFileName: String = properties.getProperty("request_input_json_file_location")

}
