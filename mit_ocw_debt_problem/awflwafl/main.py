CURRENCIES = {
    "USD": {
        "name": "USA Dollar",
        "abbreviation": "USD",
        "symbol": "$"
    }
}

# allow passing currency for extendability
def format_currency(value, currency="USD"):
    """Format value as a string for a given currency
    """
    symbol = CURRENCIES[currency]["symbol"]

    return "%s%s" % (symbol, round(value) / 100)

if __name__ == "__main__":
    # propmpt & initialize
    balance         = float(raw_input("Enter the outstanding balance on your credit card: ")) * 100
    interest_rate   = float(raw_input("Enter the annual credit card interest rate as a decimal: ")) / 12
    payment_rate    = float(raw_input("Enter the minimum monthly payment rate as a decimal: "))
    paid            = 0.0

    for month in xrange(1,13):
        # calculate
        interest    = balance * interest_rate
        payment     = balance * payment_rate
        principle   = payment - interest

        # update
        balance     -= principle
        paid        += payment

        # output
        print "Month: %i" % month
        print "Minimum monthly payment: %s" % format_currency(payment)
        print "Principle paid: %s" % format_currency(principle)
        print "Remaining balance: %s" % format_currency(balance)

    # output
    print "RESULT"
    print "Total amount paid: %s" % format_currency(paid)
    print "Remaining balance: %s" % format_currency(balance)
