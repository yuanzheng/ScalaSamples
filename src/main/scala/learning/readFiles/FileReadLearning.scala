package learning.readFiles

import scala.io.Source

class FileReadLearning {

  def lines(fileNameWithPath: String): Unit = {
    val fileLines: Iterator[String] = Source.fromFile(fileNameWithPath)("ISO-8859-1").getLines
    
    if (fileLines.hasNext) fileLines.next
  }
}