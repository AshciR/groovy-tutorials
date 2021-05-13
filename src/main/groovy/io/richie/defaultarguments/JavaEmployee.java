package io.richie.defaultarguments;

public class JavaEmployee {

    private final String name;
    private final Integer salary;

    public JavaEmployee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public String greetEmployee(String greeting) {

        if (null == greeting) { // We'd have to check if it was null
            greeting = "Hello";
        }

        return greeting + " " + this.name;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }
}
