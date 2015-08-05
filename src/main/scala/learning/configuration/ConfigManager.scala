package learning.configuration

import com.typesafe.config.ConfigFactory
import com.typesafe.config.Config

object ConfigManager {

  private var conf: Config = _

  /** Gets a config instance based on a resource name or defaults to the typesafe config defaults */
  def getConfig(resource: String = ""): Config = {
    if (resource.isEmpty()) {
      conf = ConfigFactory.load()
    } else {
      conf = ConfigFactory.load(resource)
    }
    conf.getConfig("is")
  }
}