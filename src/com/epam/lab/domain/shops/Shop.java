package com.epam.lab.domain.shops;

import com.epam.lab.domain.goods.Product;
import com.epam.lab.enums.ShopTypeEnum;

import java.util.List;

public class Shop {
    protected String name;
    protected ShopTypeEnum shopType;
    protected Integer floor;
    protected List<Product> products;

    public Shop(String name, Integer floor, List<Product> products) {
        this.name = name;
        this.floor = floor;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Name - " + name + ", Floor - " + floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ShopTypeEnum getShopType() {
        return shopType;
    }

    public void setShopType(ShopTypeEnum shopType) {
        this.shopType = shopType;
    }
}
