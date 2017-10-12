#!/bin/ruby

def birthdayCakeCandles(n, ar)
    max = ar.max
    count = ar.count(max)
    return count
end

n = gets.strip.to_i
ar = gets.strip
ar = ar.split(' ').map(&:to_i)
result = birthdayCakeCandles(n, ar)
puts result;
