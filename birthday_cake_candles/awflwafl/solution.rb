class AssertionError < StandardError
end

class Candles
  def initialize(candles)
    @candles = candles
  end

  def blow_out
    return 0 if @candles.count == 0
    return 1 if @candles.count == 1

    case @candles.count

    tallest_height = @candles[0]
    count = 1

    @candles[1..@candles.count].each do |height|
      if height >= tallest_height
        tallest_height = height
        count += 1
      end
    end

    count
  end
end

# Assume all heights are positive integers

def assert_equal(actual, expected, description: nil)
  puts description if description

  raise AssertionError if actual != expected
rescue AssertionError
  puts "\tIncorrect: Expected #{actual} to equal #{expected}"
end

# Basic cases
assert_equal Candles.new([]).blow_out, 0, description: 'When there are no candles'
assert_equal Candles.new([1]).blow_out, 1, description: 'When there is only one candle'

# Combinations
assert_equal Candles.new([1, 2]).blow_out, 2, description: 'When candles are in ascending height'
assert_equal Candles.new([2, 1]).blow_out, 1, description: 'When candles are in descending height'

assert_equal Candles.new([1, 1]).blow_out, 2, description: 'When candles are of equivalent height'

assert_equal Candles.new([2, 1, 3, 2]).blow_out, 2, description: 'When the overshadowing candles are spaced out'
