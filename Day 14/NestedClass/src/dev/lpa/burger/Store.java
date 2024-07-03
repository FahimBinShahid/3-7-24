package dev.lpa.burger;

public class Store {
    public static void main(String[] args) {
        Meal regularMeal= new Meal();
        regularMeal.addToppings("Ketchup", "Mayo", "Bacon","Banana");
        System.out.println(regularMeal);

    }
}
