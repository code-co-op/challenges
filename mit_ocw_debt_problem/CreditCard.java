import static java.lang.System.out;
import java.util.Scanner;

public class CreditCard {

    public static void main(String[] args) {
	double balance, apr, monthRate, principal, totalPaid = 0.0; //Variables
	
	Scanner keyboard = new Scanner(System.in); //Input device
	
	//Get the requested values
	out.print("Please enter the outstanding balance: $");
	balance = keyboard.nextDouble();

	out.print("Please enter the annual interest rate %: ");
	apr = keyboard.nextDouble() / 100.0;
	
	out.print("Please enter the minimum monthly payment rate %: ");
	monthRate = keyboard.nextDouble() / 100.0;
	
	//Go through each month and display relevant numbers
	for(int i = 1; i < 13; i++) {
	    out.println("Month " + i);
	    totalPaid += (balance * monthRate);
	    out.printf("Minimum monthly payment: $%.2f\n", (balance * monthRate));
	    principal = balance * (apr / 12.0);
	    out.printf("Principal paid: $%.2f\n", principal);
	    balance -= principal;
	    out.printf("Remaining balance: $%.2f\n\n", balance);
	}
	
	//Display final results
	out.println("RESULT");
	out.printf("Total amount paid: $%.2f\n", totalPaid);
	out.printf("Remaining balance :$%.2f\n", balance);
	
	keyboard.close(); //Cleanup
    }
    
}
