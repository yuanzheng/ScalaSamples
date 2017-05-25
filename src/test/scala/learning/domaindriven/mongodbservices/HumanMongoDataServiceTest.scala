package learning.domaindriven.mongodbservices

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import learning.classes.{Adult, Teen}

class HumanMongoDataServiceTest extends FlatSpec with Matchers {

  "HumanDataService" should "save Adult and Teens into MongoDB" in {
    val h: Adult = new Adult("11", "lucas")
    h.set("age", 300)
    h.set("name", "Lucas Song")
    
    val t: Teen = new Teen("6", "zheng")
    t.set("name", "yuanzheng")
    t.set("school", "WangHai")
    
    val teenservice: TeenDataService = new TeenDataService
    val adultservice: AdultDataService = new AdultDataService
    
    teenservice.save(t)
    
    adultservice.save(h)
    adultservice.close()
     
    val t2: Teen = new Teen("60", "yuanzheng")
    t2.set("name", "Song yuanzheng")
    t2.set("school", "9 Middle High")
    teenservice.save(t2)
    
    teenservice.close()
   
    
  }
  
}