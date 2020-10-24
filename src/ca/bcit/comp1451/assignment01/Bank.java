package ca.bcit.comp1451.assignment01;

import java.util.HashMap;
import java.util.Scanner;

public class Bank {
	//instance variables
	private String bankName;
	private HashMap<String, Account> accountMap;
	
	/**
	 * constructor
	 * @param bankName
	 */
	public Bank(String bankName) {
		setBankName(bankName);
		accountMap = new HashMap<String, Account>();
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * method to set bankName
	 * @param bankName the bankName to set
	 * @throws IllegalArgumentException if bank name is null or empty
	 */
	public void setBankName(String bankName) {
		if(bankName!=null && !bankName.isEmpty()) {
			this.bankName = bankName;
		} else {
			throw new IllegalArgumentException("bank name cannot be null or empty");
		}
	}
	
	public void addAccount(Account toadd) {
		if(!accountMap.containsValue(toadd) && toadd!=null) {
			accountMap.put(toadd.getAccountNumber(), toadd);
		} else {
			System.out.println("account invalid");
		}
	}
	
	/**
	 * method to return account object
	 * @param accountNumber
	 * @return account object
	 * @throws IllegalArgumentException if account number is null or empty
	 */
	public Account getAccount(String accountNumber) {
		Account selectedAccount = null;
		if(accountNumber!=null && !accountNumber.isEmpty()) {
			if(accountMap.containsKey(accountNumber)) {
				 selectedAccount = accountMap.get(accountNumber);
			} else if(!accountMap.containsKey(accountNumber)){
				System.out.println("account number not found in the collection");
			} 
		} else {
			throw new IllegalArgumentException("account number cannot be null or empty");
		}	
		return selectedAccount;
	}
	
	/**
	 * method to show account details and transaction records
	 * @param name
	 */
	public void showTractions(String name) {
		if(accountMap.containsKey(name)) {
			Account selectedAccount = accountMap.get(name);
			selectedAccount.displayAccountInformation();
			selectedAccount.displayTransactionRecord();			
		} else {
			System.out.println("customer name not found in collection");
		}
	}
	
	
	public void displayAccountNumbers() {
		for(String word: accountMap.keySet()) {
			System.out.println(word);
		}
	}
	
	
	public void makeTransaction() {
		boolean goAgain = true;
		Scanner input = new Scanner(System.in);
		while(goAgain == true) {
			
			System.out.println("please enter an account number");
			String queryAccount = input.next();
			System.out.println("searching for account number " + queryAccount + " ...");
			
			if(accountMap.containsKey(queryAccount)) {
				Account selectedAccount = accountMap.get(queryAccount);
				System.out.println("account number found.");
				System.out.println();
				selectedAccount.displayAccountInformation();
				System.out.println();
				System.out.println("would you like to [1]deposit, [2]withdraw, or [3]show transactions?");
				int choice = input.nextInt();
				
				switch(choice){
				case 1:
					System.out.println("what is the amount to depost?");
					Double depositAmount = input.nextDouble();
					boolean transactionOne = selectedAccount.deposit(depositAmount);
					
					if(transactionOne == true) {
						System.out.println("please enter a transaction date. example for October 22, 2020 would be");
						System.out.println("22 10 2020");
						
						int date = input.nextInt();
						int month = input.nextInt();
						int year = input.nextInt();
						
						Date transactionDate = new Date(date, month, year);
						TransactionRecord thisTransaction = new TransactionRecord(depositAmount, transactionDate, queryAccount, "deposit");
						selectedAccount.performTransaction(thisTransaction);
						
						System.out.println("do you wish to do another transaction? y or n");
						String choiceOne = input.next();
						
						if(choiceOne.equalsIgnoreCase("y")) {
							displayAccountNumbers();
							break;
						} else if(choiceOne.equalsIgnoreCase("n")) {
							goAgain = false;
							System.out.println("system terminated.");
							break;
						}
						
					} else {
						System.out.println("transaction unsuccessful. system terminating");
						goAgain = false;
					}
					break;
					
				case 2:
					System.out.println("what is the amount to withdraw?");
					double withdrawAmount = input.nextDouble();
					boolean transactionTwo = selectedAccount.withdraw(withdrawAmount);
					
					if(transactionTwo == true) {
						System.out.println("please enter a transaction date. example for October 22, 2020 would be");
						System.out.println("22 10 2020");
						
						int date = input.nextInt();
						int month = input.nextInt();
						int year = input.nextInt();
						
						Date transactionDate = new Date(date, month, year);
						TransactionRecord thisTransaction = new TransactionRecord(withdrawAmount, transactionDate, queryAccount, "withdraw");
						selectedAccount.performTransaction(thisTransaction);
						
						System.out.println("do you wish to do another transaction? y or n");
						String choiceOne = input.next();
						
						if(choiceOne.equalsIgnoreCase("y")) {
							displayAccountNumbers();
							break;
						} else if(choiceOne.equalsIgnoreCase("n")) {
							goAgain = false;
							System.out.println("system terminated.");
							break;
						}
						
					} else {
						System.out.println("transaction unsuccessful. system terminating");
						goAgain = false;
					}
					break;
					
				case 3:
					selectedAccount.displayTransactionRecord();
					
					System.out.println("do you wish to do another transaction? [y] or [n]");
					String choiceOne = input.next();
					
					if(choiceOne.equalsIgnoreCase("y")) {
						displayAccountNumbers();
						break;
					} else if(choiceOne.equalsIgnoreCase("n")) {
						goAgain = false;
						System.out.println("system terminated.");
						break;
					}
					break;
				}
	
			} else {
				System.out.println("account number not found. system terminating.");
				goAgain = false;
			}
			
		}
	input.close();	
	}
}
