package com.epam.lab.domain.goods;

import com.epam.lab.enums.AnimalEnum;


public final class Animal extends Product {
    private AnimalEnum animalType;
    private String color;

    public Animal(String name, Double price, AnimalEnum animalType, String color) {
        super(name, price);
        this.animalType = animalType;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Animal Type - "+ animalType + ", Animal - "  + name + ", Color - " + color +  ", Price - " + price;
    }

    public AnimalEnum getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalEnum animalType) {
        this.animalType = animalType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
