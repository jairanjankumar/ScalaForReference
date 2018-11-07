package playJson

import play.api.libs.json._
import utility.Utilities._

// Exploring Json Basics using play JSON library.
// https://www.playframework.com/documentation/2.6.x/ScalaJson

object BasicJsonParsing extends App {

  val json: JsValue = Json.parse(
    """{
    "name" : "Watership Down",
    "location" : {
      "lat" : 51.235685,
      "long" : -1.309197
    },
    "residents" : [ {
      "name" : "Fiver",
      "age" : 4,
      "role" : null
    }, {
      "name" : "Bigwig",
      "age" : 6,
      "role" : "Owsla"
    } ]
  }""")

  println("json  : " + json)

  ---------
  val minifiedString: String = Json.stringify(json)
  val readableString: String = Json.prettyPrint(json)
  ---------

  val lat = (json \ "location" \ "lat").get
  // returns JsNumber(51.235685)
  val bigwig = (json \ "residents" \ 1).get
  // returns {"name":"Bigwig","age":6,"role":"Owsla"}

  val names = json \\ "name"
  // returns Seq(JsString("Watership Down"), JsString("Fiver"), JsString("Bigwig"))

  val name = json("name")
  // returns JsString("Watership Down")

  val bigwig2 = json("residents")(1)
  // returns {"name":"Bigwig","age":6,"role":"Owsla"}

  // (json("residents")(3)
  // throws an IndexOutOfBoundsException

  // json("bogus")
  // throws a NoSuchElementException
  ---------

  // basic types
  val jsonString: JsString = Json.toJson("Fiver").as[JsString]
  val jsonNumber: JsValue = Json.toJson(4)
  val jsonBoolean: JsValue = Json.toJson(false)

  // collections of basic types
  val jsonArrayOfInts: JsValue = Json.toJson(Seq(1, 2, 3, 4))
  val jsonArrayOfStrings: JsValue = Json.toJson(List("Fiver", "Bigwig"))

  ---------

  val json1: JsValue = JsObject(Seq(
    "name" -> JsString("Watership Down"),
    "location" -> JsObject(Seq("lat" -> JsNumber(51.235685), "long" -> JsNumber(-1.309197))),
    "residents" -> JsArray(IndexedSeq(
      JsObject(Seq(
        "name" -> JsString("Fiver"),
        "age" -> JsNumber(4),
        "role" -> JsNull
      )),
      JsObject(Seq(
        "name" -> JsString("Bigwig"),
        "age" -> JsNumber(6),
        "role" -> JsString("Owsla")
      ))
    ))
  ))
  println("json1  : " + json1)

  ---------
  case class Location(lat: Double, long: Double)
  case class Resident(name: String, age: Int, role: Option[String])
  case class Place(name: String, location: Location, residents: Seq[Resident])

  import play.api.libs.json._

  implicit val locationWrites = new Writes[Location] {
    def writes(location: Location): JsObject = Json.obj(
      "lat" -> location.lat,
      "long" -> location.long
    )
  }

  implicit val residentWrites = new Writes[Resident] {
    def writes(resident: Resident): JsObject = Json.obj(
      "name" -> resident.name,
      "age" -> resident.age,
      "role" -> resident.role
    )
  }

  implicit val placeWrites = new Writes[Place] {
    def writes(place: Place): JsObject = Json.obj(
      "name" -> place.name,
      "location" -> place.location,
      "residents" -> place.residents
    )
  }

  val place = Place(
    "Watership Down",
    Location(51.235685, -1.309197),
    Seq(
      Resident("Fiver", 4, None),
      Resident("Bigwig", 6, Some("Owsla"))
    )
  )

  val json2 = Json.toJson(place)

  ---------
  import play.api.libs.json._
  import play.api.libs.functional.syntax._

  implicit val locationWrites1: Writes[Location] = (
    (JsPath \ "lat").write[Double] and
      (JsPath \ "long").write[Double]
    )(unlift(Location.unapply))

  implicit val residentWrites1: Writes[Resident] = (
    (JsPath \ "name").write[String] and
      (JsPath \ "age").write[Int] and
      (JsPath \ "role").writeNullable[String]
    )(unlift(Resident.unapply))

  implicit val placeWrites1: Writes[Place] = (
    (JsPath \ "name").write[String] and
      (JsPath \ "location").write[Location] and
      (JsPath \ "residents").write[Seq[Resident]]
    )(unlift(Place.unapply))
  ---------

}
