package br.edu.infnet.eletronic_store_app.model.tests;

import br.edu.infnet.eletronic_store_app.model.domain.Notebook;
import br.edu.infnet.eletronic_store_app.model.exceptions.BatteryAutonomyIsInvalidException;
import br.edu.infnet.eletronic_store_app.model.exceptions.QuantityIsInvalidException;
import br.edu.infnet.eletronic_store_app.model.exceptions.ValueIsInvalidException;

public class NotebookTest {

    public static void main(String[] args) {

        try {
            Notebook notebook = new Notebook("MacBook", 12000, 1, 7);
            notebook.setDigitalRecognition(true);
            notebook.setTouchScreen(false);

            System.out.println("Valor do notebook: R$" + notebook.calculateProductTotalValue());
            // 12000 * 1 + 500 = 12500
        } catch (ValueIsInvalidException | QuantityIsInvalidException | BatteryAutonomyIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            Notebook notebook = new Notebook("MacBook", 12000, 1, 5);
            notebook.setDigitalRecognition(true);
            notebook.setTouchScreen(false);

            System.out.println("Valor do notebook: R$" + notebook.calculateProductTotalValue());
            // 12000 * 1 + 500 = 12000
        } catch (ValueIsInvalidException | QuantityIsInvalidException | BatteryAutonomyIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            Notebook notebook = new Notebook("MacBook", 12000, 1, 0);
            notebook.setDigitalRecognition(true);
            notebook.setTouchScreen(false);
            System.out.println(notebook);
        } catch (ValueIsInvalidException | QuantityIsInvalidException | BatteryAutonomyIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            Notebook notebook = new Notebook("MacBook", 12000, 1, -1);
            notebook.setDigitalRecognition(true);
            notebook.setTouchScreen(false);
            System.out.println(notebook);
        } catch (ValueIsInvalidException | QuantityIsInvalidException | BatteryAutonomyIsInvalidException e) {
            System.out.println(e.getMessage());
        }



    }
}
