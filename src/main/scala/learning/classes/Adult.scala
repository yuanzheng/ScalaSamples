package learning.classes

import traits.Human

/** id, A private valuable, avoids using constructor */
class Adult(val humanId: String) extends Human{

  //val status: String
  //val humanId: String = id // overrides the abstract variable in supper class
}