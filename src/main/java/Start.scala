import extensions.Registry.getNewStringExtensions

object Start {

  def main(args: Array[String]): Unit = {

    //val path = "examples/src/main/resources/people.json"
    //val peopleDF = spark.read.json(path)

    println("anafa.hyams@gmail.com".isValidEmail())
    println("anafa.hyams@gmail.com3".isValidEmail())
    println("anafa.hyamsgmail.com".isValidEmail())
    println("anafa.hyams@gmail".isValidEmail())

    println("---------------------------------")

    println("anafa.hyams@gmail".isValidPhoneNumber())
    println("+1 (997) 411-3097".isValidPhoneNumber())
    println("+1 ?997) 411-3097".isValidPhoneNumber())
    println("+1 (?)997) 411-309a".isValidPhoneNumber())



  }

}
