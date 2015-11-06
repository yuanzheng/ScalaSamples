package learning.datatypes.sets

class FunSets {

  type Set = Int => Boolean
  
  def singletonSet(elem: Int): Set = Set(elem)
  
}