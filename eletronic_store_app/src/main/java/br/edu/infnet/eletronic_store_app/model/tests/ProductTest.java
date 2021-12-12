package br.edu.infnet.eletronic_store_app.model.tests;

import br.edu.infnet.eletronic_store_app.model.domain.Cellphone;
import br.edu.infnet.eletronic_store_app.model.domain.Notebook;
import br.edu.infnet.eletronic_store_app.model.domain.Product;
import br.edu.infnet.eletronic_store_app.model.domain.Television;
import br.edu.infnet.eletronic_store_app.model.exceptions.*;

public class ProductTest {

    public static void main(String[] args) {

//        try {
//            Product product = new Product("Iphone", 7000, 1);
//            System.out.println(product);
//        } catch (ValueIsInvalidException | QuantityIsInvalidException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            Product product = new Product("Iphone", 0, 1);
//            System.out.println(product);
//        } catch (ValueIsInvalidException | QuantityIsInvalidException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            Product product = new Product("Iphone", -1, 1);
//            System.out.println(product);
//        } catch (ValueIsInvalidException | QuantityIsInvalidException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            Product product = new Product("Iphone", 7000, 0);
//            System.out.println(product);
//        } catch (ValueIsInvalidException | QuantityIsInvalidException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            Product product = new Product("Iphone", 7000, -1);
//            System.out.println(product);
//        } catch (ValueIsInvalidException | QuantityIsInvalidException e) {
//            System.out.println(e.getMessage());
//        }

        try {
            Cellphone cellphone = new Cellphone("Iphone", 7000, 1, 1);
            cellphone.setVersion("X");
            cellphone.setFaceRecognition(true);
            cellphone.setNewestModel(true);
            System.out.println(cellphone);
        } catch (ValueIsInvalidException | QuantityIsInvalidException | ChipsQuantityIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            Notebook notebook = new Notebook("MacBook", 12000, 1, 6);
            notebook.setDigitalRecognition(true);
            notebook.setTouchScreen(false);
            System.out.println(notebook);
        } catch (ValueIsInvalidException | QuantityIsInvalidException | BatteryAutonomyIsInvalidException e) {
            System.out.println(e.getMessage());
        }


        try {
            Television television = new Television("Samsung", 8000, 1, 70);
            television.setHasWiFi(true);
            television.setSmart(true);
            television.setScreenCurve(true);
            System.out.println(television);
        } catch (ValueIsInvalidException | QuantityIsInvalidException | TVIncheseIsInvalidException e) {
            System.out.println(e.getMessage());
        }


    }
}
