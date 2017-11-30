package com.epam.lab.domain.goods;

import com.epam.lab.enums.SportGoodEnum;

public final class SportGood extends Product {
    private SportGoodEnum sportGoodType;

    public SportGood(String name, Double price, SportGoodEnum sportGoodType){
        super(name, price);
        this.sportGoodType = sportGoodType;
    }

    @Override
    public String toString() {
        return "SportGood Type - " + sportGoodType + ", Name - " + name + ", Price - " + price;
    }

    public SportGoodEnum getSportGoodType(){
        return sportGoodType;
    }

    public void setSportGoodType(SportGoodEnum sportGoodType){
        this.sportGoodType = sportGoodType;
    }
}
