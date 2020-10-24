package ca.bcit.comp1451.assignment01;

public class TransactionRecord {
	//instance variables
	private double amountInCad;
	private Date transactionDate;
	private String accountNumber;
	private String transactionType;
	
	//constants
	public static final String TYPE_ONE = "withdraw";
	public static final String TYPE_TWO = "deposit";
	
	/**
	 * constructor
	 * @param amountInCad
	 * @param transactionDate
	 * @param accountNumber
	 * @param transactionType
	 */
	public TransactionRecord(double amountInCad, Date transactionDate, String accountNumber, String transactionType) {
		setAmountInCad(amountInCad);
		setTransactionDate(transactionDate);
		setAccountNumber(accountNumber);
		setTransactionType(transactionType);
	}

	/**
	 * @return the amountInCad
	 */
	public double getAmountInCad() {
		return amountInCad;
	}

	/**
	 * @param amountInCad the amountInCad to set
	 * @throws IllegalArgumentException if amount is 0 or negative
	 */
	public void setAmountInCad(double amountInCad) {
		if(amountInCad>0) {
			this.amountInCad = amountInCad;
		} else {
			throw new IllegalArgumentException("amount in CAD must be greater than 0");
		}
	}

	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 * @throws IllegalArgumentException if transactionDate is null
	 */
	public void setTransactionDate(Date transactionDate) {
		if(transactionDate != null) {
			this.transactionDate = transactionDate;
		} else {
			throw new IllegalArgumentException("transaction date cannot be null");
		}
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 * @throws IllegalArgumentException if account number is empty or null
	 */
	public void setAccountNumber(String accountNumber) {
		if(!accountNumber.isEmpty() && accountNumber!=null) {
			this.accountNumber = accountNumber;
		} else {
			throw new IllegalArgumentException("account number cannot be empty or null");
		}
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 * @throws IllegalArgumentException if transaction type is not "withdraw" or "deposit" 
	 * @throws IllegalArgumentException if transaction type is empty or null
	 */
	public void setTransactionType(String transactionType) {
		if(!transactionType.isEmpty() && transactionType!=null) {
			if(transactionType.equalsIgnoreCase(TYPE_ONE) || transactionType.equalsIgnoreCase(TYPE_TWO)) {
				this.transactionType = transactionType;
			} else {
				throw new IllegalArgumentException("transaction type must either be " + TYPE_ONE + " or " + TYPE_TWO);
			}			
		} else {
			throw new IllegalArgumentException("transaction type cannot be empty or null");
		}
		
	}
	
	public String displayTransactionRecord() {
		String printAccountNumber = "Account number: " + getAccountNumber();
		String printTransactionType = "Type of transaction: " + getTransactionType();
		String printAmount = "Amount: " + getAmountInCad();
		String date = transactionDate.dateInString();
		String printTransactionDate = "Date of transaction: " + date;
		
		System.out.println(printAccountNumber);
		System.out.println(printTransactionType);
		System.out.println(printAmount);
		System.out.println(printTransactionDate);
		
		String fullTransactionRecord = printAccountNumber + printTransactionType + printAmount + printTransactionDate;
		return fullTransactionRecord;		
	}
	
	
	
	
	
	
}
