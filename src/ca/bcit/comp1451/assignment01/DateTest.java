package ca.bcit.comp1451.assignment01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateTest {
	//static variables
	static int setupCount = 0;
	static int tearDownCount = 0;
	private Date date;
	
	@BeforeEach
	void setUp() throws Exception {
		setupCount++;
		date = new Date(31, 01, 1990);
		System.out.println("Date object is set up. Set up iteration: " + setupCount);
	}

	@AfterEach
	void tearDown() throws Exception {
		tearDownCount++;
		date = null;
		System.out.println("Date object is reset to null. Tear down iteration: " + tearDownCount);
	}

	@Test
	void testSetDayNegativeLow() {
		date.setDay(-1);
		assertEquals(31, date.getDay());
	}
	
	@Test
	void testSetDayNegativeHigh() {
		date.setDay(32);
		assertEquals(31, date.getDay());
	}
	
	@Test
	void testSetDayPositive() {
		date.setDay(15);
		assertEquals(15, date.getDay()); 
	}

	@Test
	void testSetMonthNegativeLow() {
		date.setMonth(0);
		assertEquals(1, date.getMonth());
	}
	
	@Test
	void testSetMonthNegativeHigh() {
		date.setMonth(13);
		assertEquals(1, date.getMonth());
	}
	
	@Test
	void testSetMonthPositive() {
		date.setMonth(13);
		assertEquals(1, date.getMonth());
	}
	
	@Test
	void testSetYearNegativeLow() {
		date.setYear(1899);
		assertEquals(1900, date.getYear());
	}
	
	@Test
	void testSetYearNegativeHigh() {
		date.setYear(2021);
		assertEquals(1900, date.getYear());
	}
	
	@Test
	void testSetYearPositive() {
		date.setYear(1980);
		assertEquals(1980, date.getYear());
	}
	

}
