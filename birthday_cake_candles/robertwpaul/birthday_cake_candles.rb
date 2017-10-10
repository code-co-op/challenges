
def how_many_candles?(num, candles)
  raise 'Count is wrong' if num != candles.length
  raise 'Count must be greater than 0' if num < 1

  candles.count { |c| c == candles.max }
end

def user_input
  puts 'How many candles?'
  num = Integer(gets.strip)
  puts 'How tall are the candles?'
  candles = gets.strip.split(' ').map { |s| Integer(s) }
  [num, candles]
end

if __FILE__ == $PROGRAM_NAME
  num, candles = user_input
  blow_outable = how_many_candles? num, candles
  puts "Blew out #{blow_outable} candles"
end
