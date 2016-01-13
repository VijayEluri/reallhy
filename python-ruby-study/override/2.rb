class Cal
  @@history = []
  def initialize(v1, v2)
    @v1 = v1
    @v2 = v2
  end
  def add
  	result = @v1 + @v2
  	@@history.push("#{@v1}+#{@v2}=#{result}")
  	result
  end
  def subtract
  	result = @v1 - @v2
  	@@history.push("#{@v1}-#{@v2}=#{result}")
  	result
  end
  def setV1(v)
  	if v.is_a?(Integer)
  		@v1 = v
  	end
  end
  
  def inspect
  	"Cal => v1 : #{@v1}, v2 : #{@v2}"
  end

  def Cal.history
  	p "=== history ==="
  	for item in @@history
  		p item
  	end
  	nil
  end

end

class CalMultiply < Cal
  def multiply
  	result = @v1 * @v2
  	@@history.push("#{@v1}*#{@v2}=#{result}")
  	result
  end
  def inspect
  	"CalMultiply => #{super()}"
  end
end

class CalDivide < CalMultiply
  def divide
  	result = @v1 / @v2
  	@@history.push("#{@v1}/#{@v2}=#{result}")
  	result
  end
  def inspect
  	"CalDivide => #{super()}"
  end
end

c = CalDivide.new(100, 40)
p c.multiply
p c.divide
p c.add
p c.subtract
p c
Cal.history