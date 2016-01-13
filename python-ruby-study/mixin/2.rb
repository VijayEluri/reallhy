module Multiply
  def multiply()
  	@v1*@v2
  end
end

module Divide
  def divide()
  	@v1/@v2
  end
end

class Cal
  include Multiply, Divide
  attr_accessor :v1, :v2	
  def initialize(v1, v2)
    @v1 = v1
    @v2 = v2
  end

  def add()
  	@v1 + @v2
  end
  def subtract()
  	@v1 - @v2
  end
end

c = Cal.new(100, 10)
p c.add()
p c.multiply()
p c.divide()
p c.v2
c.v2 = 100
p c.v2