package com.epam.lab.domain.goods;

import com.epam.lab.enums.ShoesEnum;
/**
 * Class that represents kind of products - shoes
 */
public final class Shoes extends Product {
    private ShoesEnum shoesType;
    private String consumer;
    private String size;
    private String colour;
    private String material;

    public Shoes(String name, Double price, ShoesEnum shoesType, String consumer, String size, String colour, String material){
        super(name, price);
        this.shoesType = shoesType;
        this.consumer = consumer;
        this.size = size;
        this.colour =colour;
        this.material = material;
    }

    @Override
    public String toString() {
        return "Shoes Type - " + shoesType +", Name - " + name + ", Consumer - " + consumer + ", Size - " + size +
                ", Colour - " + colour + ", Material - " + material + ", Price - " + price;
    }

    public ShoesEnum getShoesType(){
        return shoesType;
    }

    public void setShoesType(ShoesEnum shoesType){
        this.shoesType =  shoesType;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String getSize(){
        return size;
    }

    public void setSize(String size){
        this.size = size;
    }

    public String getColour(){
        return colour;
    }

    public void setColour(String colour){
        this.colour = colour;
    }

    public String getMaterial(){
        return material;
    }

    public void setMaterial(String material){
        this.material=material;
    }
}
