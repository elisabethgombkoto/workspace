/**ego8769
 * 
 */
package oo.ego8769.hue03.bsp01;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Elisabeth
 *
 */
public class DistributionCenterTest {

	@Test
	public void test1() {
		DistributionCenter test= new DistributionCenter(0,0 ,14, 12);
		
		boolean result=test.isLegal(4,3);
		if (result==true) {
			System.out.println("Test successfully completed.");
		} else {
			fail("Test1 NOT successfully completed.");
		}
	}
	
	@Test
	public void test2() {
		DistributionCenter test= new DistributionCenter(5,0 ,14, 12);
		
		boolean result=test.isLegal(4,3);
		if (result==false) {
			System.out.println("Test successfully completed.");
		} else {
			fail("Test2 NOT successfully completed.");
		}
	}
	@Test
	public void test3() {
		DistributionCenter test= new DistributionCenter(0,6 ,14, 12);
		
		boolean result=test.isLegal(4,3);
		if (result==false) {
			System.out.println("Test successfully completed.");
		} else {
			fail("Test3 NOT successfully completed.");
		}
	}

	@Test
	public void test4() {
		DistributionCenter test= new DistributionCenter(0,0 ,2, 12);
	assertEquals(false, test.isLegal(4,3));
		
	}
	@Test
	public void test5() {
		DistributionCenter test= new DistributionCenter(0,0 ,10, 1);
	assertEquals(false, test.isLegal(4,3));
		
	}
	
	
}
