object Pitagoras extends App{
  // a^2 + b^2 = c^2, a + b + c = 1000
  (1 to 1000).foreach(a => {
    (1 to 1000).foreach(b => {
      val c = math.hypot(a,b)
      if(a < b && c.toInt == c && (a + b + c) == 1000)
        print(f"$a * $b * $c%3.0f = ${a * b * c.toInt}");
    })
  })
}

