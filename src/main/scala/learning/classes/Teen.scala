package learning.classes

import learning.classes.abstractClass.Human

/** humanId, 从 Human 继承来。 avoids using constructor.
 * 
 */
class Teen(val humanId: String, val name: String) extends Human{

  /** implement abstract method in base class */
  def include(name: String): Boolean = {

    true
  }
}

/** 两个 classes 是等同的
  *
  * _id: 与constructor一样
  */
class Teen2(_id: Int, _name: String) extends Human {

  /** predefined function */
  require(_id > 0, "id must be positive")
  val humanId = _id.toString  // overrides humanId in Human trait
  override val name = _name

  /** implement abstract method in base class */
  def include(name: String): Boolean = {

    true
  }
}
