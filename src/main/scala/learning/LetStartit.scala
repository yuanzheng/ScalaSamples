package learning

import map.MapLearning

object LetStartit {
  
  

  def main(args: Array[String]) ={
    println("Hello world!")
    
    val up = new Functions
    val map: MapLearning = new MapLearning
    map.appendTwoMaps()
    map.buildNewMap()
    map.convertMapType()
    //println(up.Upper("Good Morning!").toString())
    
    //up.testDate()
    //up.convertMap()
    //up.updateMap()
    //up.testEmptyList()
    //up.testCaseClass()
    //up.playList()
    //up.breakFor()
    //up.convertAny()
    /*
    up.StringConcat

    up.testDate("2015-01-02")
    up.testDoubleConvert()
    //up.testForLoop()
    up.testList()
    up.testRegex()
    up.testBitwise()
    //up.testArray()
    up.testJavaDate()
    //up.testDefaultDate()
    up.playList()
    
    up.json()
    up.exceptionT()
    up.selfException()
    * 
    */
    /*
    up.testGroup()
    up.convertDouble()
    up.forFilter()
    up.useFunction()
    up.printMap()
    up.testMatch()
    
    var test = up.testException()
    println(s"check exception: $test")
    
    test = up.testMap()
    println(s"check Map: $test")
    
    val testList = up.testInteractionList()
    if (testList.length != 0)
        println(s"check interactionList: $testList")
    
    
    
    //val testClass: ClassLearning = new ClassLearning(1,2)
    
    //println(s"check class:\n ${testClass.toString()}")
    
        
    up.testObject()
    * 
    */
    //up.buildMap()
    
    //up.iterateMap()
  }

  //println("Hello world!")
}