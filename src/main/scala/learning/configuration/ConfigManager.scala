package learning.configuration

import com.typesafe.config.ConfigFactory
import com.typesafe.config.Config

object ConfigManager {

  private var conf: Config = _

  /** Gets a config instance based on a resource name or defaults to the typesafe config defaults */
  def getConfig(resource: String = "", dumpConfig: Boolean = false, validate: Boolean = false): Config = {
    // Validate application conf against reference conf
    val appconf = ConfigFactory.defaultApplication().resolve()
    val refconf = ConfigFactory.defaultReference()
    
    if (validate) {
      appconf.checkValid(refconf, "is")
    }

    if (resource.isEmpty()) {
      conf = ConfigFactory.load()
    } else {
      conf = ConfigFactory.load(resource)
    }
    conf.getConfig("is")
  }
}