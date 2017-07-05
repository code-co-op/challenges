def user_input
  puts 'Enter the outstanding balance on your credit card:'
  balance = gets.to_f
  puts 'Enter the annual credit card interest rate as a decimal:'
  interest_rate = gets.to_f
  puts 'Enter the minimum monthly payment rate as a decimal:'
  payment_rate = gets.to_f
  [balance, interest_rate, payment_rate]
end

def payment(balance, payment_rate)
  (balance * payment_rate).round(2)
end

def interest(balance, interest_rate)
  (interest_rate / 12 * balance).round(2)
end

def monthly_payments(balance, interest_rate, payment_rate)
  total_paid = 0

  (1..12).each do |month|
    monthly_payment = payment(balance, payment_rate)
    interest = interest(balance, interest_rate)
    principle = monthly_payment - interest

    balance -= principle
    total_paid += monthly_payment

    print_month(month, monthly_payment, principle, balance)
  end

  print_result(total_paid, balance)
end

def print_month(month, total_payment, principle_payment, balance)
  puts "Month: #{month}"
  puts format('Minimum monthly payment: $%.2f', total_payment)
  puts format('Principle paid: $%.2f', principle_payment)
  puts format('Remaining balance: $%.2f', balance)
end

def print_result(total_paid, balance)
  puts 'RESULT'
  puts format('Total amount paid: $%.2f', total_paid)
  puts format('Remaining balance: $%.2f', balance)
end

if $PROGRAM_NAME == __FILE__
  balance, interest_rate, payment_rate = user_input
  monthly_payments(balance, interest_rate, payment_rate)
end
