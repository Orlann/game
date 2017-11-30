package com.epam.lab.domain.goods;

import com.epam.lab.enums.ClothesEnum;
/**
 * Class that represents kind of products - clothes
 */
public final class Clothes extends Product {
    private ClothesEnum clothesType;
    private String consumer;
    private String size;
    private String colour;

    public Clothes(String name, Double price, ClothesEnum clothesType, String consumer, String size, String colour){
        super(name, price);
        this.clothesType = clothesType;
        this.consumer = consumer;
        this.size = size;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Clothes Type - " + clothesType +" Clothes name - " + name + ", Consumer - " + consumer +", Size - "
                + size + ", Colour - " + colour +", Price - " + price;
    }

    public ClothesEnum getClothesType(){
        return clothesType;
    }

    public void setClothesType(ClothesEnum clothesType){
        this.clothesType = clothesType;
    }

    public String getConsumer(){
        return consumer;
    }

    public void setConsumer(String consumer){
        this.consumer = consumer;
    }

    private String getSize(){
        return size;
    }

    private void setSize(){
        this.size = size;
    }

    private String getColour(){
        return colour;
    }

    private void setColour(String colour){
        this.colour = colour;
    }
}
