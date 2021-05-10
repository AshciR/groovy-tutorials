package io.richie.loops

import spock.lang.Specification

class Loops extends Specification {

    /*
    Let's take a look at how loops are handled
    in Java vs Groovy.

    As we discussed earlier, any legal Java code
    is also legal in Groovy. Therefore, standard
    Java loops will work.
     */

    void forLoopsInJava() {

        expect: '0 to 5 to be printed'
        for (int i = 0; i < 6; i++) {
            System.out.println(i)
        }

    }

    def 'Groovy way to print over a range'() {

        expect: '0 to 5 to be printed'
        for (i in 0..5) { // N.B. Groovy provides a concept called a Range
            println(i)
        }

    }

    /*
    Groovy has a concept called Range.
    Where you can specify numbers within a specific range.
    E.g.
    0..5 would be 0, 1, 2, 3, 4, 5 (Exclusive Range)
    0..<5 would be 0, 1, 2, 3, 4 (Inclusive Range
     */

    /*
    Let's take a look on how we'd loop over a list of objects.
     */

    void forLoopsInJavaPt2() {

        given: 'We have a list of numbers'
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5)

        expect: 'All the numbers to be printed'
        for (Integer num : numbers) {
            System.out.println(num)
        }

    }

    def 'Loop over a list of in Groovy'() {

        given: 'We have a list of numbers'
        List<Integer> numbers = [1, 2, 3, 4, 5] // N.B. [ ] is a Groovyism for creating a list

        expect: 'All the numbers to be printed'
        for (num in numbers) {
            println num // N.B. in Groovy, if your method only has 1 argument, the parenthesis are optional
        }

    }

    /*
    Let's look how we'd loop over Maps
     */

    void loopOverMapInJava() {
        given: 'We have a map of food and their calories'
        Map<String, Integer> foodsWithCalories = new HashMap<>()
        foodsWithCalories.put('Sushi', 300)
        foodsWithCalories.put('Pizza', 500)
        foodsWithCalories.put('Biryani', 800)

        expect: 'To print out all of the dishes and their calories'
        for (Map.Entry<String, Integer> food : foodsWithCalories.entrySet()) {
            System.out.println("Food: " + food.getKey() + " | Calories: " + food.getValue())
        }
    }

    def 'Loop over maps in Groovy'() {
        given: 'We have a map of food and their calories'
        Map<String, Integer> foodsWithCalories = [
                'Sushi'  : 300,
                'Pizza'  : 500,
                'Biryani': 800
        ]

        expect: 'To print out all of the dishes and their calories'
        for (food in foodsWithCalories) {
            println("Food: " + food.key + " | Calories: " + food.value)
        }
    }

    def 'Loop over String in Groovy'() {

        given: 'We have a String'
        String thoughts = "I am liking this tutorial"

        and: 'We have an empty list'
        List<String> characters = [] // Remember we can create an empty list using this syntax

        when: 'We add all of the characters to a list'
        for (character in thoughts) {
            characters << character // Groovyism for adding things to a list
        }

        then: 'The list should contain all of the characters'
        characters.size() == 25
    }
}
