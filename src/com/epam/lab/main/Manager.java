package com.epam.lab.main;

import com.epam.lab.domain.goods.*;
import com.epam.lab.domain.shops.Shop;
import com.epam.lab.enums.*;
import com.epam.lab.exceptions.InvalidProductNumberException;
import com.epam.lab.exceptions.InvalidShopNumberException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Manager {
    private static final Logger LOG = Logger.getLogger(Manager.class);
    public static final List<Integer> availableShopsNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3));

    public Player setPlayer(Player player) throws IOException {
        System.out.println("GAME STARTED");
        System.out.println("Plese enter your sex: F - female, M - male");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String enteredSex = "";
        do {
            enteredSex = bufferedReader.readLine();
            enteredSex = enteredSex.toUpperCase();
            if (!"M".equals(enteredSex) && !"F".equals(enteredSex)) {
                System.out.println("You entered incorrect value. Please enter correct sex: F - female, M - male");
            }
        } while (!enteredSex.equals("M") && !enteredSex.equals("F"));

        // TODO clear console

        System.out.println("Please enter your name");
        String playerName = bufferedReader.readLine();
        player.setName(playerName);
        player.setSex("M".equals(enteredSex) ? "male" : "female");
        return player;
    }

    public Shop chooseShops(boolean isRealPlayer, List<Shop> shops) {
        Integer shopNumber;
        if (isRealPlayer) {
            System.out.println("\nPlease choose a shop:");
            int i = 0;
            for (Shop shop : shops) {
                System.out.println(String.format("%d - %s", ++i, shop.getName()));
            }
            do {
                Scanner scanner = new Scanner(System.in);
                shopNumber = scanner.nextInt();
                if (shopNumber > shops.size()) {
                    try {
                        throw new InvalidShopNumberException();
                    } catch (InvalidShopNumberException e) {
                        LOG.error(e.getMessage());
                        LOG.error("You should choose shop again");
                    }
                }
            } while (shopNumber > shops.size());


        } else {
            Random randomNumber = new Random();
            shopNumber = randomNumber.nextInt(shops.size()) + 1;
            System.out.println(String.format("Computer chose shop: %s", shops.get(shopNumber - 1)));
        }
        return shops.get(shopNumber - 1);

    }

    public Product chooseProduct(boolean isRealPlayer, Shop shop) {
        Integer productNumber;
        if (isRealPlayer) {
            System.out.println("\nPlease choose a product:");
            int i = 0;
            for (Product product : shop.getProducts()) {
                System.out.println(String.format("%d - %s", ++i, product));
            }
            do {
                Scanner scanner = new Scanner(System.in);
                productNumber = scanner.nextInt();
                if (productNumber > shop.getProducts().size()) {
                    try {
                        throw new InvalidProductNumberException();
                    } catch (InvalidProductNumberException e) {
                        LOG.error(e.getMessage());
                        LOG.error("You should choose product again");
                    }
                }

            } while (productNumber > shop.getProducts().size());

        } else {
            Random randomNumber = new Random();
            productNumber = randomNumber.nextInt(shop.getProducts().size()) + 1;
            System.out.println(String.format("Computer chose product: %s", shop.getProducts().get(productNumber - 1)));
        }

        return shop.getProducts().get(productNumber - 1);
    }

    public List<Shop> initializeShops() {
        List<Shop> shops = new ArrayList<>();
        // Initializing of products for animal shop
        List<Product> animalProducts = new ArrayList<>();
        Product cat = new Animal("Siam cat", 600.0, AnimalEnum.CAT, "white");
        animalProducts.add(cat);
        Product fish = new Animal("Trichogaster microlepis", 150.0, AnimalEnum.FISH, "red and blue");
        animalProducts.add(fish);
        Product dog = new Animal("Dog", 300.0, AnimalEnum.DOG, "black");
        animalProducts.add(dog);
        Product parrot = new Animal("Wavy parrot", 150.0, AnimalEnum.BIRD, "green");
        animalProducts.add(parrot);
        Product rabbit = new Animal("Rabbit", 200.0, AnimalEnum.RABBIT, "white");
        animalProducts.add(rabbit);
        Product hamster = new Animal("Hamster", 160.0, AnimalEnum.HAMSTER, "brown");
        animalProducts.add(hamster);
        Shop animalShop = new Shop("ZOO-LIFE", 3, animalProducts);
        shops.add(animalShop);
        // Initializing of products for clothes shop
        List<Product> clothesProducts = new ArrayList<>();
        Product furcoat = new Clothes("Nutria furcoat", 2000.0, ClothesEnum.FURCOAT, "woman",
                "38-48", "brown");
        clothesProducts.add(furcoat);
        Product overcoat = new Clothes("Luxia", 900.0, ClothesEnum.OVERCOAT, "man",
                "48-54", "grey");
        clothesProducts.add(overcoat);
        Product jeans = new Clothes("Levis 300", 540.0, ClothesEnum.JEANS, "man",
                "48-52", "dark-blue");
        clothesProducts.add(jeans);
        Product cardigan_m1 = new Clothes("Card Q12", 600.0, ClothesEnum.CARDIGAN, "man",
                "48-52", "gray and red");
        clothesProducts.add(cardigan_m1);
        Product jacket_w1 = new Clothes("J-45", 450.0, ClothesEnum.JACKET, "woman",
                "38-48", "white and blue");
        clothesProducts.add(jacket_w1);
        Product trousers_m1 = new Clothes("Fashion-45", 840.0, ClothesEnum.TROUSERS, "man",
                "50-56", "grey");
        clothesProducts.add(trousers_m1);
        Product skirt_w1 = new Clothes("Miss L8", 380.0, ClothesEnum.SKIRT, "woman",
                "34-54", "red");
        clothesProducts.add(skirt_w1);
        Product shirt_m1 = new Clothes("Mister L8", 300.0, ClothesEnum.SHIRT, "man",
                "46-54", "yellow");
        clothesProducts.add(shirt_m1);
        Product dress = new Clothes("Fashio E43", 1020.0, ClothesEnum.DRESS, "woman",
                "38-44", "black");
        clothesProducts.add(dress);
        Product suit_m1 = new Clothes("Suit P1", 1560.0, ClothesEnum.SUIT, "man",
                "42-56", "grey");
        clothesProducts.add(suit_m1);
        Shop clothesShop = new Shop("DRESS CODE", 2, clothesProducts);
        shops.add(clothesShop);
        // Initializing of products for food shop
        List<Product> foodProducts = new ArrayList<>();
        Product sour_cream = new Food("Molokia 20%", 22.0, FoodEnum.MILK, 3);
        foodProducts.add(sour_cream);
        Product porridge = new Food("Hercules", 16.0, FoodEnum.CEREAL, 0);
        foodProducts.add(porridge);
        Product apple_juice = new Food("Sandora Apple", 24.0, FoodEnum.DRINK, 0);
        foodProducts.add(apple_juice);
        Product tuna = new Food("Tuna 150", 54.0, FoodEnum.CANNED_FOOD, 2);
        foodProducts.add(tuna);
        Product cake = new Food("Kyiv cake", 190.0, FoodEnum.SWEETS, 0);
        foodProducts.add(cake);
        Product beef = new Food("Beef (raw)", 120.0, FoodEnum.MEAT, 2);
        foodProducts.add(beef);
        Product papper = new Food("Papper 20g", 6.0, FoodEnum.SPICE, 0);
        foodProducts.add(papper);
        Shop foodShop = new Shop("SILPO", 1, foodProducts);
        shops.add(foodShop);
        // Initializing of products for musical shop
        List<Product> musicProducts = new ArrayList<>();
        Product violin = new MusicalInstrument("Violin", 400.0, MusicalEnum.STRING_INSTRUMENT,
                "oak");
        musicProducts.add(violin);
        Product drum = new MusicalInstrument("Big drum", 600.0, MusicalEnum.SHOCK_INSTRUMENT,
                "metal and leather");
        musicProducts.add(drum);
        Product reed_pipe = new MusicalInstrument("Reed pipe", 200.0, MusicalEnum.WIND_INSTRUMENT,
                "maple");
        musicProducts.add(violin);
        Shop musicShop = new Shop("MUSIC LIFE", 1, musicProducts);
        shops.add(musicShop);
        // Initializing of products for shoes shop
        List<Product> shoesProducts = new ArrayList<>();
        Product sneakers_w1 = new Shoes("Sneakers L201", 450.0, ShoesEnum.SHOE, "woman",
                "34-40", "red", "leather");
        shoesProducts.add(sneakers_w1);
        Product trainers_m1 = new Shoes("Trainers L301", 500.0, ShoesEnum.TRAINER, "man",
                "38-42", "dark blue", "leather");
        shoesProducts.add(trainers_m1);
        Product heel = new Shoes("Miss L-21", 1200.0, ShoesEnum.HEEL, "woman", "34-40",
                "black", "artificial leather");
        shoesProducts.add(heel);
        Product sandals = new Shoes("Sandi 35", 600.0, ShoesEnum.SANDALS, "woman",
                "34-40", "pink", "artificial leather");
        shoesProducts.add(sandals);
        Product winterbook = new Shoes("Hard 22", 960.0, ShoesEnum.WINTERBOOT, "man",
                "38-42", "brown", "leather");
        shoesProducts.add(winterbook);
        Product autmnboot_w1 = new Shoes("Autm_311", 1450.0, ShoesEnum.AUTUMNBOOT, "woman",
                "34-40", "brown", "leather");
        shoesProducts.add(autmnboot_w1);
        Product autmnboot_m1 = new Shoes("Autm_312", 1500.0, ShoesEnum.AUTUMNBOOT, "man",
                "36-44", "brown", "leather");
        shoesProducts.add(autmnboot_w1);
        Product slippers = new Shoes("Slip-66", 160.0, ShoesEnum.SLIPPERS, "unisex",
                "35-41", "dark blue", "textile");
        shoesProducts.add(slippers);
        Shop shoesShop = new Shop("SHOES WORLD", 4, shoesProducts);
        shops.add(shoesShop);
        // Initializing of products for sport shop
        List<Product> sportProducts = new ArrayList<>();
        Product basketBall = new SportGood("Ball for basketball", 250.0, SportGoodEnum.EQUIPMENT);
        sportProducts.add(basketBall);
        Product trainer_matrix = new SportGood("Matrix T1x", 15500.0, SportGoodEnum.TRAINER);
        sportProducts.add(trainer_matrix);
        Product byke_230 = new SportGood("Centurio 210", 3500.0, SportGoodEnum.BICYCLE);
        sportProducts.add(byke_230);
        Product swimsuit = new SportGood("Swimsuit E23", 620.0, SportGoodEnum.BASINGOOD);
        sportProducts.add(swimsuit);
        Product boxing_gloves = new SportGood("Boxing gloves", 300.0, SportGoodEnum.SPORT_CLOTHES);
        sportProducts.add(boxing_gloves);
        Shop sportShop = new Shop("SPORT LIFE", 2, sportProducts);
        shops.add(sportShop);
        LOG.debug("Application data was initialized successful.");
        LOG.warn("No error.");
        return shops;
    }

    public int initializeAccountSum() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(19000) + 1000;
    }

    public double moveOfGame(boolean isRealPlayer, List<Shop> shops) {

        Shop chosenShop = chooseShops(isRealPlayer, Application.getShops());
        Product chosenProduct = chooseProduct(isRealPlayer, chosenShop);
        return chosenProduct.getPrice();
    }
}
