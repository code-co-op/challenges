const logger = (() => {
    
    let logBuffer = [];
    
    return {
        
        append: message => {
            
            logBuffer = logBuffer.concat (message);
            
        },
        
        flush: () => {
            
            console.log (logBuffer.join ('\r\n'));
            logBuffer = [];
            
        }
    };
})();

const numToCurrency = symbol => amount => (
    
    symbol + amount.toFixed (2)
    
);


const monthlyFigures = ({currentBalance, monthlyRate, minimumRate}) => {
    
    const monthlyPayment = currentBalance * minimumRate;
    const interestPayment = currentBalance * monthlyRate;
    const principalPayment = monthlyPayment - interestPayment;
    
    return {
        
        newBalance: currentBalance - principalPayment,
        monthlyPayment,
        principalPayment
        
    };
    
};


const runningBalance = maxMonths =>
        ({annualRate, minimumRate, startingBalance}) => {
    
    const runningBalanceRecur =
            ({currentBalance, totalPaid, monthIndex}) => {
        
        if (monthIndex === maxMonths)
            return {currentBalance, totalPaid};
        
        let {newBalance, monthlyPayment, principalPayment} =
                monthlyFigures ({
            
            currentBalance,
            monthlyRate: annualRate / 12,
            minimumRate
            
        });
        
        const numToDollars = numToCurrency ('$');
        logger.append ('Month: ' + (monthIndex + 1));
        logger.append ('Minimum monthly payment: ' +
                numToDollars (monthlyPayment));
        logger.append ('Principle paid: ' +
                numToDollars (principalPayment));
        logger.append ('Remaining balance: ' + numToDollars (newBalance));
        
        return runningBalanceRecur ({
            
            currentBalance: newBalance,
            totalPaid: totalPaid + monthlyPayment,
            monthIndex: monthIndex + 1
            
        });
        
    };
    
    return runningBalanceRecur ({
        
        currentBalance: startingBalance,
        totalPaid: 0,
        monthIndex: 0
        
    });
};


const main = annualRate => minimumRate => startingBalance => {
    
    let {currentBalance, totalPaid} = runningBalance (12)({
        annualRate, minimumRate, startingBalance});
    
    const numToDollars = numToCurrency ('$');
    logger.append ('RESULT');
    logger.append ('Total amount paid: ' + numToDollars (totalPaid));
    logger.append ('Remaining balance: ' + numToDollars (currentBalance));
    logger.flush ();
    return true;
    
};


module.exports = main;

