package src;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
* The String calculator program can calculate the sum of all the numbers in a string
*
* @version 1.0
* @since   2018-12-16 
*/
public final class Solution {
	
	private static final String DELIMITER_SPLIT_NEW_LINE = "\n";
	private static final String MULTIPLE_DELIMITER_SPLIT = ",";
	
	 private Solution() {
	        throw new AssertionError("Private constructor is visited.");
	    }
	 
	/**
	   * This is the method which find out all the delimiters
	   * @param inputString Input string
	   * @return delimiters A set that has all the delimiters
	   */
	private static String determineDelimiter(final String inputString){
		StringBuilder delimiters = new StringBuilder();
		delimiters.append(MULTIPLE_DELIMITER_SPLIT);
		if(inputString.startsWith("//")){
				delimiters.append("|");
			 	String delimiterStr = inputString.substring(2).split(DELIMITER_SPLIT_NEW_LINE)[0];
		        
		        for(char eachSingleDelimiter : delimiterStr.toCharArray()){
		            if(eachSingleDelimiter == ',')
		                delimiters.append("|");
		            else{
		                delimiters.append("\\");
		                delimiters.append(eachSingleDelimiter);
		            }
		        }
		}
		return delimiters.toString();
	}
	
	/**
	   * This is the method which calculate the sum
	   * @param delimiterSet
	   * @param inputString Input string
	   * @return result The sum of all the numbers in the inputString
	   */
	private static int calculateResult(final String delimiterSet,final String inputString){
		int result = 0;
		List<Integer> negativeList = new ArrayList<Integer>();
		for(String number:inputString.split(delimiterSet.toString())){
			if(number.trim().length()>0){
				int num = Integer.parseInt(number.trim());
				if (num<1000 && num>=0)
					result += num;
				else if (num<0)
					negativeList.add(num);
			}
		}
		if(negativeList.size()>0) throw new IllegalArgumentException("Negatives not allowed"+Arrays.toString(negativeList.toArray()));
		return result;
	}
	
	/**
	   * This is the main method
	   * @param inputString Input string
	   * @return calculateResult function The sum of all the numbers in the inputString
	   */
	public static int stringCalculator(final String inputString){
		if(Objects.isNull(inputString) || inputString.length() == 0) return 0;
		String expression = inputString;
		if (inputString.startsWith("//")) {
			expression = inputString.substring(inputString.indexOf(DELIMITER_SPLIT_NEW_LINE) + DELIMITER_SPLIT_NEW_LINE.length());
		}
		return calculateResult(determineDelimiter(inputString), expression);
	}

}
