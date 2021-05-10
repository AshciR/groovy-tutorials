package io.richie.conditionals

class FoodService {

    static String orderFood(String typeOfFood) {

        String orderedFood

        switch (typeOfFood) {
            case 'Thai':
                orderedFood = 'Pad Thai'
                break
            case 'Indian':
                orderedFood = 'Chicken 65'
                break
            case 'Italian':
                orderedFood = 'Shrimp Alfredo'
                break
            default:
                orderedFood = 'Pizza' // Everyone loves pizza!!
        }

        return orderedFood
    }

    static String orderGroovyFood(cravings) {

        String orderedFood

        switch (cravings) {
            case 'Thai':
                orderedFood = 'Pad Thai'
                break
            case ['Chinese', 'Indian', 'IndoChinese']: // Check's if something is in a list
                orderedFood = 'Gobi Manchurian'
                break
            case 300..1000: // Checks if something was within a calorie range
                orderedFood = 'Jerk Chicken'
                break
            case ~/American \w*/: // Check the regex (If a string starts with "American" in this example)
                orderedFood = 'Hot Dog'
                break
            case String: // Checks a data type. Similar to instanceof from Java
                orderedFood = 'Burger'
                break
            case { cravings < 100 }: // Checks an expression (These are closures. We'll discuss them later)
                orderedFood = 'Garden Salad'
                break
            default:
                orderedFood = 'Pizza' // Everyone loves pizza!!
        }

        // Groovyism: The "return" keyword is optional.
        // Groovy will return the last expression in a method for you
        orderedFood

    }

}
