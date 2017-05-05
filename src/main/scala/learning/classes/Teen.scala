package learning.classes

import traits.Human

/** humanId, 从 Human 继承来。 avoids using constructor. 
 * 
 */
class Teen(val humanId: Int) extends Human{

}

/** 两个 classes 是等同的    */
class Teen2(_id: Int) extends Human {

  /** predefined function */
  require(_id > 0, "id must be positive")

  val humanId = _id  // overrides humanId in Human trait
}
