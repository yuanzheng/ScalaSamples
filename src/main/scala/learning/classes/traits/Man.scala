package learning.classes.traits

/** Traits are similar to Java interfaces, except they can have non-abstract members
  * (can have fields and concrete methods). Traits cannot have parameters
  * */

trait Man {

  def height: Int   // abstract
  def weight: Int   // abstract
  def somethingElse: Int = height * weight

}
