package main.scala

/**
  * Created by ysong on 4/21/17.
  */
import learning.datatypes.map.MapLearning
import learning.algorithms.sort.ScalaSorting
import learning.datatypes.list.ListLearning
import learning.json.JsonLearning
import learning.timezone.TimeZone
import learning.timezone.Time
import data.utils.StringUtils
import learning.patternmatch.PatternM
import learning.forLoop.forLearning
import learning.streams.StreamLearning
import learning.LazyEvaluation.LazyLearning
import learning.functions.functionLearning
import org.apache.commons.lang.{StringUtils => utils}
import learning.functions.ApplyFunction
import learning.classes.traits.Man

object LetStartit {



  def main(args: Array[String]) ={
    println("Hello world!")

    ApplyFunction.testFunctionAsObject


    val test= new forLearning
    //test.forFor()
    test.updateCaseClassObject()
/*
    val test = new LazyLearning
    test.test()
  */

    /*
    val test = new functionLearning
    test.sqrt(2)
    */
    /*
    test.test()
    val test = new LazyLearning
    */
    /*
    /** Stream */
    val test = new StreamLearning
    test.streamRange(1, 10)
    */

    /*
    val test = new PatternM
    test.numberPatternMatch()
    */
    //test.patternSearch()
    //test.patternMatch()

    // List learning
    //val test = new ListLearning
    //test.basicUsages()
    //test.reductionList
    //test.sequenceOperation
    //test.vectorOperation

    /*
    test.unionSetTwoList()
    *
    */
    /*
		test.convertListAny()
    test.groupList()
    */


    //val test = new MapLearning
    //test.sortMap()
    //test.addNewElementInMapList()

    //test.mergeTwoMaps()
    //test.updateMapValue()
    /*
    test.getValuesFromMap()
    */
    /*
    val testword: String = "Good morning, hello, world"
    if (!StringUtils.isNullOrEmptyOrWhiteSpace(testword))
    {
      val result: String = utils.replaceEach(testword, Array("mo","wo"), Array("song", "wi"))
      println(s"replaced: $result")
    }

    val up = new Functions
    val map: MapLearning = new MapLearning
    *
    */
    //map.addNewElementToImmutableMap
    //map.convertMapValueType()
    /*
    map.removeFromMap()
    map.newBuilder()
    map.appendTwoMaps()
    map.buildNewMap()
    map.convertMapValueType()
    map.mapContain()
    map.addNewElementToMap


    val time: TimeZone = new TimeZone
    time.testToday()

    time.UDate()
    time.jodaToJavaDate()
    time.jodaTimeComparision
    time.stringToJodaTime
    */
    val day:Time = new Time
    //day.convertTimeStamp2SQLT()
    /*
    day.splitTime()
    day.dayOfWeek
    day.timeDifference
    day.timeFormat

    val sort: ScalaSorting = new ScalaSorting
    sort.jodaTimeSort()

    val list: ListLearning = new ListLearning
    list.mapList
    */
    val json: JsonLearning = new JsonLearning
    //json.listToJson()
    //json.mapToJsong()

    //json.jsonToMap()

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