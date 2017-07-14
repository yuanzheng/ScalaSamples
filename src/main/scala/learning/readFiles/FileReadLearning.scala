package learning.readFiles

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.Source
//import org.apache.commons.csv.{ CSVFormat, CSVParser, CSVRecord }
import java.io.FileReader
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileWriter
import org.json4s._
import org.json4s.native.JsonMethods._
import org.json4s.native.Serialization._
import org.json4s.native.Serialization
import scala.collection.mutable.{Map => MMap}
import scala.util.control.Exception.catching

/**
 * two primary ways to open and read a text file:
 * 		1.	Use a concise, one-line syntax. This has the side effect of leaving the file open, but can be useful in short-lived programs, like shell scripts.
 *    2.  Use a slightly longer approach that properly closes the file.
 */
class FileReadLearning {

  def readAccountClose(): Unit = {
    val fileName = "/Users/ysong/projects/workspace/ScalaLearning/training_set_311.csv"
    var counter: Int = 0
    val allIndex: ListBuffer[Int] = new ListBuffer[Int]

    val pattern = "\",\"".r
    for (line <- Source.fromFile(fileName).getLines if (counter < 4)) {

      if (counter == 0) {
        var index: Int = 0
        val tmp: List[String] = line.split(",").toList
        //println(s"first Line: $tmp")
        println(s"columns: ${tmp.length}")

        val columns: mutable.StringBuilder = mutable.StringBuilder.newBuilder
        for (each <- tmp) {
          //println(s"line: $each")
          if (each == "\"opportunity.ext_account_id\"") {
            println(s"$index opportunity.ext_account_id")

            allIndex += index
            columns.append(each)
          } else if (each == "\"opportunity.source_creation_date\"") {
            println(s"$index opportunity.source_creation_date")

            allIndex += index
            columns.append(each)
          } else if (each == "\"opportunity.qbdialer_dials\"") {
            println(s"$index opportunity.qbdialer_dials")

            allIndex += index
            columns.append(each)
          } else if (each == "\"success\"") {
            println(s"$index success")

            allIndex += index
            columns.append(each)
          } else if (each == "\"opportunity.qbdialer_close_score\"") {
            println(s"$index opportunity.qbdialer_close_score")
            allIndex += index
            columns.append(each)
          }

          index = index + 1
        }

        println(s"seq: ${allIndex.toList}")
        println(s"all Columns: ${columns.result.stripPrefix(",")}")
      }
      else {
        var tmp: Vector[String] = pattern.split(line).toVector
        //println(s"first row: ${tmp.toList}")
        tmp = tmp.updated(0, tmp(0).split("\"")(1))
        tmp = tmp.updated(tmp.length -1, tmp(tmp.length -1).split("\"")(0))
        //println(s"values: ${tmp.length}, ${tmp(0)} and ${tmp(tmp.length -1)}")
        //println(s"all: $tmp")
        val r: List[String] = for (each <- allIndex.toList) yield("\""+ tmp(each) + "\"")

        println(s"first row: $r")
      }

      counter = counter + 1
    }


  }
  /** onger approach that properly closes the file */
  def readAndClose(): Unit = {
    val fileName: String = ""
    val fileReader: FileReader = new FileReader(fileName)
    
    
    fileReader.close()
  }
  
  /** onger approach that properly closes the file */
  def readCSV(): Unit = {
    /*
    val fileReader: FileReader = new FileReader(fileName)
    val parser: CSVParser = new CSVParser(fileReader, CSVFormat.RFC4180.withHeader())
    
    val iterator = parser.iterator
    while (iterator.hasNext) {
			val record: CSVRecord = iterator.next
				
    }
    * 
    */
  }
  
  /** one-line syntax */
  def lines(fileNameWithPath: String): Unit = {
    val fileLines: Iterator[String] = Source.fromFile(fileNameWithPath)("ISO-8859-1").getLines
    
    if (fileLines.hasNext) fileLines.next
  }
  
  /** one-line syntax */
  def readJsonFile(): Unit = {
    val filename: String = "/Users/ysong/projects/Neuralytics/neuraltools/MappingUtility/tmp/0000203287task-00.csv.err"
    var file: List[Map[String, Any]] = List[Map[String, Any]]()
		var counter: Int = 0
		var missAll: Int = 0
		
		for (line <- Source.fromFile(filename).getLines) {
      counter = counter + 1
      val map:scala.collection.immutable.Map[String,Any] = parse(string2JsonInput(line)).values.asInstanceOf[scala.collection.immutable.Map[String,Any]]
      
      //var index: Int = 0
      if (!isValuable(map)) {
        if (!hasWhatId(map)) {
          missAll = missAll + 1
          println(s"$missAll -- $line")
          
          file ::= map
        }
        
      }
      
    }
		
		println(s"Totally $counter rows")
		println(s"file size: ${file.length}")
		println(s"Miss All: $missAll")
  }
  
  
  def readLines() {
    val filename: String = "/Users/ysong/projects/Neuralytics/AllSourceKeysDev.csv"
    val filename2: String = "/Users/ysong/projects/Neuralytics/AllSourceKeysDevMongodb.txt"
    val rowsDev: MMap[Int, String] = MMap()
    val rowsMongo: MMap[Int, String] = MMap()
    for (line <- Source.fromFile(filename).getLines) {
      val tmp: List[String] = line.split(",").toList
      
      rowsDev += ((catching(classOf[NumberFormatException]) opt tmp.head.toInt).get -> tmp.tail.head)
      
    }
    /*
    for (line <- Source.fromFile(filename2).getLines) {
      val tmp: List[String] = line.split(",").toList
      
      rowsMongo += ((catching(classOf[NumberFormatException]) opt tmp.head.toInt).get -> tmp.tail.head)
      
    }

    println(s"See Geneshia: \n${rowsDev.toString()}")
    println(s"See Mongodb: \n${rowsMongo.toString()}")
    
    val mongoKeys: MMap[String, String] = MMap()
    rowsMongo.foreach(f => {
      val tmp: List[String] = f._2.split(":").toList
      mongoKeys += (tmp.head -> tmp.tail.head)
    })
    
    //println(s"See Mapping: \n${mongoKeys.toString()}")
    
    val devKeys: MMap[String, String] = MMap()
    rowsDev.foreach(f => {
      val tmp: List[String] = f._2.split(":").toList
      devKeys += (tmp.head -> tmp.tail.head)
    })
    
    println(s"See G Mapping: \n${devKeys.toString()}")
    
    
    val testMap: MMap[String, String] = MMap()
    rowsMongo.foreach(f => {
      val tmp: List[String] = f._2.split(":").toList
      val head: String = tmp.head
      val matchH: String = devKeys.get(head) match {
        case Some(a) => {
          testMap += (tmp.head -> head)
          if (tmp.tail.head != a)
            println(s"${f._2} -> $head:$a")
          head
        }
        case None => "Error"
      }
      //testMap += (tmp.head -> matchH)
      
      
    })
    */
    //println(s"Match: \n${testMap.toString}")
    
    val function: String = "$set"
    
    rowsDev.foreach(f => println(s"""db.linear_process_mapping.update({"source_key":"${f._2}"},{$function:{"source_id": NumberInt(${f._1})}},{multi:true})"""))
    
  }
  
  def hasWhatId(interaction: Map[String, Any]): Boolean = {
    var result: Boolean = false
    interaction.get("ext_what_id") match {
      case Some(a) => result = true
      case None =>
    }
    
    result
  }
  
  def isValuable(interaction: Map[String, Any]): Boolean = {
    var result: Boolean = false
    val extAccountId: Option[String] = interaction.get("ext_account_id") match {
        case Some(x)   => {
          result = true
          Some(x.toString())
        }
        case None => None
      }

      val extContactId: Option[String] = interaction.get("ext_contact_id") match {
        case Some(x)   => {
          result = true
          Some(x.toString)
        }
        case None => None
      }

      val extLeadId: Option[String] = interaction.get("ext_lead_id") match {
        case Some(x)   => {
          result = true
          Some(x.toString)
        }
        case None => None
      }

      val extOppId: Option[String] = interaction.get("ext_opportunity_id") match {
        case Some(x)   => {
          result = true
          Some(x.toString)
        }
        case None => None
      }

      val extWhoId: Option[String] = interaction.get("ext_who_id") match {
        case Some(x)   => {
          result = true
          Some(x.toString)
        }
        case None => None
      }
      
      result
  }
}