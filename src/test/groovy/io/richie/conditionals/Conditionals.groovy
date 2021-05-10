package io.richie.conditionals


import spock.lang.Specification
import spock.lang.Unroll

class Conditionals extends Specification {

    /*
      Let's take a look at how if statements and switch/cases
      are handled in Java vs Groovy.

      As we discussed earlier, any legal Java code
      is also legal in Groovy. Therefore, standard
      Java if/else statements will work.
       */

    void determineIfILikeGroovy() {

        given: 'I have made up my mind how I feel about groovy'
        boolean doILikeGroovy = true

        when: 'I tell someone how I feel'
        String myFeelings = ''
        if (doILikeGroovy == true) {
            myFeelings = "I love Groovy!"
        }

        then: 'I should say the truth'
        assert myFeelings == "I love Groovy!"

    }

    void 'Should tell someone how you feel about Groovy'() {

        given: 'I have made up my mind how I feel about groovy'
        boolean doILikeGroovy = true

        when: 'I tell someone how I feel'
        String myFeelings = ''

        if (doILikeGroovy) { // N.B that we removed "== true"
            myFeelings = "I love Groovy!"
        }

        then: 'I should say the truth'
        assert myFeelings == "I love Groovy!"

    }

    /*
    In the above example noticed that we simply said
    if (doILikeGroovy) instead of if (doILikeGroovy == true).

    Groovy has built-in "type coercion" similar to Javascript.
    Type coercion: process of converting value from one type to another
    */

    /*
    Groovy will automatically try to evaluate expression
    within the parenthesis as boolean for you.

    Because of this, there are some expressions that will be
    treated a Groovy truths. (Similar to Truthy expressions from Javascript)

    Let's take a look at a few of them
     */

    def 'Groovy Truths'() {
        expect:
        true // true
        'A string that has a value' // non-empty string
        100 // non-zero number
        [1, 2, 3] // a collection that has things in it
    }

    /*
    On the other side of the coin, let's look at things
    that Groovy considers false.
     */

    // N.B that we'll negate the values so that the test will pass
    def 'Groovy Falses'() {
        expect:
        !false // false
        !'' // Empty String
        !0 // Zero
        ![] // An empty collection
        !null
    }

    /// ---------------- Switch Statements ----------------

    /*
    Just like Java, Groovy also handles switch/case statements.
    Let's look at how we use one in Java, then the Groovy equivalent
     */

    void shouldTellMeWhatIWantForDinner() {

        given: 'I have decided what type of food I want'
        String typeOfFood = 'Thai'

        when: 'I order the food'
        String orderedFood = FoodService.orderFood(typeOfFood)

        then: 'The correct type should come back'
        orderedFood == 'Pad Thai'

    }

    /*
    Ok, the Java version isn't too bad, but once we see
    some of the things you can do with the Groovy version,
    you might change your mind
     */

    @Unroll
    // This is from the Spock Framework.
    // It allows us to see of the test iterations
    void 'I order Groovy food type: #typeOfFood | expectedFood: #expectedFood'() {

        given: 'I have decided what type of food I want'

        when: 'I order the food'
        String orderedFood = FoodService.orderGroovyFood(typeOfFood)

        then: 'The correct type should come back'
        expectedFood == orderedFood

        where: // This is how the Spock framework does data-driven testing
        typeOfFood      | expectedFood
        'Thai'          | 'Pad Thai'
        'Chinese'       | 'Gobi Manchurian'
        'Indian'        | 'Gobi Manchurian'
        'IndoChinese'   | 'Gobi Manchurian'
        500             | 'Jerk Chicken'
        'Random String' | 'Burger'
        'American Food' | 'Hot Dog'
        75              | 'Garden Salad'

    }

    /*
    We see how more powerful the switch/case statement is in Groovy.
    It allows us to match not only on the String, but data type,
    ranges, Regular expressions, and more.
     */

}
