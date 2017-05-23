package learning.classes

import learning.classes.abstractClass.Human
import learning.classes.traits.Man

/** humanId, 从 Human 继承来。 avoids using constructor. And implement it
 */
class Adult(val humanId: String, val name: String) extends Human with Man{

  //val status: String
  //val humanId: String = id // overrides the abstract variable in supper class
  val weight = 150   // implement abstract field in trait Man
  val height = 55  // implement abstract field in trait Man
  /** redefine an existing, non-abstract method in base class
    *
    * @param id
    * @return
    */
  override def setHumanId(id: String): Boolean = {

    false
  }

  /** implement abstract method in base class */
  def include(name: String): Boolean = {

    true
  }
}

/** 两个 classes 是等同的
  *
  * implicitly introduces a constructor, it's called the Primary Constructor of the class
  * e.g. _id
  */
class Adult2(_id: Int, _name: String) extends Human {

  /** predefined function */
  require(_id > 0, "id must be positive")

  val humanId: String = _id.toString // implement humanId in Human trait
  val name: String = _name

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

  /** implement abstract method in base class */
  def include(name: String): Boolean = {

    true
  }

}


