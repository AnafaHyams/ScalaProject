package models

import utils.enums.Gender._
import utils.enums.MaritalStatus._

case class Client(firstName: String, lastName: String, gender: String, age: Int, email: String, phone: String, education: String, occupation: String, salary: Int, maritalStatus: String, numberOfChildren: Int)

