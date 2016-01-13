require 'rubygems'
require 'rufus/scheduler'

def call_ant
  start = Time.now
  puts "############## Docbook build Start! [#{start}]"
  system("ant.bat -buildfile C:\\workspace\\anyframe-online-manual\\build.xml all")
  puts "############## End! [#{Time.now - start} sec]"
end

scheduler = Rufus::Scheduler.new

scheduler.every '5m' do
  call_ant
end

scheduler.join

