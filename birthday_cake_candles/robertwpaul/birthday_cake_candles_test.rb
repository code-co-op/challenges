require 'minitest/autorun'
require './birthday_cake_candles'

class CandlesTest < Minitest::Test
  def test_one_candle
    assert_equal 1, how_many_candles?(1, [5])
  end

  def test_count_length_mismatch
    assert_raises { how_many_candles?(5, [1, 2]) }
  end

  def test_negative_number
    assert_raises { how_many_candles?(-4, []) }
  end

  def test_zero_length
    assert_raises { how_many_candles?(0, []) }
  end

  def test_all_candles_same_height
    assert_equal 5, how_many_candles?(5, [9, 9, 9, 9, 9])
  end

  def test_from_challenge
    assert_equal 2, how_many_candles?(4, [3, 2, 1, 3])
  end
end
