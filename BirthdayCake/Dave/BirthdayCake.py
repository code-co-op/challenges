#!/bin/python3

import sys

def birthdayCakeCandles(n, ar):
    highest = max(ar)
    count = ar.count(highest)
    return count

n = int(input().strip())
ar = list(map(int, input().strip().split(' ')))
result = birthdayCakeCandles(n, ar)
print(result)
