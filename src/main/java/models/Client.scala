package models

import utils.enums.Gender._
import utils.enums.MaritalStatus._

case class Client(firstName: String, lastName: String, gender: Gender, age: Int, email: String, phone: String, education: String, occupation: String, salary: Long, maritalStatus: MaritalStatus, numberOfChildren: Int)

