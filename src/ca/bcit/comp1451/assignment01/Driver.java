package ca.bcit.comp1451.assignment01;

public class Driver {

	public static void main(String[] args) {
		
		
		Date dateOne = new Date(10, 10, 2000);
		Date dateTwo = new Date(02, 05, 1990);
		Date dateThree = new Date(05, 11, 1980);
		Date dateFour = new Date(20, 12, 1995);
		Date dateFive = new Date(10, 10, 2020);
		Date dateSix = new Date(9, 10, 2020);
		
		Customer customerOne = new Customer("John", "123 Willingdon Ave", dateOne);
		Customer customerTwo = new Customer("Revan", "222 Daniels Way", dateTwo);
		Customer customerThree = new Customer("Cecilia", "6060 Soyus Way", dateThree);
		Customer customerFour = new Customer("Liy", "2030 Gensha Street", dateFour);
		
		Account accountOne = new Account(customerOne, dateFive, 25000.00);
		Account accountTwo = new Account(customerTwo, dateFive, 59020.50);
		Account accountThree = new Account(customerThree, dateSix, 320100.90);
		Account accountFour = new Account(customerFour, dateSix, 987500.00);
		
		Bank myBank = new Bank("Desmond's Credit Union");
		
		myBank.addAccount(accountOne);
		myBank.addAccount(accountTwo);
		myBank.addAccount(accountThree);
		myBank.addAccount(accountFour);
		
		System.out.println("displaying account numbers in collection");
		myBank.displayAccountNumbers();
		myBank.makeTransaction();

	}

}
