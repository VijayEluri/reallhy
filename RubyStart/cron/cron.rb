require 'rubygems'
require 'rufus/scheduler'

scheduler = Rufus::Scheduler.new

scheduler.every '3s' do
  puts "1 -  #{Time.new.strftime("%Y%m%d%H%M%S")}"

end


scheduler.join