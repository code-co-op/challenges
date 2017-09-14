require 'minitest/autorun'
require './candles_where_order_matters'

class CandleTest < Minitest::Test
  def test_one_candle
    assert_equal 1, how_many_candles?([3])
  end

  def test_zero_candles
    assert_equal 0, how_many_candles?([])
  end

  def test_ordered_candles
    assert_equal 4, how_many_candles?([2, 4, 6, 8])
  end

  def test_reverse_order
    assert_equal 1, how_many_candles?([10, 9, 8, 7, 6])
  end

  def test_mixed_order
    assert_equal 4, how_many_candles?([1, 5, 4, 6, 5, 7])
  end

  def test_all_candles_same_height
    assert_equal 5, how_many_candles?([4, 4, 4, 4, 4])
  end
end
