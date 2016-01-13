#beans = Array.new(125).map{rand}
#until beans.length==100
#  bean=beans.pop
#  puts "Nom, nom, nom, tastes like #{bean}"
#end

names=%w{Alice Bob Carol}
names.each do
  |name| puts "Hello #{name}"
end

#
#NAME="LEEHOYEON"
#@name='LeeHoYeon'
#def foo
#  name="Sam"
#  puts name
#  puts @name
#  puts NAME
#end
#foo