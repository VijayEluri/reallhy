
presidents = %w(Ford Carter Reagon Bush1 Clinton Bush2 Obama)
presidents.pop          # pop - container끝에서 꺼내기
presidents.push "Nixon"      # push - container 뒤에 넣기
presidents.push "Johnson"
presidents.unshift "Kennedy" # unshift - container 맨앞에 넣기


puts presidents.collect! {|name| ': '+ name}
