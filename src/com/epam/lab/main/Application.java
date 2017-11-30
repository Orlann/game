package com.epam.lab.main;

import com.epam.lab.domain.goods.Product;
import com.epam.lab.domain.shops.Shop;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class Application {
    private static final Logger LOG = Logger.getLogger(Application.class);
    private static Player gamePlayer;
    private static List<Shop> shops;
    private static double accountSum;

    public static void main(String[] args) {
        Manager manager = new Manager();
        Player player = new Player();
        try {
            gamePlayer = manager.setPlayer(player);
        } catch (IOException e) {
            System.out.printf("IO Exception occured");
        }
        System.out.println(player);
        setGamePlayer(gamePlayer);
        LOG.info("Game Player was created. From LOGGER!");
        LOG.debug("We are debaging" );

        setAccountSum((double) manager.initializeAccountSum());
        System.out.println(String.format("\nACCOUNT SUM IS %d \n", (int)accountSum));
        setShops(manager.initializeShops());
        boolean isRealPlayer = true;
        do {
            double productCost = manager.moveOfGame(isRealPlayer, shops);
            isRealPlayer = !isRealPlayer;
            accountSum -= productCost;
        } while (accountSum > 0);
        if(isRealPlayer){
            System.out.println(String.format("\nGAME OVER\t\tGAME OVER\t\tGAME OVER\n%s WIN\t\t%s WIN\t\t%s WIN",
                    player.getSex().toUpperCase(),player.getSex().toUpperCase(),player.getSex().toUpperCase()));
        }else {
            System.out.println(String.format("\nGAME OVER\t\tGAME OVER\t\tGAME OVER\n%s LOST\t\t%s LOST\t\t%s LOST",
                    player.getSex().toUpperCase(),player.getSex().toUpperCase(),player.getSex().toUpperCase()));
        }

    }

    public static Player getGamePlayer() {
        return gamePlayer;
    }

    public static void setGamePlayer(Player gamePlayer) {
        Application.gamePlayer = gamePlayer;
    }

    public static List<Shop> getShops() {
        return shops;
    }

    public static void setShops(List<Shop> shops) {
        Application.shops = shops;
    }

    public static Double getAccountSum() {
        return accountSum;
    }

    public static void setAccountSum(Double accountSum) {
        Application.accountSum = accountSum;
    }
}
