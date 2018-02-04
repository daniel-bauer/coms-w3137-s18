## Scala: Scalable, Functional and Cool

So far, most of you guys have only written Java: imperative and strictly object-oriented. While Java gives you a strong foothold in your life as a programmer, there's a whole world of **functional** programming languages brewing hot out there. We will learn Scala as an example.

Scala has many nice features: a less chaotic type system, smart type conversion, support for both object-oriented and functional approaches etc. Most importantly, Scala's functional (you will see what this means in a second) will get you guys to think about some of the data structures problems you will see in this class in different ways.

## The Scala environment

There are three ways in which we can use Scala to do stuff.

###1. REPL

Unlike Java, Scala has what is known as a read-eval-print loop (REPL). You can activate this by simply typing `scala` on your console. You will get something like this.

```bash
$scala
Welcome to Scala 2.12.1 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_60).
Type in expressions for evaluation. Or try :help.

scala >
```

You can test random things on your own without having to write code into a text file, compiling and then running it. This makes it super convenient to quickly test language features that you learn. 

###2. Scripting

Unlike Java, Scala code can also be written as a script. Instead of compiling code down to object files, you can just write an executable script and have it executed iteratively. We can save the following file as `HelloWorld.scala`

```scala
// HelloWorld.scala 
println("Hello World!")
```
And then simply execute it by doing the following:

```bash
$scala HelloWorld.scala
Hello World
$
```

If any of you are familiar with Python, this is very similar to the Python environment.

###3. Compiling Scala

Finally, we can also compile Scala code into an object file, just like how Java is. Coincidentally, Scala runs on the Java Virtual Machine, which means that it compiles down to `.class` files, containing bytecode executable on the JVM.

Let's write a `HelloWorld.scala`

```scala
object HelloWorld {
	def main(args: Array[String]): Unit = {
		println("Hello world")
	}
}
```

We can compile this as follows:

```bash
$scalac HelloWorld.scala 
$scala HelloWorld
Hello world
$
```

`scalac` compiler will create a `HelloWorld.class` from `HelloWorld.scala`, which you can execute just like how you did in Java.

## Some Scala Syntax Stuff (SSss....)

### var and val

Unlike Java, Scala has two types of names. 

Things can be a `var`, in which case a different object can be assigned to the variable. `var` literally means a variable.

You also have `val`s, or values. These, once created, cannot be changed whatsoever. `val`s promote readability, in the sense that to figure what something is, you just need to look at where they were created. They also promote a more functional style of programming.
In general, you should never, ever use `var` and try to think of a way to use `val` instead. In fact, the current trend of Java in the industry is to declare
 everything with the `final` keyword to achieve the same result. 
```
val x = 5 // Same as final int x = 5; in java
```
### 1. Types

Use `:` after names to specify types.

```scala
val x: Int = 5
val y: String = "Hello"
```

Scala will also infer types for you:

```scala
// this is totally fine
val x = 5
val y = "Hello" 
```

Type annotation is a hotly debated topic in the Scala community. Some think that the added readability 
is a plus while others think that it is redundant. I personally side with the former opinion of readability 
over convenience and so should you.
### 2. Java libraries and classes

Scala actually fully supports Java libraries. You can import them, use them as you like. Let's use a Java String in Scala:

```scala
val x: java.lang.String = "hello" // Java string.
val y: String = "hello" // Scala string.
```

With that sad, it is highly encouraged that you stick to native Scala types. 

### 3. EVERYTHING IS AN EXPRESSION

What does this mean? Every block of code will return a value. Blocks with curly braces will return the last expression in the block.

```scala
val x =
{
	val x = 4;
	val y = 2;
	x / y
}
// x is now equal to 2, since that's what the expression x/y returned.
// Notice how the val x inside is part of a separate thread of
// execution so there's no name conflict.
```

What does say about methods? Methods are blocks of codes too right? We don't actually have to write a `return` keyword unless we have to!

```scala
def someMethod(x:Int) : Int =  {
	val y = x
	y / 2
}

println(someMethod(4)) //prints 2
```

`x / 2` is an expression that simply returns what it evaluates.
Essentially, consider every last line of a code block to be prefixed with an implicit `return` keyword. Personally,
this is a readability overhead so I prefer not to do it but this has a wonderful implication when applied to 
conditionals.

```scala
val a = 2
val y = {
	if (a == 2) 
		1 
	else 
		2
}
```

Preferred way of writing this is to use the `ternary expression`. 
```scala
val a = 2
val y = if (a == 2) 1 else 2
```

## Functional?

Unlike Java, Scala treats functions as first class objects just like `Int` and `Double`. This means that functions
can be passed around and mainipulated just like any other regular types.

### Functions as objects

In Scala, functions can be stored as values and can simply passed around. Let's consider the following basic function:

```scala
def add(x: Int, y: Int) : Int = x + y
```
Remember, since everything in scala is an expression, the above is equivalent to 

```scala
def add(x: Int, y: Int) : Int = {
  return x + y
}
```

This is a basic method that adds up two integers and returns the sum. We can store this in a value and pass it into other functions. Let's see:

```scala
def square(x:Int) : Int =  x * x

def doComputation(x: Int, y: Int => Int) = y(x)

val x: Int => Int = square

println(doComputation(2, x)) // prints out 4, which is 2*2
```

There is some syntax here that you guys might not be familiar with, but the idea is that we just took a function, stored it in a value valled `x`, and then we passed this into another function which took that function as a value to do a computation. 

This opens up a whole different paradigm of programming approaches that we'll be exploring a lot more in depth over the semester.

