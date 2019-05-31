package com.yield.designpattern.builderPattern;

/**
 * Created by yezid on 2018/5/3.
 */
public class MealBuilder {

    public Meal prepareVagMeal() {
        Meal meal = new Meal();
        meal.addItem(new Vegburger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVagMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

}
