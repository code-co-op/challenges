var balance = Number(prompt("Please enter your balance: "));
//console.log(typeof balance)
var monthlyPaymentRate = Number(prompt("Please enter your monthly payment rate: "));
var annualInterestRate = Number(prompt("Please enter your annual interest rate: "));
var minMonthlyPayment;
var interestPaid;
var principalPaid;
var remainingBalance;

for (var i = 1; i <= 12; i++) {
  minMonthlyPayment = monthlyPaymentRate * balance;
  interestPaid = annualInterestRate / 12 * balance;
  principalPaid = minMonthlyPayment - interestPaid;
  remainingBalance = balance - principalPaid;
  balance = remainingBalance;
  console.log("Month " + i);
  console.log("Principal paid: $" + principalPaid.toFixed(2));
  //console.log("Interest paid: " + interestPaid.toFixed(2));
  console.log("Remaining balance: $" + remainingBalance.toFixed(2));
}
