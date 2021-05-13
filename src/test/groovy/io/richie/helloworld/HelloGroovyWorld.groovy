package io.richie.helloworld

import spock.lang.Specification

class HelloGroovyWorld extends Specification {

    /*
    The first thing we should keep in mind is
    that Groovy is a superset of Java.
    Meaning anything that's valid/legal syntax in Java
    will also work in Groovy.
    */

    /*
    That being said, Groovy provides syntactic sugar
    (shortcuts) for many common operations which you would do in Java.
    */

    /*
    Let's take a look at some examples how we'd do things in Java
    then we can look at how it's done in Groovy
     */

    void helloJavaWorld() {
        expect: 'To print Hello World'
        System.out.println("Hello Java World");
    }

    def 'Hello Groovy World'() {
        expect: 'To print Hello World'
        println("Hello Groovy World") // N.B. semi-colons are optional in Groovy
    }

    /*
    Groovy provides us with a bunch of "shortcut" methods.
    We just used the println() method above.
    You can find a lot of these methods inside the DefaultGroovyMethods class
    */

    /*
     N.B. We're using Spock's preferred way declaring test cases.
     Spock is a testing framework made to work with Groovy.
     https://spockframework.org/

     Spock is to Groovy, as JUnit is to Java.
     Discussing Spock fully would be out of scope for this presentation
     */

    /*
    Java is a statically-typed language.
    This means we have to explicitly tell the
    program what the data type for variables are.
    E.g.
    String greeting = "Hello World";

    In the example above, the variable greeting has the data type of String.

    In contrast to Java, Groovy is a dynamically-typed language.
    Means that we don't have to define the type at compile time.
    During runtime, the program will trying to figure out what the type is.

    "If it walks like a duck, and quacks like a duck, it's probably a duck"
     */

    def 'Dynamic or Duck typing'() {

        given: 'I have some ducks'
        String donaldDuck = 'Donald Duck' // Explicit typing
        def daisyDuck = 'Daisy Duck' // implicit typing

        expect: 'The ducks to be the correct type'
        donaldDuck instanceof String
        daisyDuck instanceof String

        !(donaldDuck instanceof Number)

    }

    /*
    Dynamic programming gives you, the programmer a lot of power to bend rules during compile
    time, but you're giving up the safety provided by the IDEs and compiler.
    So use it at your own caution.
     */

    /*
    Let's get our feet wet in Groovy by working with a basic data type, Strings
    Strings are more diverse than in Java. Groovy provides us 2 ways to create Strings.
    Let's take a look
     */

    def 'String manipulation in Groovy'() {

        given: 'We have some strings'
        String greeting = 'Hi there!' // N.B this one has single quotes
        String greeting2 = "Hi there again!" // N.B this one has double quotes

        expect:
        greeting == 'Hi there!'
        greeting2 == 'Hi there again!'

    }

    /*
    Groovy also has a concept called G-Strings (Yea, I know awkward naming lol)
    A G-String allows you to evaluate expressions within it.

    This is great, because we can avoid concatenating Strings as we did in Java.
    Let's looks
     */

    def 'Using values inside of G-Strings'() {
        given: 'We have the meaning of life'
        Integer theAnsToLife = 42

        when: 'We tell someone'
        // use ${} syntax to tell Groovy this is an expression
        String meaningOfLife = "The meaning of life is ${theAnsToLife}"

        then: 'The meaning should be correct'
        meaningOfLife == "The meaning of life is 42"

    }

    /*
    Notice how the G-String evaluated the variable for us.
    This is more concise than what we'd have to do in Java.
     */

    /*
    Expressions aren't limited to just a variable, we can do
    calculations as well. Let's see.
     */

    def 'Using values inside of G-Strings part 2'() {
        given: 'We have the meaning of life'
        Integer theAnsToLife = 42

        when: 'We tell someone two times'
        String meaningOfLife = "The meaning of life is ${theAnsToLife * 2}"

        then: 'The meaning should be correct'
        meaningOfLife == "The meaning of life is 84" // We doubled the meaning

    }

    /*
    We saw how we were able to do a calculation within the expression.
    That's the power of the G-Strings.
     */
}
