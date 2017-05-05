package learning.classes

import traits.Human

/** humanId, 从 Human 继承来。 avoids using constructor. 
 */
class Adult(val humanId: Int) extends Human{

  //val status: String
  //val humanId: String = id // overrides the abstract variable in supper class
}

/** 两个 classes 是等同的
  *
  * implicitly introduces a constructor, it's called the Primary Constructor of the class
  * e.g. _id
  */
class Adult2(_id: Int, name: String) extends Human {

  /** predefined function */
  require(_id > 0, "id must be positive")

  /** the second constructor
    *
    * only takes a single argument, and what it does it calls another constructor with the two arguments 即，the
    * implicit primary constructor of class Adult2.
    *
    * 使用：val person = new Adult2("lucas")
    *
    * 但这个second constructor is call Auxiliary Constructor, it needs to call default constructor
    */
  def this(n: String) = this(1000000, n)  //default constructor

  val humanId: String = _id // overrides humanId in Human trait
}

