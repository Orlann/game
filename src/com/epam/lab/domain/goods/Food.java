package com.epam.lab.domain.goods;

import com.epam.lab.enums.FoodEnum;

import java.util.Date;
/**
 * Class that represents kind of products - food
 */
public class Food extends Product {
    private FoodEnum foodType;
    private Integer discount;

    public Food(String name, Double price, FoodEnum foodType, Integer discount) {
        super(name, price);
        this.foodType = foodType;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food Type - " + foodType +" Food name - " + name + ", Price - " + price;
    }

    public FoodEnum getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodEnum foodType) {
        this.foodType = foodType;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discont) {
        this.discount = discont;
    }
}
