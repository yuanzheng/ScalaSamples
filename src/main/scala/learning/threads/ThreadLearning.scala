package learning.threads

import scala.concurrent.{ ExecutionContext, ExecutionContext$, Future, Promise, Await }
import scala.concurrent.duration._
import scala.collection.mutable.{Map => MMap}

class ThreadLearning extends Runnable{

  override def run() : Unit =  
  {  
    println(s"Current thread: ${Thread.currentThread.getName()} started")
    
    ThreadFactory.getData("localhost", 3306)
    //Thread.currentThread.wait(2000)
    ThreadFactory.deleteData("localhost", 3306)
    
  }
}


object ThreadFactory {
  private var mongoClients: Map[String, String] = Map()
  private var connectionCounter: MMap[String, Int] = MMap()
  var toWait : Boolean = false
  var lock : AnyRef = new Object()
  
  def getData(host: String, port:Int): String = {
    var msg: String = ""
    lock.synchronized 
      {  
         // Wait until message has been retrieved  
        await (toWait == false) 
        
        val key = host+":"+port
       
        if (connectionCounter.contains(key) && connectionCounter.get(key).get>0){
          val counter = connectionCounter.get(key).get + 1
          connectionCounter.put(key, counter)
        } else {
          // Store message  
          mongoClients += (key -> "Hello")
          connectionCounter.put(key, 1)
        }
         // Notify consumer that status has changed  
        msg = mongoClients.get(key).get
        
        //Thread.sleep(2000)
        // Toggle status  
        for (i <- 1 to 900000000) {
          for (j <- 1 to 90000000) {
            for (j <- 1 to 90000000) {
              println(s"Current thread: ${Thread.currentThread.getName()} has $mongoClients")
            }
          }
        }
        toWait = true
        lock.notifyAll()  
      
        msg
        
      }
  }
  
  def deleteData(host: String, port:Int) = {
    lock.synchronized 
      {  
       // Wait until message has been retrieved  
        await (toWait == true) 
        val key = host+":"+port
       
        if (connectionCounter.contains(key) && connectionCounter.get(key).get>1){
          val counter = connectionCounter.get(key).get - 1
          connectionCounter.put(key, counter)
        } else if (connectionCounter.contains(key) && connectionCounter.get(key).get==1){
          mongoClients = Map() ++ mongoClients-key
          connectionCounter.remove(key)
        }
        
        println(s"Current thread: ${Thread.currentThread.getName()} has removed $mongoClients and $connectionCounter")
        // Toggle status  
        toWait = false
        lock.notifyAll()  
      }
  }
  private def await(cond: => Boolean) =  
      while (!cond) { lock.wait() }  
  
}