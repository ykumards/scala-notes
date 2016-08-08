When the last action in a function is to call another function or itself, then we can happily discard the function's call stack. This works as the control is handed back to the caller at the end of this action.

Ex:

Factorial computation function can be slopily written as
```scala
def factorial(x: Double): Double = {
  if (x <= 1) 1
  else x * factorial(x-1)
}
```

This function sill lead to a rather tedious evaluation

```
factorial(5)
5 * factorial(4)
5 * 4 * factorial(3)
5 * 4 * 3 * factorial(2)
5 * 4 * 3 * 2 * factorial(1)
5 * 4 * 3 * 2 * 1
```

However, if we'd modify this function to be tail recursive, the parent factorial function is relieved of the burden of keeping track of it's children

```scala
def factorial(x: Double): Double = {
  def loop(acc: Double, inc: Double) = {
    if (inc == 0) acc
    else loop(acc * inc, inc - 1)
  }
  loop(1, x)
}
```

