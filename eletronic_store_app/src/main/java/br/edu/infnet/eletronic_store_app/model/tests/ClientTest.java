package br.edu.infnet.eletronic_store_app.model.tests;

import br.edu.infnet.eletronic_store_app.model.domain.Client;
import br.edu.infnet.eletronic_store_app.model.exceptions.CPFIsInvalidException;
import br.edu.infnet.eletronic_store_app.model.exceptions.EmailIsInvalidException;
import br.edu.infnet.eletronic_store_app.model.exceptions.NameIsInvalidException;

public class ClientTest {

    public static void main(String[] args) {

        try {
            Client client = new Client("Andre", "andre@email.com", "137.510.017-25");
            client.setAge(20);
            client.setGoodScore(true);
        } catch (NameIsInvalidException | EmailIsInvalidException | CPFIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            Client client = new Client(null, "andre@email.com", "137.510.017-25");
            client.setAge(20);
            client.setGoodScore(true);
        } catch (NameIsInvalidException | EmailIsInvalidException | CPFIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            Client client = new Client("Andre", null, "137.510.017-25");
            client.setAge(20);
            client.setGoodScore(true);
        } catch (NameIsInvalidException | EmailIsInvalidException | CPFIsInvalidException e) {
            System.out.println(e.getMessage());
        }

        try {
            Client client = new Client("Andre", "andre@email.com", null);
            client.setAge(20);
            client.setGoodScore(true);
        } catch (NameIsInvalidException | EmailIsInvalidException | CPFIsInvalidException e) {
            System.out.println(e.getMessage());
        }



    }
}
