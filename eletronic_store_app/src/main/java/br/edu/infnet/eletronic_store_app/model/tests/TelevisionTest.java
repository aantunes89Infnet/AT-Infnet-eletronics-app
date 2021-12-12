package br.edu.infnet.eletronic_store_app.model.tests;

import br.edu.infnet.eletronic_store_app.model.domain.Television;
import br.edu.infnet.eletronic_store_app.model.exceptions.QuantityIsInvalidException;
import br.edu.infnet.eletronic_store_app.model.exceptions.TVIncheseIsInvalidException;
import br.edu.infnet.eletronic_store_app.model.exceptions.ValueIsInvalidException;

public class TelevisionTest {

    public static void main(String[] args) {

        try {
            Television television = new Television("Samsung", 8000, 1, 70);
            television.setHasWiFi(true);
            television.setSmart(true);
            television.setScreenCurve(true);

            System.out.println("Valor da TV: R$" + television.calculateProductTotalValue());
            // (8000 * 1) + 1500 = 9500
        } catch (ValueIsInvalidException | QuantityIsInvalidException | TVIncheseIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            Television television = new Television("Samsung", 8000, 1, 70);
            television.setHasWiFi(false);
            television.setSmart(false);
            television.setScreenCurve(false);

            System.out.println("Valor da TV: R$" + television.calculateProductTotalValue());
            // (8000 * 1) = 8000
        } catch (ValueIsInvalidException | QuantityIsInvalidException | TVIncheseIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            Television television = new Television("Samsung", 8000, 1, 70);
            television.setHasWiFi(true);
            television.setSmart(false);
            television.setScreenCurve(false);

            System.out.println("Valor da TV: R$" + television.calculateProductTotalValue());
            // (8000 * 1) = 8500
        } catch (ValueIsInvalidException | QuantityIsInvalidException | TVIncheseIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            Television television = new Television("Samsung", 8000, 1, 70);
            television.setHasWiFi(false);
            television.setSmart(true);
            television.setScreenCurve(false);

            System.out.println("Valor da TV: R$" + television.calculateProductTotalValue());
            // (8000 * 1) = 8700
        } catch (ValueIsInvalidException | QuantityIsInvalidException | TVIncheseIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            Television television = new Television("Samsung", 8000, 1, 70);
            television.setHasWiFi(false);
            television.setSmart(false);
            television.setScreenCurve(true);

            System.out.println("Valor da TV: R$" + television.calculateProductTotalValue());
            // (8000 * 1) = 8300
        } catch (ValueIsInvalidException | QuantityIsInvalidException | TVIncheseIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            Television television = new Television("Samsung", 8000, 1, 0);
            television.setHasWiFi(true);
            television.setSmart(true);
            television.setScreenCurve(true);
            System.out.println(television);
        } catch (ValueIsInvalidException | QuantityIsInvalidException | TVIncheseIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            Television television = new Television("Samsung", 8000, 1, -1);
            television.setHasWiFi(true);
            television.setSmart(true);
            television.setScreenCurve(true);
            System.out.println(television);
        } catch (ValueIsInvalidException | QuantityIsInvalidException | TVIncheseIsInvalidException e) {
            System.out.println(e.getMessage());
        }


    }
}
