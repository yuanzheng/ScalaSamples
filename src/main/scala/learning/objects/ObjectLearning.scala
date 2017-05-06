package learning.objects

import learning.classes.abstractClass.Human
import learning.classes.{Adult, Teen}
class ObjectLearning {
  
  
  def selectPeople(job: String): Human = {
    println(s"The job: ${"learning.classes." + job}")
    //println(s"What is  ${Class.forName("learning.classes." + job).newInstance()("123")}")
    //val people: Human = Class.forName("learning.classes." + job)..newInstance.asInstanceOf[Human]
    
    //people
    new Adult("123", "Lucas")
  }

}