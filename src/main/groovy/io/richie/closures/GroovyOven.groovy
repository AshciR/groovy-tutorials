package io.richie.closures

class GroovyOven {

    //N.B how this method takes a String and a Closure (function) as parameters
    static String bakeFruitPastry(String fruit, Closure bakeInstructions) {

        // We're expecting this Closure to be a function that returns a String
        // E.g. { instructions -> "Do some baking here" }
        bakeInstructions.call(fruit)  // then we can just call(invoke) the Closure
    }
}
