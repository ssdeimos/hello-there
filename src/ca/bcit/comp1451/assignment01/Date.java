package ca.bcit.comp1451.assignment01;

import java.util.HashMap;


public class Date {
	//instance variables
	private int day;
	private int month;
	private int year;
	private HashMap<Integer, String> myMap;
	
	//constants
	public static final int FIRST_DAY = 1;
	public static final int LAST_DAY = 31;
	public static final int FIRST_MONTH = 1;
	public static final int LAST_MONTH = 12;
	public static final int EARLIEST_YEAR = 1900;
	public static final int CURRENT_YEAR = 2020;
	public static final int DAY_DIGITS = 2;
	public static final int YEAR_DIGITS = 4;
	
	/**
	 * constructor
	 * @param day
	 * @param month
	 * @param year
	 */
	public Date(int day, int month, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
		myMap = new HashMap<Integer, String>();
		loadMyMap();
	}


	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}


	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		if(day >= FIRST_DAY && day <= LAST_DAY) {
			this.day = day;
		} else {
			System.out.println("day must be between 1 and 31 inclusive");
		}
	}


	/**
	 * @return the month
	 */
	public int getMonth() {
		return month; 
	}


	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		if(month >= FIRST_MONTH && month <= LAST_MONTH) {
			this.month = month;
		} else {
			this.month = FIRST_MONTH;
			System.out.println("invalid month. setting to month to default: " + FIRST_MONTH);
		}
	}


	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}


	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		if(year >= EARLIEST_YEAR && year <= CURRENT_YEAR) {
			this.year = year;
		} else {
			this.year = EARLIEST_YEAR;
			System.out.println("invalid year. setting year to default: " + EARLIEST_YEAR);
		}
	}
	
	/**
	 * method to load the hash map with the months' names an numbers
	 */
	public void loadMyMap() {
		myMap.put(1, "January");
		myMap.put(2, "February");
		myMap.put(3, "March");
		myMap.put(4, "April");
		myMap.put(5, "May");
		myMap.put(6, "June");
		myMap.put(7, "July");
		myMap.put(8, "August");
		myMap.put(9, "September");
		myMap.put(10, "October");
		myMap.put(11, "November");
		myMap.put(12, "December");
	}
	
	/**
	 * method to return a String in the a dd/month name/yyyy format
	 * @return stringDay
	 */
	public String dateInString() {
		String dayInString = String.valueOf(day);
		String monthInString = myMap.get(month);
		String yearInString = String.valueOf(year);

		if(dayInString.length() < DAY_DIGITS) {
			dayInString = "0" + dayInString;
		}
		
		String fullDateInString = dayInString + "/" + monthInString + "/" + yearInString;
		
		//System.out.println(fullDateInString);
		return fullDateInString;
	}
	
}
