package learning.classes.generics

/** Using a type parameter:[T], it allows us to use all possible element types
 * 
 */
trait List[T] {
  
  def isEmpty: Boolean
  def head: T
  def tail: List[T]

}



class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  /** implements trait's variables,  */
  def isEmpty: Boolean = false

}

class Nil[T] extends List[T] {
  /** implements trait's variables */
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head") // Nothing is subtype of any type
  def tail: Nothing = throw new NoSuchElementException("Nil.head") // Nothing is subtype of any type
}