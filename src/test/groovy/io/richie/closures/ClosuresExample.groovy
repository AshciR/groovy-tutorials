package io.richie.closures

import spock.lang.Specification

import static io.richie.closures.Closures.addTwoToValue

class ClosuresExample extends Specification {

    /*
    Ok, now we're gonna talk about a concept called closures (lambda functions).
    If you haven't been programming using Java 8 new functional programming features,
    or in other languages which support functional programming,
    I'm going to need your full attention now.

    Prior to Java 8, Java was solely an Object-oriented and imperative
    programming language. In short, this means that everything you did
    had to be babysat (wrapped by a class/object).

    Methods could only take primitive values (i.e. ints, boolean, longs)
    or objects (String, Integer, BigDecimal) as input arguments for methods.

    Similarly, you could only assign such values to variables.
    E.g.
    String food = "Pizza"
    or
    int primeNumber = 7
     */

    /*
    In functional programming languages, they have expanded support.
    You can use other functions(methods) as arguments for methods and
    you can assign functions(methods) to variables.

    E.g.
    def addOneToValue = { number -> number + 1 }

    It might be a new concept, but once you use enough, you'll get the hang of it
    so hold on.

    When I first learned about this, this is how I wrapped my mind around it,
    see if this helps you as well.
    Remember when you were back in Middle school or High school, and your
    teacher taught you about functions?
    f(x) : x + 2
    f(2) = 2 + 2 = 4
    f(3) = 3 + 2 = 5

    Try to envision the Groovy syntax in the same way.
    f(x) : x + 2 // High school maths
    def addTwoToNumber = x -> x + 2   // Groovy code

    Now if you wanted to call you function(closure) in Groovy, you'd do it like this
    def ans = addTwoToNumber(2)
    which would be the same as
    def ans = 2 + 2

    If you don't get it yet, that's ok. Let's take a look at some example code.
     */

    def 'Should add 2 the my value using a method'() {
        expect: '2 to be added to the value'
        addTwoToValue(2) == 4
    }

    def 'Should add 2 the my value using a closure'() {

        given: 'I have a closure that adds 2 to a value'
        def addTwoToValue = { value -> value + 2 } // Note the use of the curly braces syntax

        expect: '2 to be added to the value'
        addTwoToValue(2) == 4 // N.B. how we call the Closure like a regular method
    }

    /*
    The above example may seem trivial, but it's a very powerful concept.
    Being able to assign functions to variables or create functions without
    a wrapper class allows us to to HIGHER-ORDER programming.

    Higher-order programming allows us to write more generic/abstract functions
    which is a good thing. The more generic/abstract a function is
    the more reusable it is. And the more reusable a function is
    is the less code we'll have to add to the code base.
    Meaning less maintenance, less things to write, and less bugs.
     */

    /*
    Let's take a look at a more complex example.
    We use methods and functions all the time, but let's really
    look at what a function is.
    In general, in most cases a function takes some input,
    does some work, then produces an output.
    E.g. apple -> bakes -> apple pie
     */

    /*
    If we didn't have functional programming, let's look
    how we'd have to bake a pie prior to Java 8
     */

    def 'Should bake pies with Java Oven'() {
        given: 'We have an apple'
        String apple = "Apple"

        when: 'We bake the apple into different things'
        String applePie = JavaOven.bakeFruitPie(apple)
        String appleTurnOver = JavaOven.bakeFruitTurnover(apple)
        String appleMuffin = JavaOven.bakeFruitMuffin(apple)

        then: 'The correct pies should be baked'
        applePie == "Baked into a delicious Apple pie!"
        appleTurnOver == "Baked into a delicious Apple turnover!"
        appleMuffin == "Baked into a delicious Apple muffin!"
    }

    /*
    Notice how we'd have to create a new method for each type of pastry.
    Or we'd create a bake() method, that would have an if or switch case
    inside of it.

    The general/abstract concept is that we want to bake a pastry.
    We'd love if we could just tell the oven how to bake the pastry,
    then let it do it.

    With higher-order programming we can achieve ths. We'll
    pass in our bake instructions as an argument, then let our
    bake() method do the rest for us
     */

    def 'Should bake pies with Groovy Oven'() {
        given: 'We have an apple'
        String apple = 'Apple'

        when: 'We bake the apple into different things'
        // N.B. The first argument is the fruit,
        // and the second argument is how we want to bake the fruit
        String applePie = GroovyOven.bakeFruitPastry(apple) { fruit -> "Baked into a delicious ${fruit} pie!" }
        String appleTurnOver = GroovyOven.bakeFruitPastry(apple) { fruit -> "Baked into a delicious ${fruit} turnover!" }
        String appleMuffin = GroovyOven.bakeFruitPastry(apple) { fruit -> "Baked into a delicious ${fruit} muffin!" }

        then: 'The correct pies should be baked'
        applePie == "Baked into a delicious Apple pie!"
        appleTurnOver == "Baked into a delicious Apple turnover!"
        appleMuffin == "Baked into a delicious Apple muffin!"

    }

    /*
    Above we just showed how we can reuse bakeFruitPastry() by passing in
    a baking criteria instead of having to write separate methods, or using
    conditional statements.
    We'll soon see how this concept is using when we're working with Collections
    in the next section.
     */

}
