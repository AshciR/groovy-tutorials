package io.richie.defaultarguments

import spock.lang.Specification

class DefaultArguments extends Specification {

    /*
    Let's talk about default values for methods
    and how they can help us write more defensive code.

    There might be cases where we want to
    use a default/fallback value when the caller of our methods
    do not provide one.

    Let's see how we'd handle this in Java.
     */

    def "Should increase the employee's salary"() {

        given: 'We have an employee with a name'
        JavaEmployee amy = new JavaEmployee("Amy", 1000)

        when: 'We greet them'
        String greeting = amy.greetEmployee("What's up")

        then: 'The they should be greeted'
        greeting == "What's up Amy"

    }

    def "Should not increase the employee's salary if no value is provided"() {

        given: 'We have an employee with a name'
        JavaEmployee amy = new JavaEmployee("Amy", 1000)

        when: 'We greet them'
        // N.B Groovy will allow you to call the method without any arguments
        // Even though we said the method expects a String
        String greeting = amy.greetEmployee()

        then: 'The they should be greeted'
        greeting == 'Hello Amy'

    }

    /*
    Notice how we had to do an explicit null check inside of increaseSalary().
    It works, but think about if we had multiple arguments to check,
    we can see how the amount of code would blow up.
    And we love to write more precise code b/c we're great engineers.
     */

    /*
    Let's look how Groovy handles the same use case
     */

    def "Should increase the Groovy employee's salary"() {

        given: 'We have an employee with a name'
        GroovyEmployee amy = new GroovyEmployee("Amy", 1000)

        when: 'We greet them'
        String greeting = amy.greetEmployee()

        then: 'The they should be greeted'
        greeting == 'Hello Amy'

    }

}
