package io.richie.classes;

public class JavaFood {

    private String name;
    private Integer calories;

    public JavaFood(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return name + " has " + calories + "calories";
    }
}
