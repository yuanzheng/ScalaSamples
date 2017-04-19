package learning.json

import org.json4s.{NoTypeHints, _}
import org.json4s.JsonDSL._
import org.json4s.native.JsonMethods._
import org.json4s.native.Serialization
import org.json4s.native.Serialization._
/*
import net.liftweb.json.DefaultFormats
import net.liftweb.json.Extraction
import net.liftweb.json.compact
import net.liftweb.json.render
*/
object data {
  val interaction: String= 
    """
    {
        "row_key": "",
        "source_id": "1",
        "source_key": "isdc:2334fdac23",
        "interaction_type": "dial",
        "external_source_application": "power dialer",
        "external_interaction_id": "278321",
        "interaction_result": "Correct Contact",
        "interaction_duration_seconds": "325",
        "interaction_start_timestamp": "2015-04-26 10:52:53",
        "agent_phone": "(801) 960-1361",
        "prospect_phone": "(972) 624-1941",
        "ring_time": "45",
        "talk_time": "325",
        "email_subject": "",
        "email_body": "",
        "interaction_from_participant_ip": "",
        "interaction_from_zip": "",
        "interaction_from_latitude": "",
        "interaction_from_longtitude": "",
        "people": [
            {
                "source_identity_id": "",
                "interaction_role": "agent",
                "participation": "from",
                "external_person_id": "29309",
                "date_created": "2010-09-12 90:28:19",
                "first_name": "John",
                "last_name": "Smith",
                "email": "jsmith@insidesales.com",
                "title": "Sales Manager",
                "direct_phone": "(801) 396-3416",
                "mobile_phone": "",
                "other_phone": "",
                "address1": "34 East 1700 South, Suite A220",
                "address2": "",
                "city": "Provo",
                "state": "Utah",
                "zip_code": "84606",
                "country": "United States of America",
                "linkedin": "",
                "twitter": "",
                "facebook": "",
                "google_plus": "",
                "youtube": "",
                "company": {
                    "source_identity_id": "",
                    "external_company_id": "4",
                    "name": "Insidesales.com",
                    "website": "www.insidesales.com",
                    "sector": "Technology",
                    "industry": "Application Software",
                    "company_size": "700",
                    "phone": "+1-385-207-7252",
                    "address1": "34 East 1700 South, Suite A220",
                    "address2": "",
                    "city": "Provo",
                    "state": "Utah",
                    "zip_code": "84606",
                    "country": "United States of America",
                    "linkedin": "",
                    "twitter": "",
                    "facebook": "",
                    "google_plus": "",
                    "youtube": ""
                }
            },
            {
                "source_identity_id": "",
                "interaction_role": "prospect",
                "participation": "to",
                "external_person_id": "21309",
                "date_created": "2014-02-12 10:28:19",
                "first_name": "Steve",
                "last_name": "Davis",
                "email": "sdavis@nttdata.com",
                "title": "Marketing Director",
                "direct_phone": "(972) 624-1941",
                "mobile_phone": "",
                "other_phone": "",
                "address1": "5601 Granite Parkway, Suite 1000",
                "address2": "",
                "city": "Plano",
                "state": "TX",
                "zip_code": "75024",
                "country": "United States of America",
                "linkedin": "",
                "twitter": "",
                "facebook": "",
                "google_plus": "",
                "youtube": "",
                "company": {
                    "source_identity_id": "",
                    "external_company_id": "29301",
                    "name": "NTT Data",
                    "website": "www.nttcom.com",
                    "sector": "Technology",
                    "industry": "Application Software",
                    "company_size": "",
                    "phone": "",
                    "address1": "",
                    "address2": "",
                    "city": "",
                    "state": "",
                    "zip_code": "75024",
                    "country": "",
                    "linkedin": "",
                    "twitter": "",
                    "facebook": "",
                    "google_plus": "",
                    "youtube": ""
                }
            }
        ],
        "outcomes": [
            {
                "process_model": "",
                "outcome": "",
                "outcome_timestamp": "",
                "outcome_agent_external_person_id": ""
            }
        ]
    }
    """
  
  
  val listJson: String = """
    [{"Algorithm": "ISDC Scala NeuralNetwork"}, {"Hidden Layers": "2"}, {"neuralview_contact_model": "yes"}, {"External Sources": "Weather, CPI, GDP, Stock, WebRank"}]
    """
}

class JsonLearning {
  
  implicit val formats = DefaultFormats
  
  def validateJson() = {
    val json: String = """
      {
          "source_key": "LucasSource:C552BA",
          "linear_process": "Sales Qualified Leads",
          "customer_to_standard_map": {
              "called.anything": "Correct Contact",
              "meeting": "Appointment"
          }
      }
      
      """
    val mappingDefinition: Map[String, Any] = org.json4s.native.JsonMethods.parse(json).extract[Map[String, Any]]
    
    val standardmapping: Map[String, String] = mappingDefinition.get("customer_to_standard_map").get.asInstanceOf[Map[String, String]]
    
    println(s"null Json: $standardmapping")

  }
  
  def jsonToMap() {
    val json: JValue = org.json4s.native.JsonMethods.parse(data.interaction)
    val map: Map[String, Any] = json.extract[Map[String, Any]]

    println(s"json to Map: \n$map")
    
    map.get("people").get match {
      case a: Map[_,_] => println(s"map.people is Map[String,Any]")
     
      case _ => {
        var x = map.get("people").get.asInstanceOf[scala.collection.immutable.Map[String,String]]
        println(s"map.peole is ${x.getClass()}")
      }
    }
    
  }
  
  
  def jsonToMap2() {
    val result: Map[String, Any] = parse(string2JsonInput(data.interaction)).values.asInstanceOf[scala.collection.immutable.Map[String,Any]]

  }
  
  def jsonToMap3(): Map[String, Any] = {
    val json: JValue = parse(data.interaction)
    val m: Map[String, Any] = json.extract[Map[String, Any]]
    m
  }
  
  def jsonToList(): Unit = {
    val json: JValue = parse(data.listJson)
    val lm: List[_] = json.extract[List[_]]

    println(s"json to list map: $lm")
  }
  
  
  def listToJson(): Unit = {
    //val json: JValue = parse(data.listJson)
    //val lm: List[_] = json.extract[List[_]]

    val t1: String = """{"Name": "Lucas", "source_id": "1"}"""
    val t2: String = """{"Name": "song", "source_id": "2"}"""
    val t3: String = """{"Name": "yuanzheng", "source_id": "3"}"""
    val t4: String = """{"Name": "Lucas song", "source_id": "4"}"""
    
    var test: List[String] = List()
    test = t1 :: test
    test = t2 :: test
    test = t3 :: test
    test = t4 :: test
    println(s"lsit: $test")
    val backToJson: String = write(test)//compact(render(Extraction.decompose(test)))
    println(s"back to Json: $backToJson")  
  }
  
  def mapToJsong() {
    
    val map: Map[String, Any] = Map("name"->"lucas", "age"->"200")
    
    map match {
      case a: Map[_,_] => {
        var x = a.asInstanceOf[scala.collection.immutable.Map[String,String]]
        var json:String = compact(render(x))
        
        println(s"Map to Json: $json")
      }
    }
    
    
  }
  
  
  def createJObject() {
    var response: JObject = ("status" -> "") ~ ("service_response" -> "")
    
    // by JField
    
  }

  def MapAnyToJson() = {
    val result: Map[String, Any] = Map("key" -> 1, "list" -> List(1,2,3))

    implicit val format = Serialization.formats(NoTypeHints)
    val trainingSetDetailsJson: String = write(result)
  }
  
  
 

}