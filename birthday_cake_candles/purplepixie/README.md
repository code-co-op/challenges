Most use a brute-force approach as follows:

* Set a counter to 0 (this is the number of candles you can blow out)
* Set a highest (found) variable to -1 to start
* Loop through each candle
* If the candle height is greater than the highest found then: Set highest found to new height and counter to 1
* If the candle height is the same height as the highest found then: Increment counter by 1
* If the candle height is less than the highest found we can just ignore
* Return the counter

The python example shows a good example of using higher level build in functions to find the highest value in the list and then count the number of occurances.
