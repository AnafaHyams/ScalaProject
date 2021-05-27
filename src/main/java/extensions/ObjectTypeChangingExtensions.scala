package extensions

import models.{Client, Person, User}

object ObjectTypeChangingExtensions {

  implicit class SwitchFromPersonToUserObject(person: Person) extends User {
    override val firstName: String = person.name.split(" ")(0)
    override val lastName: String = person.name.split(" ")(1)
    override val gender: String = person.gender
    override val age: Int = person.age
    override val email: String = person.email
    override val phoneNumber: String = person.phone
  }

  implicit class SwitchFromClientToUserObject(client: Client) extends User {
    override val firstName: String = client.firstName
    override val lastName: String = client.lastName
    override val gender: String = client.gender
    override val age: Int = client.age
    override val email: String = client.email
    override val phoneNumber: String = client.phone
  }
}
