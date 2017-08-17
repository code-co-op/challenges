Cake = Struct.new(:weight, :value)

def sorted_cakes(cakes)
  cakes.sort { |a, b| b.value / b.weight <=> a.value / a.weight }
end

def max_duffel_bag_value(cakes, capacity)
  sorted_cakes(cakes).reduce(0) do |memo, cake|
    num = capacity / cake.weight
    capacity -= num * cake.weight
    memo + num * cake.value
  end
end
