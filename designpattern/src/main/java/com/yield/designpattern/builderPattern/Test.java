package com.yield.designpattern.builderPattern;

/**
 * Created by yezid on 2018/5/3.
 */
public class Test {

    public static void main(String[] args) {
        // 进餐构建者
        MealBuilder builder = new MealBuilder();
        // 素食进餐
        Meal vagMeal = builder.prepareVagMeal();
        vagMeal.showItems();
        System.out.println("vagMeal total price:" + vagMeal.countPrice());

        // 肉食进餐
        Meal nonVagMeal = builder.prepareNonVagMeal();
        nonVagMeal.showItems();
        System.out.println("nonVagMeal total price:" + nonVagMeal.countPrice());
    }

}
