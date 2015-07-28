package learning.hadoop.hbase

import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.client.{HTable,Put,Get}
import org.apache.hadoop.hbase.client.HBaseAdmin
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.mapreduce.TableInputFormat

class HbaseConnection {

  def Hbase() = {
    val conf = HBaseConfiguration.create()
    conf.set("hbase.zookeeper.property.clientPort", "2181") //zookeeper client port
    conf.set("hbase.zookeeper.quorum", "localhost") //zookeeper quorum
    conf.set("hbase.master", "svrnn:60000") //hbase master
    conf.addResource("/home/hadoop/hbase/conf/hbase-site.xml") //load hbase configuaration
    conf.set(TableInputFormat.INPUT_TABLE, "interactions")

    
    val admin = new HBaseAdmin(conf)
    
    // list the tables
    val listtables=admin.listTables() 
    listtables.foreach(println)
    /*
    // let's insert some data in 'mytable' and get the row
    
    val table = new HTable(conf, "mytable")
    
    val theput= new Put(Bytes.toBytes("rowkey1"))
    
    theput.add(Bytes.toBytes("ids"),Bytes.toBytes("id1"),Bytes.toBytes("one"))
    table.put(theput)
    
    val theget= new Get(Bytes.toBytes("rowkey1"))
    val result=table.get(theget)
    val value=result.value()
    println(Bytes.toString(value))
    * 
    */
  }

}