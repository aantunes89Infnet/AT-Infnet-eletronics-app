package br.edu.infnet.eletronic_store_app.model.tests;

import br.edu.infnet.eletronic_store_app.model.domain.*;
import br.edu.infnet.eletronic_store_app.model.exceptions.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileShoppingCartTest {

    public static void main(String[] args) {

        try {

            String inputFile = "products.txt";

            FileReader fileReader = new FileReader(inputFile);
            BufferedReader reader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter("out_"+ inputFile);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            String line = reader.readLine();

            String[] fields = null;

            Client client = null;
            ShoppingCart shoppingCart = null;


            List<Product> products = new ArrayList<Product>();

            while(line != null) {
                fields = line.split(";");
                String type = fields[0];

                switch (type.toUpperCase()) {
                    case "S":

                        try {
                            client = new Client(fields[1], fields[2], fields[3]);
                        } catch (NameIsInvalidException | EmailIsInvalidException | CPFIsInvalidException e) {
                            System.out.println(e.getMessage());
                        }

                        try {
                            shoppingCart = new ShoppingCart(client);
                            shoppingCart.setProducts(products);
                        } catch (ClientIsInvalidException e) {
                            System.out.println(e.getMessage());
                        }


                        break;

                    case "C":

                        try {
                            Cellphone cellphone = new Cellphone(
                                    fields[1],
                                    Float.valueOf(fields[2]) ,
                                    Integer.valueOf(fields[3]),
                                    Integer.valueOf(fields[4]));
                            cellphone.setVersion(fields[5]);
                            cellphone.setFaceRecognition(Boolean.valueOf(fields[6]));
                            cellphone.setNewestModel(Boolean.valueOf(fields[7]));

                            products.add(cellphone);
                        } catch (ValueIsInvalidException | QuantityIsInvalidException | ChipsQuantityIsInvalidException e) {
                            System.out.println(e.getMessage());
                        }

                        break;

                    case "N":

                        try {
                            Notebook notebook = new Notebook(
                                    fields[1],
                                    Float.valueOf(fields[2]) ,
                                    Integer.valueOf(fields[3]),
                                    Integer.valueOf(fields[4]));
                            notebook.setDigitalRecognition(Boolean.valueOf(fields[5]));
                            notebook.setTouchScreen(Boolean.valueOf(fields[6]));

                            products.add(notebook);
                        } catch (ValueIsInvalidException | QuantityIsInvalidException | BatteryAutonomyIsInvalidException e) {
                            System.out.println(e.getMessage());
                        }

                        break;

                    case "T":
                        try {
                            Television television = new Television(
                                    fields[1],
                                    Float.valueOf(fields[2]) ,
                                    Integer.valueOf(fields[3]),
                                    Integer.valueOf(fields[4]));

                            television.setHasWiFi(Boolean.valueOf(fields[5]));
                            television.setSmart(Boolean.valueOf(fields[6]));
                            television.setScreenCurve(Boolean.valueOf(fields[7]));

                            products.add(television);
                        } catch (ValueIsInvalidException | QuantityIsInvalidException | TVIncheseIsInvalidException e) {
                            System.out.println(e.getMessage());
                        }

                        break;

                    default:
                        System.out.println("Tipo invalido: " + type);
                        break;
                }

                line = reader.readLine();
            }

            try {
                shoppingCart.printShoppingCartInfo();
                writer.write(shoppingCart.writeLineInFile());
            } catch ( ProductListIsInvalidException e) {
                System.out.println(e.getMessage());
            }

            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
