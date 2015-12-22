package learning.iterator

class IteratorLearning {
  
  val testMap1: Map[String, Any] = Map("source_id" -> 1, 
      "hash_code" -> "7b83c74623612f73a7386ebf949c329e", 
      "company_website_length" -> 4, 
      "web_domain_external_id" -> "565416bde4b0a9196793b92e", 
      "source_key" -> "isdc:2334fdac23")
  val testMap2: Map[String, Any] = Map(
      "sector" -> "Business Services", 
      "company_name_length" -> 12, 
      "ext_company_id" -> 5185004, 
      "source_identity_id" -> 231366, 
      "industry" -> "Business Services", 
      "company_website_main_domain" -> "com", 
      "id" -> 231366)
  
  def buildIterator(): Iterator[String] = {
    this.testMap1.keySet.iterator ++ this.testMap2.keySet.iterator
  }
  
  def toMapString(): Unit = {
    
    val keys: Iterator[String] = buildIterator()
    
    val result = keys.toList.map(k => (k, testMap1.get(k).getOrElse("").toString())).toMap
    //println(s"First iterator: ")
    println(s"Secound iterator: $result")
  }
  
}