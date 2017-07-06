#include <array>
#include <iomanip>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using std::cin;
using std::cout;
using std::ostringstream;
using std::string;
using std::vector;

struct Month {
  const int monthNumber;
  const double minimumPayment;
  const double principlePayment;
  const double remainingBalance;
};

struct Statement {
  const vector<Month> months;
  const double totalPaid;
  const double remainingBalance;
};

double calculatePayment(double balance, double paymentRate) {
  return balance * paymentRate;
}

double calculateMonthlyInterest(double balance, double interestRate) {
  return (interestRate / 12 * balance);
}

Statement buildStatement(int numberOfMonths,
                         double balance,
                         double interestRate,
                         double paymentRate) {

  vector<Month> monthlyPayments;
  double totalPaid = 0;

  for (int i = 1; i <= numberOfMonths; i++) {
    double monthlyPayment = calculatePayment(balance, paymentRate);
    double interest = calculateMonthlyInterest(balance, interestRate);
    double principle = monthlyPayment - interest;

    balance -= principle;
    totalPaid += monthlyPayment;

    Month m = {i, monthlyPayment, principle, balance};
    monthlyPayments.push_back(m);
  }

  return { monthlyPayments, totalPaid, balance };
}

void printStatement(Statement statement) {
  // use an ostringstream rather than cout so the io manipulators don't mess it all up
  ostringstream oss;
  oss << std::fixed << std::setprecision(2);

  for (const auto& month : statement.months) {
    oss << "Month: " << month.monthNumber << "\n";
    oss << "Minimum monthly payment: $" << month.minimumPayment << "\n";
    oss << "Principle paid: $" << month.principlePayment << "\n";
    oss << "Remaining balance: $" << month.remainingBalance << "\n";
  }

  oss << "RESULT\n";
  oss << "Total amount paid: $" << statement.totalPaid << "\n";
  oss << "Remaining balance: $" << statement.remainingBalance << "\n";

  cout << oss.str();
}

double getUserInput(string prompt) {
  string response;
  cout << prompt << ": ";
  cin >> response;

  try {
    return std::stof(response);
  } catch (std::invalid_argument& e) {
    cout << "Not a number!\n";
    exit(1);
  }
}

int main() {
  double balance = getUserInput("Enter the outstanding balance on your credit card");
  double interestRate = getUserInput("Enter the annual credit card interest rate as a decimal");
  double paymentRate = getUserInput("Enter the minimum monthly payment rate as a decimal");

  Statement s = buildStatement(12, balance, interestRate, paymentRate);

  printStatement(s);
}
