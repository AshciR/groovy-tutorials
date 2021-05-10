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

}
