package test;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import src.Solution;

public class UnitTestsForStringCalculator{
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void inputStringIsNull() throws Exception{
		assertEquals(0, Solution.stringCalculator(null));
	}
	
	@Test
	public void inputStringEmptyString() throws Exception{
		assertEquals(0, Solution.stringCalculator(""));
	}
	
	@Test
	public void inputStringOneNumberString() throws Exception{
		assertEquals(90, Solution.stringCalculator("90"));
	}
	
	@Test
	public void inputStringWithComma() throws Exception{
		assertEquals(6, Solution.stringCalculator("1,2,3"));
	}
	
	@Test
	public void inputStringWithCommaSpace() throws Exception{
		assertEquals(6, Solution.stringCalculator("1 , 2 ,3 "));
	}
	
	@Test
	public void inputStringWithCommaNewLine() throws Exception{
		assertEquals(6, Solution.stringCalculator("1\n,2,3"));
	}
	
	@Test
	public void inputStringWithCommaNewLineSpace() throws Exception{
		assertEquals(6, Solution.stringCalculator("1\n ,2,3 "));
	}
	
	@Test
	public void inputStringWithSingleCustomDelimiter() throws Exception{
		assertEquals(7, Solution.stringCalculator("//;\n1;2;4"));
	}
	
	@Test
	public void inputStringWithSingleFowareSlashDelimiterNewLine() throws Exception{
		assertEquals(7, Solution.stringCalculator("///\n1/2/4"));
	}
	
	@Test
	public void inputStringWithDoubleFowareSlashDelimiterNewLine() throws Exception{
		assertEquals(7, Solution.stringCalculator("////\n1//2//4"));
	}
	
	@Test
	public void inputStringWithSingleCustomDelimiter1() throws Exception{
		assertEquals(7, Solution.stringCalculator("//@\n1@2@4"));
	}
	
	@Test
	public void inputStringWithSingleCustomDelimiter2() throws Exception{
		assertEquals(7, Solution.stringCalculator("//,\n1,2,4"));
	}
	
	@Test
	public void inputStringWithSingleArbitraryCustomDelimiter() throws Exception{
		assertEquals(7, Solution.stringCalculator("//@@@\n1@@@2@@@4"));
	}
	
	@Test
	public void inputStringWithSingleCustomDelimiterStar() throws Exception{
		assertEquals(7, Solution.stringCalculator("//*\n1*2*4"));
	}
	
	@Test
	public void inputStringWithMutipleArbitraryCustomDelimiterStars() throws Exception{
		assertEquals(7, Solution.stringCalculator("//***\n1***2***4"));
	}
	
	@Test
	public void inputStringWithMutipleArbitraryCustomDelimiterCommas() throws Exception{
		assertEquals(7, Solution.stringCalculator("//,,,\n1,,,2,,,4"));
	}
	
	@Test
	public void inputStringWithMutipleArbitraryCustomDelimiterLargeNumber() throws Exception{
		assertEquals(12, Solution.stringCalculator("//@@@,;,%\n1@@@2000;4%7"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void inputStringWithMutipleArbitraryCustomDelimiterNegativeNumber() throws Exception{
		assertEquals(12, Solution.stringCalculator("//@@@,;,%\n1@@@-5;4%7"));
	}
	
	@Test
	public void inputStringWithMutipleArbitraryCustomDelimiterNegativeNumbers() throws Exception{
		expectedEx.expect(IllegalArgumentException.class);
	    expectedEx.expectMessage("Negatives not allowed[-5, -9, -12]");
	    Solution.stringCalculator("//@@@,;,%\n1@@@-5;4%7,-9,-12");
	}
	
	@Test
	public void inputStringWithMutipleArbitraryCustomDelimiterSpace() throws Exception{
		assertEquals(14, Solution.stringCalculator("//@@@,;,%\n1 @@@2;4 %7"));
	}
	
	@Test
	public void inputStringWithMutipleArbitraryCustomDelimiter() throws Exception{
		assertEquals(14, Solution.stringCalculator("//@@@,;,%\n1@@@2;4%7"));
	}
}
