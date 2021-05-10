package io.richie.classes

class GroovyFood {

    /*
     If you don't provide an scope,
     it's set to public by default.
     This differs from Java, where
     Java sets it to package-private.

     Also, if you don't provide the scope
     for class level variables, Groovy treats
     them as "properties".

     You can think of properties as syntactic sugar
     for field variables. When you create a property,
     Groovy will automatically create getters and setters
     for you.

     Additionally, you can access the getters and setters
     by calling class.property.

     Example:
     def curryShrimp = new GroovyFood('Curry Shrimp', 450)
     assert curryShrimp.calories == 450
     assert curryShrimp.getCalories() == 450

     Is the same thing.
     */
    String name
    Integer calories

    // Will uncomment later in the presentation
//    Integer getCalories() {
//        println 'We called the getter method. Not directly accessing the field'
//        calories
//    }
//
//    void setCalories(Integer calories) {
//        println 'We called the setter method. Not directly accessing the field'
//        this.calories = calories
//    }

    @Override
    String toString() {
        return name + " has " + calories + "calories";
    }

}
