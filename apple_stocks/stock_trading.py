# coding: utf-8
"""
authors: gening <benjaminzge AT gmail>
date:    2017-07-20 21:00
version: 0.1
desc: a programming exercise for stock trading.
"""

stock_prices_yesterday = [10, 7, 5, 8, 11, 9]
stock_prices_yesterday = [1, 3, 1, 3, 1, 3]


# buy-sell once in a day

def get_max_profit_once(stock_prices):
    profit_max = 0
    for i in range(len(stock_prices)):
        for j in range(len(stock_prices)):
            if j <= i:
                continue
            else:
                profit = stock_prices[j] - stock_prices[i]
                if profit > profit_max:
                    profit_max = profit
    return profit_max


print(get_max_profit_once(stock_prices_yesterday))


# buy-sell multiple times in a day

def get_max_profit_up_to(current_time, able_to_sell, stock_prices):
    if current_time == 0:
        profit_max_up_to_now = 0
    else:
        profit_max_up_to_now = 0
        for trade_time in range(current_time):
            # test for buying or selling at different trading time
            if able_to_sell == 1:
                profit = (stock_prices[current_time] - stock_prices[trade_time] +
                          get_max_profit_up_to(trade_time, 0, stock_prices))
            else:
                profit = get_max_profit_up_to(trade_time, 1, stock_prices)
            if profit > profit_max_up_to_now:
                profit_max_up_to_now = profit
    return profit_max_up_to_now


def get_max_profit(stock_prices_yesterday):
    now = len(stock_prices_yesterday) - 1
    max_profit = max(get_max_profit_up_to(now, 0, stock_prices_yesterday),
                     get_max_profit_up_to(now, 1, stock_prices_yesterday), )
    return max_profit


print(get_max_profit(stock_prices_yesterday))
