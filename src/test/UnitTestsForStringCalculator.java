package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.Solution;

public class UnitTestsForStringCalculator{
	private Solution solution;
	
	@Before
	public void init() {
		solution = new Solution();
	}

	@Test
	public void inputStringIsNull() throws Exception{
		assertEquals(0, solution.stringCalculator(null));
	}
	
	@Test
	public void inputStringEmptyString() throws Exception{
		assertEquals(0, solution.stringCalculator(""));
	}
}
