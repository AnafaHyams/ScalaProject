package services

import models.Client

trait DataReader {

  def readData(): List[Client]

}
