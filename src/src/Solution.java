package src;
import java.util.Objects;

/**
* The String calculator program can calculate the sum of all the numbers in a string
*
* @version 1.0
* @since   2018-12-16
*/
public class Solution {
	
	private static final String NEW_LINE = "\n";
	private static final String SPLIT = ",";
	
	/**
	   * This is the method which calculate the sum
	   * @param delimiter
	   * @param inputString Input string
	   * @param s 
	   * @return result The sum of all the numbers in the inputString
	   */
	public int calculateResult(final String delimiter,final String inputString){
		int result = 0;
		for(String number:inputString.split(delimiter.toString())){
			if(number.trim().length()>0){
				int num = Integer.parseInt(number.trim());
				result += num;
			}
		}
		return result;
	}
	
	/**
	   * This is the main method
	   * @param inputString Input string
	   * @return calculateResult function The sum of all the numbers in the inputString
	   */
	public int stringCalculator(final String inputString){
		if(Objects.isNull(inputString) || inputString.length() == 0) return 0;
		return calculateResult(SPLIT+"|"+NEW_LINE, inputString);
	}

}
