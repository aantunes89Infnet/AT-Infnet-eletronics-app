package br.edu.infnet.eletronic_store_app.model.tests;

import br.edu.infnet.eletronic_store_app.model.domain.*;
import br.edu.infnet.eletronic_store_app.model.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {

    public static void main(String[] args) {

        Cellphone cellphone = null;
        Notebook notebook = null;
        Television television = null;

        List<Product> products = new ArrayList<Product>();

        try {
            cellphone = new Cellphone("Iphone", 7000, 1, 1);
            cellphone.setVersion("X");
            cellphone.setFaceRecognition(true);
            cellphone.setNewestModel(true);

            products.add(cellphone);
        } catch (ValueIsInvalidException | QuantityIsInvalidException | ChipsQuantityIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            notebook = new Notebook("MacBook", 12000, 1, 6);
            notebook.setDigitalRecognition(true);
            notebook.setTouchScreen(false);

            products.add(notebook);
        } catch (ValueIsInvalidException | QuantityIsInvalidException | BatteryAutonomyIsInvalidException e) {
            System.out.println(e.getMessage());
        }


        try {
            television = new Television("Samsung", 8000, 1, 70);
            television.setHasWiFi(true);
            television.setSmart(true);
            television.setScreenCurve(true);

            products.add(television);
        } catch (ValueIsInvalidException | QuantityIsInvalidException | TVIncheseIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        Client client = null;

        try {
            client = new Client("Andre", "andre@email.com", "137.510.017-25");
            client.setAge(20);
            client.setGoodScore(true);
        } catch (NameIsInvalidException | EmailIsInvalidException | CPFIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            ShoppingCart shoppingCart = new ShoppingCart(client);
            shoppingCart.setProducts(products);
            shoppingCart.printShoppingCartInfo();
        } catch (ClientIsInvalidException | ProductListIsInvalidException e) {
            System.out.println(e.getMessage());
        }

    }
}
