package ca.bcit.comp1451.assignment01;

import java.util.ArrayList;

public class Account {
	//instance variables
	private Customer customer;
	private String accountNumber;
	private Date creationDate;
	private Double balance;
	private ArrayList<TransactionRecord> trxnArrayList;
	
	//static variable
	public static int ACCOUNT_STARTING_VALUE = 100100100;
	
	/**
	 * constructor
	 */
	public Account(Customer customer, Date creationDate, Double balance) {
		setCustomer(customer);
		setCreationDate(creationDate);
		setBalance(balance);
		trxnArrayList = new ArrayList<TransactionRecord>();
		setAccountNumber(generateAccountNumber());
		
	}


	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}


	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}


	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}


	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {	
		this.creationDate = creationDate;
	}


	/**
	 * @return the balance
	 */
	public Double getBalance() {
		return balance;
	}


	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/**
	 * method that generates a unique accountNumber
	 * @return accountNumber;
	 */
	private String generateAccountNumber() {
		int number = ACCOUNT_STARTING_VALUE + 1;
		ACCOUNT_STARTING_VALUE++;
		String accountNumber = String.valueOf(number);
		return accountNumber;
	}
	
	/**
	 * method to deposit money into balance
	 * @param amount
	 * @return true/false on operation's success
	 */
	public boolean deposit (Double amount) {
		if(amount>0) {
			balance += amount;
			return true;
		} else {
			System.out.println("invalid deposit amount");
			return false;
		}
	}
	
	/**
	 * method to withdraw money from balance
	 * @param amount
	 * @return true/false on operation's success
	 */
	public boolean withdraw(Double amount) {
		if(amount>0 && amount<=balance) {
			balance -= amount;
			return true;					
		} else if(amount<=0){
			System.out.println("invalid amount");
			return false;
		} else {
			System.out.println("insufficient funds");
			return false;
		}
	}
	
	public void performTransaction(TransactionRecord transaction) {
		if(transaction!=null) {
			trxnArrayList.add(transaction);
		}
	}
	
	public void displayTransactionRecord() {
		if(trxnArrayList!=null) {
			for(TransactionRecord trxn: trxnArrayList) {
				trxn.displayTransactionRecord();
			}
		} else {
			System.out.println("transaction record is null");
		}
	}
	
	public void displayAccountInformation() {
		customer.displayCustomerDetails();
		System.out.println("Account number: " + getAccountNumber());
		System.out.println("Account balance: " + getBalance());
		String date = creationDate.dateInString();
		System.out.println("Account creation date: " + date);
	}
	
}
