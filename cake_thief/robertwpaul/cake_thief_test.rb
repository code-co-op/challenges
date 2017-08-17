require 'minitest/autorun'
require './cake_thief'

class CakeThiefTest < Minitest::Test

  def test_zero_capacity
    cakes = [Cake.new(7, 160), Cake.new(3, 90), Cake.new(2, 15)]
    capacity = 0
    assert_equal 0, max_duffel_bag_value(cakes, capacity)
  end

  def test_zero_cakes
    cakes = []
    capacity = 1000
    assert_equal 0, max_duffel_bag_value(cakes, capacity)
  end

  def test_one_cake_with_weight_equal_to_capacity
    cakes = [Cake.new(5, 70)]
    capacity = 5
    assert_equal 70, max_duffel_bag_value(cakes, capacity)
  end

  def test_cakes_with_spare_capacity
    cakes = [Cake.new(3, 9), Cake.new(2, 4)]
    capacity = 4
    assert_equal 9, max_duffel_bag_value(cakes, capacity)
  end

  def test_not_all_capacity_should_be_used
    cakes = [Cake.new(5, 25), Cake.new(4, 16)]
    capacity = 12
    assert_equal 50, max_duffel_bag_value(cakes, capacity)
  end

  def test_use_the_biggest_and_the_smallest
    cakes = [Cake.new(3, 9), Cake.new(2, 4), Cake.new(1, 1)]
    capacity = 4
    assert_equal 10, max_duffel_bag_value(cakes, capacity)
  end

  def test_use_a_really_valuable_small_cake
    cakes = [Cake.new(3, 9), Cake.new(2, 4), Cake.new(1, 30)]
    capacity = 4
    assert_equal 120, max_duffel_bag_value(cakes, capacity)
  end

  def test_interview_cake_test
    cakes = [Cake.new(7, 160), Cake.new(3, 90), Cake.new(2, 15)]
    capacity = 20
    assert_equal 555, max_duffel_bag_value(cakes, capacity)
  end

  def test_sorting
    input = [Cake.new(7, 160), Cake.new(3, 90), Cake.new(2, 15)]
    expected = [Cake.new(3, 90), Cake.new(7, 160), Cake.new(2, 15)]
    assert_equal expected, sorted_cakes(input)
  end
end
