#!/usr/bin/ruby
print "Script Name : ", $0, "\n"
print "Process ID : ", $$, "\n"

ARGV.each do |a|
  print "Argument ", a, "\n"
end

=begin
x = 10
puts defined? x

$x = 10
puts defined? x

@x = 10
puts defined? x
=end

i=-100
puts "Before i : "+@i.to_s
(1...10).each{|i| puts i}
puts "After i :"+i.to_s

array = %w(alpha beta gamma)
puts array.collect{|word|
  word.capitalize       #iterate 결과에 적용
}
puts array.collect do |word|
  word.capitalize       #iterate에만 적용, 결과는 그대로
end
