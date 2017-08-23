Cake = Struct.new(:weight, :value)

def pick_cakes(index, cakes, capacity)
  return 0 if index == cakes.length || capacity.zero?

  current_cake = cakes[index]

  return pick_cakes(index + 1, cakes, capacity) if current_cake.weight > capacity

  using_current = current_cake.value +
                  pick_cakes(index, cakes, capacity - current_cake.weight)

  not_using_current = pick_cakes(index + 1, cakes, capacity)

  [using_current, not_using_current].max
end

def max_duffel_bag_value(cakes, capacity)
  pick_cakes(0, cakes, capacity)
end
