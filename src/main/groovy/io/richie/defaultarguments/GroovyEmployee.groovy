package io.richie.defaultarguments

class GroovyEmployee {

    // Remember that these are now Groovy properties
    // because we omitted the access scope
    // Additionally, Groovy will not create any setters for
    // them b/c they are declared as final
    final String name
    final Integer salary

    GroovyEmployee(String name, Integer salary) {
        this.name = name
        this.salary = salary
    }

    // Method will be public by default in Groovy
    // Also, notice how we set the default value in the method
    // signature.
    String greetEmployee(String greeting = 'Hello') {
        "${greeting} ${this.name}" // Using G-String interpolation
    }

}
