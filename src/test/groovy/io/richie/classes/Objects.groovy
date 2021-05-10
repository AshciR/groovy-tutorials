package io.richie.classes

import spock.lang.Specification

class Objects extends Specification {

    def 'Java Food should contain the correct info'() {
        given: 'We have a food item'
        JavaFood curryShrimp = new JavaFood('Curry Shrimp', 450)

        // N.B. JavaFood is actually JavaFood.java, not JavaFood.groovy
        // This shows that Groovy is interoperable with existing Java code

        expect: 'The food to have the correct value'
        curryShrimp.getCalories() == 450
    }

    def 'Groovy Food should contain the correct info'() {
        given: 'We have a food item'

        // Groovyism: We're constructing the object using a named argument constructor
        GroovyFood curryShrimp = new GroovyFood(
                name: 'Curry Shrimp',
                calories: 450
        )

        expect: 'The food to have the correct value'
        curryShrimp.calories == 450 // N.B. this is the shortcut for calling curryShrimp.getCalories()
        // It's important to note that we're not directly accessing the field variable
    }

    def 'Can change the calories of food '() {
        given: 'We have a food item'

        // Groovyism: We're constructing the object using a named argument constructor
        GroovyFood curryShrimp = new GroovyFood(
                name: 'Curry Shrimp',
                calories: 450
        )

        when: 'We change the calories'
        // Groovyism: this is the shortcut for calling curryShrimp.setCalories()
        // IMPORTANT! Notice that we're using =, not ==.
        // = means assign the value; == means check the value
        curryShrimp.calories = 200

        then: 'The food to have the new value'
        curryShrimp.calories == 200
    }

    /*
    Ok. let's talk about access-level modifiers a.k.a scoping for a bit.
     */

}
