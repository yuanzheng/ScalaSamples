package learning.mysqldb.repositories

import learning.mysqldb.orm.ConfigDBConnection

/** Trait used for connecting to the AnimalRepositoryDB MySQL database */
trait AnimalDBConnection extends ConfigDBConnection {
  override val db_config_name = "animals"
}