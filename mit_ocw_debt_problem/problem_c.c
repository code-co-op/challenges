#include <stdio.h>


int main() {
    
    //Varibles
    double intial, interest, minPay;
    
    //Asking the user for input
    printf("Enter the outstanding balance on your credit card:");
    
    scanf("%lf", remBalance);
        
    printf("Enter the annual credit card interest rate as a decimal:");
    
    scanf("%lf", interest)
        
    printf("Enter the minimum monthly payment rate as a decimal:");
    
    scanf("%lf", minPay);

    int i, k;
    
    
    
    for( i=12; i-- ; i>1; k =1; k++ )
    {
    
    minimumPayment();
    interestPaid();
    principalPaid();
    amountPaid();
    remainingBalance();
    printing();  
    }
        
    return 0;
}

double minimumPayment()
{
    double minPayment;
    minPayment=interest*remBalance
    return minPayment;
 // Minimum monthly payment = .02 x $4975.0 = $99.50  
}
double interestPaid()
{
  //Interest Paid = .18/12.0 x $4975.0 = $74.63  
intPaid = interest/ 12* remBalance;
    
    return intPaid;
    
}
double principalPaid()
{
    prinPaid= minPayment-intPaid;   //Principal Paid = $99.50 – $74.63 = $24.87
    
        return prinPaid;
}
double amountPaid()
{

amPaid+=minPayment;
return amPaid;
}
double remainingBalance()
{
   remBalance = remBalance - prinPaid
    //Remaining Balance = $4975.0 – $24.87 = $4950.13 
return remBalance
}
void printing()
{
    printf ("Month: %d",k);
    printf("Minimum monthly payment:%fl", minpayment);
    printf("Principle paid:%fl", prinPaid);
    printf("Remaining balance: %fl", remBalance);           
           
}
