def factorial(x: Double): Double = {
  def loop(acc: Double, inc: Double) = {
    if (inc == 0) acc
    else loop(acc * inc, inc - 1)
  }
  loop(1, x)
}

// Testing

factorial(6) // Displays 720