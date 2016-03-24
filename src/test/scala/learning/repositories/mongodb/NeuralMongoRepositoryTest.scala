package learning.repositories.mongodb

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import java.io._

class NeuralMongoRepositoryTest extends FlatSpec with Matchers {
  val modelName: List[String] = List("010302","010102","010402","010502","010602")
  
  "Access Mongodb Collection" should "be able to retrieve data" in {
   
    var repo:NeuralMongoRepository = null
    try {
        repo = new NeuralMongoRepository("neuraldata", "HBase_company_ids_to_source_keys")
        var json: String = "["
        val files: Iterator[String] = getListOfFiles("../../productionTrainingModels/trained_mlp_files/") //("./models")//
         println(s"all files: $files")
        while (files.hasNext) {
          val file: String = files.next()
          val info: List[String] = file.split("-").toList
          val company_id: String = info.head
          
          //val model: String = info.last
          //if (modelName.contains(model)) {
            val sourceKey: String = repo.findOneBy(company_id)
            if (!sourceKey.isEmpty()) {
              
              if (files.hasNext) {
                json = json + createSource(sourceKey, file) + ","
              } else
                json = json + createSource(sourceKey, file)
            } else
              println(s"Cannot find source key for id: [$file] => $sourceKey")
           
              /*
          } else
            println(s"Model [$file] is illegal")
          */
          
        }
       
        
        json = json + "\n]"
        writeToFile(json)
        //println(s"Final: \n$json")
        
    }catch {
      case e:Exception => println(s"try to save HBase_company_ids_to_source_keys in Mongo",e)
    } finally{
      try{
        if (repo != null) repo.close()
      } catch {
        case ex: Exception => println(s"HBase_company_ids_to_source_keys Mongo cannont be closed.", ex)
      }
    }
    
  }
  
  def writeToFile(json: String): Unit = {
    val writer = new PrintWriter(new File("productionModels.json" ))

      writer.write(json)
      writer.close()
  }
  
  def getListOfFiles(dir: String):Iterator[String] = {
    ((new File(dir)).listFiles.filter(_.isFile()).map(_.getName)).toIterator
  }
  
  def createSource(key: String, path: String): String = {
    s"""\n\t{\n\t\t"source_key":"$key",\n\t\t"url":"http://localhost:9000/api/v1/model",\n\t\t"datafile":"datafiles/$path"\n\t}"""
  }
}