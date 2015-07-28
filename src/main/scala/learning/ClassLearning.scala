package learning

class Tweet(val user: String, val text: String, val retweets: Int) {
  override def toString: String =
    "User: " + user + "\n" +
    "Text: " + text + " [" + retweets + "]"
}


abstract class ClassLearning {
    
    def filter(p: Tweet=>Boolean): ClassLearning = filterAcc(p, new newLearn) 
    
    
    def filterAcc(p: Tweet=>Boolean, acc: ClassLearning): ClassLearning
    
}


class newLearn extends ClassLearning {
    
    def filterAcc(p: Tweet=>Boolean, acc: ClassLearning): ClassLearning = {
        acc
    }
    
    
    def initObject() = {
        ObjectLearning.addOne("Lucas, hello")
    }
    
    def checkObject(): String = {
        s"ObjectLearning has: ${ObjectLearning.printOne()}"
    }
}

class secondLearn extends ClassLearning {
    
    def filterAcc(p: Tweet=>Boolean, acc: ClassLearning): ClassLearning = {
        acc
    }
    
    
    def initObject() = {
        ObjectLearning.addOne("Lucas, hello")
    }
    
    def checkObject(): String = {
        s"ObjectLearning has: ${ObjectLearning.printOne()}"
    }
}

class thirdLearn(id: Int, name: String) {
   // def this(id: Int) = this(id, 10000)
    
    
}