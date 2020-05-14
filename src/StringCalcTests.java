import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class StringCalcTests {

	@Test
	void test1() {
		int expected = 0;
		int actual = StringCalc.add("");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	@Test
	void test2() {
		int expected = 1;
		int actual = StringCalc.add("1");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	@Test
	void test3() {
		int expected = 3;
		int actual = StringCalc.add("1,2");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	@Test
	void test4() {
		int expected = 10;
		int actual = StringCalc.add("1,2,3,4");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	@Test
	void test5() {
		int expected = 6;
		int actual = StringCalc.add("1\n2,3");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	//I'm adding extra tests as I go, just as I think of them
	@Test
	void test6() {
		int expected = 0;
		int actual = StringCalc.add("&");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	@Test
	void test7() {
		int expected = 6;
		int actual = StringCalc.add("1\n$2,3");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	@Test
	void test8() { //Extra test - see that it replaces blank spaces with commas
		int expected = 6;
		int actual = StringCalc.add("1 2,3");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	@Test
	void test9() { //Extra test - first make sure it simply gets rid of 
		int expected = 3; //beginning character that are not digits
		int actual = StringCalc.add("//:1,2");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	@Test
	void test10() {
		int expected = 3;
		int actual = StringCalc.add("//;\n1;2");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	@Test //extra test
	void test11() {
		int expected = 0;
		int actual = StringCalc.add("&^");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	@Test //extra test for more delimiters
	void test12() {
		int expected = 14;
		int actual = StringCalc.add("3@5#6");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	@Test //test for characters at end of string
	void test13() {
		int expected = 6;
		int actual = StringCalc.add("3,2,1%$");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	@Test //test for negative numbers
	void test14() {
		int expected = -4;
		int actual = StringCalc.add(",-4#");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	@Test //test for multiple negative numbers
	void test15() {
		int expected = -4;
		int actual = StringCalc.add(",-4#,-10, -5");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	@Test
	void test16() {
		int expected = 2;
		int actual = StringCalc.add("2,1001");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	@Test
	void test17() {
		int expected = 6;
		int actual = StringCalc.add("//[***]\\n1***2***3");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
	@Test
	void test18() {
		int expected = 6;
		int actual = StringCalc.add("//[*][%]\n1*2%3");
		Assert.assertEquals("Failure -- Didn't match expected value", expected, actual);
	}
	
}
