package data.utils

object StringUtils {

  /**
   * Capitalizes first letter of every word in the input string
   * 
   * @param input
   * @return String
   */
  def capitalizeFirstLetter(input: String): String = {
    input.toLowerCase().split(" ").map(_.capitalize).mkString(" ").trim()
  }
  
  /**
   * Check a string is either null or empty or white space
   *
   * @param string a String
   * @return Boolean
   */
  def isNullOrEmptyOrWhiteSpace(string: String): Boolean = {
    string == null || string.isEmpty() || string.trim().isEmpty()
  }
}
