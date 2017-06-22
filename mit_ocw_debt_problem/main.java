import java.util.Scanner;

/**
 * Created by adam on 22/06/2017.
 */

public class main {

    public static void main(String args[])
    {
        System.out.println("Enter the outstanding balance on your credit card:");
        Scanner scan=new Scanner(System.in);

        double outstandingBalance=scan.nextDouble();
        scan.nextLine();
        System.out.println("Enter the annual credit card interest rate as a decimal:");
        double annualRate=scan.nextDouble();
        scan.nextLine();

        calculate(outstandingBalance,annualRate);



    }

    public static void calculate(double outstandingBalance,double annualRate)
    {
        double balanceBefore=outstandingBalance;
        int numberOfMonths=0;
        double minMonthlyPayment=10.0;
        double interestPaid=0.0;
        double principlePaid=0.0;
        double monthlyRate=0;
        while(outstandingBalance>0|| numberOfMonths>12)
        {
            if(numberOfMonths>12)
            {
                outstandingBalance=balanceBefore;
                numberOfMonths=0;
                minMonthlyPayment+=10;
            }

            monthlyRate=annualRate/12;
            outstandingBalance=outstandingBalance *(1+monthlyRate) - minMonthlyPayment;

            numberOfMonths++;


        }



        System.out.println("Num months;" +numberOfMonths);
        System.out.println("Balance:" + outstandingBalance);

    }





/*
    public static void main (String args[])
    {
        System.out.println("Enter the outstanding balance on your credit card:");
        Scanner scan=new Scanner(System.in);

        double outstandingBalance=scan.nextDouble();
        scan.nextLine();
         System.out.println("Enter the annual credit card interest rate as a decimal:");
         double annualRate=scan.nextDouble();
         scan.nextLine();

         System.out.println("Enter the minimum monthly payment rate as a decimal");
         double monthlyRate=scan.nextDouble();
         scan.nextLine();

        printCalculations(outstandingBalance,monthlyRate,annualRate);
    }*/

    //Print details
    public static void printCalculations(double balanceIn,double minMonthlyRate,double interestRate)
    {
        double principlePaid=0.0;
        double interestPaid=0.0;
        double minMonthlyPayment=0.0;
        double totalPaid=0.0;


        for(int i=0;i<12;i++)
        {
            System.out.println("Month:$ "+ i );
            minMonthlyPayment=calculateMinimumPayment(balanceIn,minMonthlyRate);
            System.out.println("Minimum monthly payment:$ ");
            printFormat(minMonthlyPayment);
            interestPaid=calculateInterestPaid(balanceIn,interestRate);
            principlePaid=minMonthlyPayment-interestPaid;
            balanceIn-=principlePaid;
            System.out.println("Principle paid:$ ");
            printFormat(principlePaid);
            System.out.println("Remaining balance:$ ");
            printFormat(balanceIn);
            totalPaid+=minMonthlyPayment;

        }

        System.out.println("\n RESULT");
        System.out.println("Total amount paid :$ "+ (totalPaid));
        System.out.println("Remaining balance:$ "+balanceIn);

    }

    //Print formatted
    public static void printFormat(double valIn)
    {
        System.out.printf("%.2f",valIn);
    }



    //Calculate the minimum monthly payment
    public static double calculateMinimumPayment(double balanceIn,double minMonthlyRate)
    {
        return minMonthlyRate*balanceIn;
    }

    //Calculate the Interest paid
    public static double calculateInterestPaid(double balanceIn,double interestRate)
    {
        return ((interestRate/12.0)*balanceIn);
    }









}
