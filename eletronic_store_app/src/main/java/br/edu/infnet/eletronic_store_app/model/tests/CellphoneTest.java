package br.edu.infnet.eletronic_store_app.model.tests;

import br.edu.infnet.eletronic_store_app.model.domain.Cellphone;
import br.edu.infnet.eletronic_store_app.model.exceptions.ChipsQuantityIsInvalidException;
import br.edu.infnet.eletronic_store_app.model.exceptions.QuantityIsInvalidException;
import br.edu.infnet.eletronic_store_app.model.exceptions.ValueIsInvalidException;

public class CellphoneTest {

    public static void main(String[] args) {

        try {
            Cellphone cellphone = new Cellphone("Iphone", 7000, 1, 1);
            cellphone.setVersion("X");
            cellphone.setFaceRecognition(true);
            cellphone.setNewestModel(true);

            System.out.println("Valor de Venda: " + cellphone.calculateProductTotalValue());
            // (7000 * 1)
        } catch (ValueIsInvalidException | QuantityIsInvalidException | ChipsQuantityIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            Cellphone cellphone = new Cellphone("Samsung", 3000, 1, 2);
            cellphone.setVersion("X");
            cellphone.setFaceRecognition(true);
            cellphone.setNewestModel(true);

            System.out.println("Valor de Venda: " + cellphone.calculateProductTotalValue());
            // (3000 * 1) + 200 = 3200
        } catch (ValueIsInvalidException | QuantityIsInvalidException | ChipsQuantityIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            Cellphone cellphone = new Cellphone("Iphone", 7000, 1, 0);
            cellphone.setVersion("X");
            cellphone.setFaceRecognition(true);
            cellphone.setNewestModel(true);
            System.out.println(cellphone);
        } catch (ValueIsInvalidException | QuantityIsInvalidException | ChipsQuantityIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            Cellphone cellphone = new Cellphone("Iphone", 7000, 1, -1);
            cellphone.setVersion("X");
            cellphone.setFaceRecognition(true);
            cellphone.setNewestModel(true);
            System.out.println(cellphone);
        } catch (ValueIsInvalidException | QuantityIsInvalidException | ChipsQuantityIsInvalidException e) {
            System.out.println(e.getMessage());
        }


    }
}
