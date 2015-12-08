package learning.mysqldb.orm

import learning.configuration.ConfigManager
import learning.mysqldb.orm.Unicorn.driver.simple.Database
import org.apache.commons.dbcp2.BasicDataSource
import learning.logging.Logging

/** Trait used for connecting to MySQL database */
trait ConfigDBConnection {

  // database name as defined in the reference.conf or application.conf configuration files
  val db_config_name = ""
  
  lazy val config = ConfigManager.getConfig()
  lazy val host = config.getString("databases." + db_config_name + ".host")
  lazy val port = config.getString("databases." + db_config_name + ".port")
  lazy val database_name = config.getString("databases." + db_config_name + ".database_name")
  lazy val username = config.getString("databases." + db_config_name + ".username")
  lazy val password = config.getString("databases." + db_config_name + ".password")

  lazy val db = Database.forURL("jdbc:mysql://"+host+":"+port+"/"+database_name+"?zeroDateTimeBehavior=convertToNull", user=username, password=password, driver="com.mysql.jdbc.Driver")

  // Load the database from a DataSource
  //lazy val db = Database.forDataSource(ConfigurableDBConnection.getDataSourceForName(db_config_name))
}

/** Object used for caching DataSource objects
  *
  * Gets a previously created DataSource object for the given dbConfigName.
  * If a DataSource does not exist for the dbConfigName, create it and cache it.
  *
  * This caching is important because this is our connection pool.  We do not want
  * to create a new connection pool every time we request a new connection to a
  * database.
  */
object ConfigurableDBConnection extends Logging {

  protected lazy val config = ConfigManager.getConfig()

  // Map of DataSources stored by dbConfigName
  protected var dataSourceMap: Map[String, BasicDataSource] = Map()

  // Get or create a new datasource for dbConfigName
  def getDataSourceForName(dbConfigName: String): BasicDataSource = {

    dataSourceMap.get(dbConfigName) match {
      case Some(ds) =>
        logger.debug(s"Reusing existing Datasource for dbConfigName [${dbConfigName}]")
        logger.debug(s"Current number of active connections [${ds.getNumActive()}]")
        logger.debug(s"Current number of idle connections [${ds.getNumIdle()}]")
        ds
      case None => {
        logger.debug(s"Creating new Datasource for dbConfigName [${dbConfigName}]")
        val host            = config.getString("databases." + dbConfigName + ".host")
        val port            = config.getString("databases." + dbConfigName + ".port")
        val databaseName    = config.getString("databases." + dbConfigName + ".database_name")
        val username        = config.getString("databases." + dbConfigName + ".username")
        val password        = config.getString("databases." + dbConfigName + ".password")
        val poolMaxTotal    = config.getInt("databases." + dbConfigName + ".pool_max_total")
        val poolMaxIdle     = config.getInt("databases." + dbConfigName + ".pool_max_idle")
        val poolInitialSize = config.getInt("databases." + dbConfigName + ".pool_initial_size")

        // Setup connection pooling
         val dataSource: BasicDataSource = {
          val ds = new BasicDataSource
          ds.setDriverClassName("com.mysql.jdbc.Driver")
          ds.setUsername(username)
          ds.setPassword(password)
          ds.setMaxTotal(poolMaxTotal);
          ds.setMaxIdle(poolMaxIdle);
          ds.setInitialSize(poolInitialSize);
          ds.setValidationQuery("SELECT 1")
          ds.setUrl("jdbc:mysql://"+host+":"+port+"/"+databaseName+"?zeroDateTimeBehavior=convertToNull&autoReconnect=true")
          ds
        }

        // Save the datasource in the map and return it
        dataSourceMap += (dbConfigName -> dataSource)
        dataSource
      }
    }
  }
}