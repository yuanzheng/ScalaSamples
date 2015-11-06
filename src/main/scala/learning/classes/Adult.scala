package learning.classes

import traits.Human

/** humanId, 从 Human 继承来。 avoids using constructor. 
 */
class Adult(val humanId: String) extends Human{

  //val status: String
  //val humanId: String = id // overrides the abstract variable in supper class
}

/** 两个 classes 是等同的    */
class Adult2(_id: String) extends Human {
  
  val humanId: String = _id // overrides humanId in Human trait
}

