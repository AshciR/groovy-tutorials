package io.richie.collections

import spock.lang.Specification

class Collections extends Specification {

    /*
    If you've worked with Java before you've
    probably worked with it's Collections library.
    This is the library which contains:
    List, Map, Set, etc..
     */

    /*
    Let's look briefly on how we'd create collections in Java
    prior to Java 10.
     */

    def 'Should create Java collections'() {
        given: 'We have some collections'

        // List of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5)

        // Using a Map to hold key/value pairs
        Map<String, Integer> foodsWithCalories = new HashMap<>()
        foodsWithCalories.put('Sushi', 300)
        foodsWithCalories.put('Pizza', 500)
        foodsWithCalories.put('Biryani', 800)

        // We should use sets when we don't want have duplicate values
        Set<String> engineers = new HashSet<>()
        engineers.add("Angela")
        engineers.add("Bob")
        engineers.add("Carl")

        expect: 'The collections to have the proper values'
        numbers.size() == 5
        foodsWithCalories.get("Biryani") == 800
        engineers.size() == 3

    }

    /*
    As we see above, the code works. But if you're noticing a
    theme so far, Java is verbose language. Let's see how we
    can do the same thing in Groovy.
     */

    def 'Should create Groovy collections'() {
        given: 'We have some collections'

        // List of numbers
        List<Integer> numbers = [1, 2, 3, 4, 5] // Groovyism: use [ ] to declare lists

        // Using a Map to hold key/value pairs
        // Groovyism: use  [key:value] to declare maps
        Map<String, Integer> foodsWithCalories = [
                'Sushi'  : 300,
                'Pizza'  : 500,
                'Biryani': 800,
        ]

        // Groovyism: use [ ] to declare sets as well. You'll have to explicitly
        // declare your data type as a Set though.
        Set<String> engineers = ["Angela", "Bob", "Carl"]
        def managers = ["Dave", "Earl", "Frank"].toSet() // This is an alt declaration

        expect: 'The collections to have the proper values'
        numbers.size() == 5
        foodsWithCalories."Biryani" == 800 // Groovyism: we can access values using the dot notation
        engineers.size() == 3
        engineers instanceof Set
        !(managers instanceof List)

    }

    /*
    Groovy provides syntactic sugar for working with Maps.
    In Java if we wanted to get the value for a key, we'd call
    the .get(key) method. And when we wanted to assign new values to
    the map, we'd call .put(key, value).

    Let's look on how we can do the same thing in a Groovy way.
     */

    def 'Take a closer look at Maps in Groovy'() {

        given: 'We have an empty Map'
        Map<String, String> languages = [:] // Groovyism: how we declare an empty Map

        when: 'We add values to the Map'
        languages."English" = "Hard" // N.B we're using a single = sign to assign a value
        languages."Spanish" = "Medium"
        languages."Japanese" = "Easy"

        then: 'The correct data should be there'
        languages."English" == "Hard" // N.B. we're using double == signs to check the value
        languages."Japanese" == "Easy"
        languages."Telugu" == null

    }

    /*
    Lastly, let's look on how we can perform some common operations on collections.
    Prior to Java 8, if we wanted to find all the values in a collection
    which matched some criteria we'd have to write code that looks like this.
     */

    def 'Should find all of the even numbers in a list'() {

        given: 'We have a list of numbers'
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5)

        when: 'We find the even numbers'
        List<Integer> evenNumbers = new ArrayList<>()
        for (Integer num : numbers) {
            if (num % 2 == 0) {
                evenNumbers.add(num)
            }
        }

        then: 'Only the even numbers should be there'
        evenNumbers == Arrays.asList(2, 4)
    }

    /*
    As usual, sure the above code works.. But let's imagine
    if your client comes into work tomorrow and decides that
    they want odd numbers instead, then the day after that
    they change their mind again. You'd have to keep on changing
    your code.
     */

    /*
    Ideally, we'd want the code to be generic enough so
    that we can pass in a list and a search criteria, then
    let the code handle the rest.

    If we remember the section about Closures, we realize
    that Closures and higher-order functions allow us
    to pass in different behaviors into functions.

    Let's look how we could solve the even numbers problem
    using Closures and Collections in Groovy.
     */

    def 'Should find all of the even numbers in a list in a Groovy way'() {

        given: 'We have a list of numbers'
        List<Integer> numbers = [1, 2, 3, 4, 5]

        when: 'We find the even numbers'
        List<Integer> evenNumbers = numbers.findAll { num -> num % 2 == 0 }

        then: 'Only the even numbers should be there'
        evenNumbers == [2, 4]
    }

    /*
    Look how concise that code is! This is why functional programming is
    considered a Declarative programming paradigm. We DECLARE (tell) the
    computer what we want achieved. We don't explicitly tell them HOW to
    do it.
     */

    /*
    Groovy has a ton a of these higher-order functions baked into the language.
    You can find an exhaustive list of them here:
    http://docs.groovy-lang.org/next/html/documentation/working-with-collections.html
     */

    /*
    Let's take a look at another popular use case when working with collections.
    Imagine that instead of FILTERing out the even numbers, we wanted to
    double the value of each number in the list.
    Phrased another way, we want to TRANSFORM each value in the collection
    into a new value.
     */

    def 'Should double the value of all the numbers'() {

        given: 'We have a list of numbers'
        List<Integer> numbers = [1, 2, 3, 4, 5]

        when: 'We find the even numbers'
        //Groovyism: use the .collect{} method to transform values
        List<Integer> evenNumbers = numbers.collect { num -> num * 2 }

        then: 'Only the even numbers should be there'
        evenNumbers == [2, 4, 6, 8, 10]
    }

    /*
    Above we used the .collect{} method to TRANSFORM each number into a new number.
    This concept in functional programming is called MAPPING
    (not to be confused with data structure called a Map).
    Other languages use a .map() method, but the Groovy guys decided
    to call theirs collect()
     */

    /*
    One more thing before we're done, I want you to notice that you're
    not limited to transforming values into the same data type.
    E.g. Integer -> Integer
    you can go from any data type into another, provided you have an
    appropriate function.

    Let's see.
     */

    def 'Should give the length of each word in a collection'() {

        given: 'I have a list of words'
        List<String> words = ['Hello', 'I', 'Love', 'Groovy']

        when: 'I get the length for each word'
        List<Integer> wordLengths = words.collect { word -> word.length() } // String -> Integer

        then: 'I should have the correct lengths'
        wordLengths == [5, 1, 4, 6]

    }

}
