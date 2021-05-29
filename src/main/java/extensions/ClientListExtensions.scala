package extensions

import extensions.Registry.{getNewIntExtensions, getNewStringExtensions}
import models.Client

class ClientListExtensions(clientList: List[Client]) {

  def validate(): List[Client] = {
    clientList.filter(_.age.isValidAge())
      .filter(_.phone.isValidPhoneNumber())
      .filter(_.email.isValidEmail())
  }

}
