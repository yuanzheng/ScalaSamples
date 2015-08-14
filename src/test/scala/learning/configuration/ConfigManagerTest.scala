package learning.configuration

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import com.typesafe.config.Config
import com.typesafe.config.ConfigException

class ConfigManagerTest extends FlatSpec with Matchers {

  "ConfigManager" should "load reference" in {
    val conf: Config = ConfigManager.getConfig()
    
    try {
      val result: String = conf.getString("mongo.neuraldata.host")
      result should be ("localhost")
      println(s"Check Mongo conf: $result")
    } catch {
      case e: Exception => println(s"Conf exception: ", e)
    }
  }
}