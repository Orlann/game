package com.epam.lab.domain.goods;

import com.epam.lab.enums.MusicalEnum;

public final class MusicalInstrument extends Product {
    private MusicalEnum musicalType;
    private String material;

    public MusicalInstrument(String name, Double price, MusicalEnum musicalType, String material) {
        super(name, price);
        this.musicalType = musicalType;
        this.material = material;
    }

    @Override
    public String toString() {
        return "Musical Type - " + musicalType +", Instrument - " + name + ", material - " + material +
                ", price - " + price;
    }

    public MusicalEnum getMusicalType() {
        return musicalType;
    }

    public void setMusicalType(MusicalEnum musicalType) {
        this.musicalType = musicalType;
    }

    public String material() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
