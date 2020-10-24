package ca.bcit.comp1451.assignment01;

public class Customer {
	//instance variables
	private String name;
	private String address;
	private Date birth;
	
	
	/**
	 * constructor
	 * @param name
	 * @param address
	 * @param birth
	 */
	public Customer(String name, String address, Date birth) {
		setName(name);
		setAddress(address);
		setBirth(birth);		
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 * @throws IllegalArgumentException if name is null or an empty String
	 */
	public void setName(String name) {
		if(!name.isEmpty() && name!=null) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("name cannot be null or an empty String");
		}
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 * @throws IllegalArgumentException if address is null or an empty String
	 */
	public void setAddress(String address) {
		if(!address.isEmpty() && address!=null) {
			this.address = address;
		} else {
			throw new IllegalArgumentException("address cannot be null or an empty String");
		}
	}
	/**
	 * @return the birth
	 */
	public Date getBirth() {
		return birth;
	}
	/**
	 * @param birth the birth to set
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	/**
	 * @param word
	 */
	public String formatName(String word) {
		String formattedName = word.substring(0, 1).toUpperCase() + word.substring(1);
		//System.out.println(formattedName);
		return formattedName;
	}
	
	public void displayCustomerDetails() {
		System.out.println("Customer name: " + formatName(getName()));
		System.out.println("Customer address: " + getAddress());
		String date = birth.dateInString();
		System.out.println("Date of birth: " + date);
		System.out.println();
	}

}
