package learning.mysqldb.orm

import learning.logging.Logging
import learning.configuration.ConfigManager
import learning.mysqldb.orm.Unicorn.driver.simple.Database
import org.apache.commons.dbcp2.BasicDataSource

/** Trait used for connecting to the SourceRepositoryDB MySQL database */
trait SourceDBConnection extends Logging {
  
  /** The source key to use to establish a db connection to the proper source database */
  val sourceKey: String
  lazy val db_creds = this.getDBCredentials

  //lazy val db = Database.forDataSource(SourceDBConnection.getDataSourceForDBCreds(db_creds))
  lazy val db = Database.forURL("jdbc:mysql://"+db_creds("host")+":"+db_creds("port")+"/"+db_creds("database_name")+"?zeroDateTimeBehavior=convertToNull", user=db_creds("username"), password=db_creds("password"), driver="com.mysql.jdbc.Driver")
  
  var source_id: Long = 0
  var creds: Map[String, String] = null
  
  def getDBCredentials: Map[String, String] = {
    
    val config = ConfigManager.getConfig()
    val username        = config.getString("databases.source.username")
    val password        = config.getString("databases.source.password")
    val poolMaxTotal    = config.getInt("databases.source.pool_max_total")
    val poolMaxIdle     = config.getInt("databases.source.pool_max_idle")
    val poolInitialSize = config.getInt("databases.source.pool_initial_size")
  
    if (this.sourceKey == "") {
      throw new IllegalArgumentException("Source key not defined when connecting to source database");
    }
    
    Map("host" -> this.creds("host"),
        "port" -> this.creds("port"),
        "database_name" -> this.creds("database_name"),
        "username" -> username,
        "password" -> password,
        "pool_max_total" -> poolMaxTotal.toString,
        "pool_max_idle" -> poolMaxIdle.toString,
        "pool_initial_size" -> poolInitialSize.toString
    )
  }
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
object SourceDBConnection extends Logging {

  protected lazy val config = ConfigManager.getConfig()

  // Map of DataSources stored by dbConfigName
  protected var dataSourceMap: Map[String, BasicDataSource] = Map()

  // Get or create a new datasource for dbConfigName
  def getDataSourceForDBCreds(dbcreds: Map[String, String]): BasicDataSource = {

    logger.debug("Loading datasource for db credentials: " + dbcreds)

    val lookupKey = dbcreds.get("host").get + dbcreds.get("port").get + dbcreds.get("database_name").get

    dataSourceMap.get(lookupKey) match {
      case Some(ds) => {
        logger.debug(s"Reusing existing Datasource for lookupKey [${lookupKey}]")
        logger.debug(s"Current number of active connections [${ds.getNumActive()}]")
        logger.debug(s"Current number of idle connections [${ds.getNumIdle()}]")
        ds
      }

      case None => {
        logger.debug(s"Creating new Datasource for lookupKey [${lookupKey}]")
        // Setup connection pooling
         val dataSource: BasicDataSource = {
          val ds = new BasicDataSource
          ds.setDriverClassName("com.mysql.jdbc.Driver")
          ds.setUsername(dbcreds.get("username").get)
          ds.setPassword(dbcreds.get("password").get)
          ds.setMaxTotal(dbcreds.get("pool_max_total").get.toInt)
          ds.setMaxIdle(dbcreds.get("pool_max_idle").get.toInt)
          ds.setInitialSize(dbcreds.get("pool_initial_size").get.toInt)
          ds.setValidationQuery("SELECT 1")
          ds.setUrl("jdbc:mysql://"+dbcreds.get("host").get+":"+dbcreds.get("port").get+"/"+dbcreds.get("database_name").get+"?zeroDateTimeBehavior=convertToNull&autoReconnect=true")
          ds
        }

        // Save the datasource in the map and return it
        dataSourceMap += (lookupKey -> dataSource)
        dataSource
      }
    }
  }
}