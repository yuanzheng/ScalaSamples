package data.utils

class StringUtils {

  /**
   * Capitalizes first letter of every word in the input string
   * 
   * @param input
   * @return String
   */
  def capitalizeFirstLetter(input: String): String = {
    input.toLowerCase().split(" ").map(_.capitalize).mkString(" ").trim()
  }
}