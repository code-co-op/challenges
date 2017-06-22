const numToDollars = amount => {
    
    let cents = '' + Math.round (amount * 100);
    return '$' + cents.slice (0, -2) + '.' + cents.slice (-2);
    
};

const printFigure = message => amount => {
    
    console.log (message, numToDollars (amount));
    
};


const monthlyFigures = ({balance, monRate, minRate}) => {
    
    const totPayment = balance * monRate;
    const intPayment = totPayment * monRate;
    const prinPayment = totPayment - intPayment;
    
    // console.log (balance, totPayment, prinPayment)
    
    return {
        
        balance: balance - totPayment,
        totPayment,
        prinPayment
        
    };
    
};


const oneYearBalance = annualRate => minRate => balance => {
    
    const printMonthlyPayment = printFigure ('Minimum monthly payment:');
    const printPrincipalPayment = printFigure ('Principle paid:');
    const printRemaining = printFigure ('Remaining balance:');
    
    let month = 0;
    
    while (month < 12) {
        
        const newFigures = monthlyFigures ({balance, monRate: annualRate/12, minRate});
        
        console.log ('Month: ', month++);
        printMonthlyPayment (newFigures.totPayment);
        printPrincipalPayment (newFigures.prinPayment);
        printRemaining (newFigures.balance);
        
        balance = newFigures.balance;
        
    }
};

module.exports = oneYearBalance;