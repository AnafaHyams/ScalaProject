package services

//import org.apache.xmlbeans.
import org.apache.commons._
import org.apache.poi.hssf.usermodel.{HSSFSheet, HSSFWorkbook}
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.xssf.usermodel.{XSSFSheet, XSSFWorkbook}

import java.io.FileInputStream
import java.util
//.poi.ss.usermodel.{ DataFormatter, WorkbookFactory, Row }
import org.apache.xmlbeans._
import java.io.File
//import collection.JavaConversions._

import models.Client

object ReadDataFromExcel extends DataReader {
  override def readData(): List[Client] = {

    var clientsList: List[Client] = Nil

    var firstName: String = ""
    var lastName: String = ""
    var gender: String = ""
    var age: Int = 0
    var email: String = ""
    var phone: String = ""
    var education: String = ""
    var occupation: String = ""
    var salary: Int = 0
    var maritalStatus: String = ""
    var numOfChildren: Int = 0

    val file = new File("data/client.xls")
    val fis: FileInputStream = new FileInputStream(file)
    val workbook: HSSFWorkbook = new HSSFWorkbook(fis)
    val firstSheet: HSSFSheet = workbook.getSheetAt(0)

    val rowIterator: util.Iterator[Row] = firstSheet.iterator()
    var firstRowOfHeadline: Boolean = true


    while ({rowIterator.hasNext}) {
      var row: Row = rowIterator.next

      if (firstRowOfHeadline) {
        if(rowIterator.hasNext) {
          row = rowIterator.next()
          firstRowOfHeadline = false
        }
      }

      val cellIterator: util.Iterator[Cell] = row.cellIterator

      while ({cellIterator.hasNext}) {
        val cell: Cell = cellIterator.next

        cell.getColumnIndex match {
          case 0 => firstName = cell.getStringCellValue
          case 1 => lastName = cell.getStringCellValue
          case 2 => gender = cell.getStringCellValue
          case 3 => age = cell.getNumericCellValue.intValue()
          case 4 => email = cell.getStringCellValue
          case 5 => phone = cell.getStringCellValue
          case 6 => education = cell.getStringCellValue
          case 7 => occupation = cell.getStringCellValue
          case 8 => salary = cell.getNumericCellValue.intValue()
          case 9 => maritalStatus = cell.getStringCellValue
          case 10 => numOfChildren = cell.getNumericCellValue.intValue()
        }
      }

      val client: Client = Client(firstName, lastName, gender, age, email, phone, education, occupation, salary, maritalStatus, numOfChildren)

      clientsList = client :: clientsList
    }

    clientsList
  }
}
