
def how_many_candles?(candles)
  highest = 0
  candles.reduce(0) do |memo, c|
    memo += 1 if c >= highest
    highest = c if c > highest
    memo
  end
end
