package learning.readFiles

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class FileReadLearningTest extends FlatSpec with Matchers {
 
  "FileReadLearning" should "be able to read Json file" in {
    val test: FileReadLearning = new FileReadLearning
    //test.readJsonFile()
    test.readLines()
  }
  

  
}